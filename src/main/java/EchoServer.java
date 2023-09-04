import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
    private static final int port = 4444;
    private static final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.err.println("Servidor iniciado na porta " + port);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.err.println("Conexão aceita de um cliente");

                    // Cria um novo thread para lidar com o cliente
                    Thread clientThread = new Thread(new ClientHandler(clientSocket));
                    clientThread.start();
                } catch (IOException e) {
                    System.err.println("Erro ao lidar com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }

    // Método para enviar uma mensagem para todos os clientes conectados
    public static synchronized void broadcastMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }

    // Classe interna para lidar com cada cliente
    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Adiciona o PrintWriter do cliente à lista
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Cliente: " + inputLine);
                    // Envia a mensagem para todos os clientes conectados
                    broadcastMessage(inputLine);
                }

                // Remove o PrintWriter do cliente da lista
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }

                System.err.println("Conexão com o cliente encerrada");
            } catch (IOException e) {
                System.err.println("Erro ao lidar com o cliente: " + e.getMessage());
            }
        }
    }
}
