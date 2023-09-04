import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        String screenName = args[0];
        String host = args[1];
        int port = 4444;

        // Conecta ao servidor e abre os streams
        Socket socket = new Socket(host, port);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        In in = new In(socket);
        Out out = new Out(socket);
        System.err.println("Conectado a " + host + " na porta " + port);

        // Thread para ler mensagens do servidor e imprimir na saída padrão
        Thread serverReaderThread = new Thread(() -> {
            try {
                String serverResponse;
                while ((serverResponse = in.readLine()) != null) {
                    System.out.println(serverResponse);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serverReaderThread.start();

        // Lê da entrada padrão, envia e escreve resposta
        String line;
        while ((line = stdin.readLine()) != null) {
            // Leitura da entrada padrão
            out.println("[" + screenName + "]: " + line);
        }

        // Encerra os sockets
        System.err.println("Conexão com " + host + " encerrada");
        out.close();
        in.close();
        socket.close();
    }
}
