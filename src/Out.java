import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Out {

    private final PrintWriter writer;

    public Out(Socket socket) throws IOException {
        writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void println(String message) {
        writer.println(message);
    }

    public void close() {
        writer.close();
    }
}
