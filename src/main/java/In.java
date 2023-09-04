import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class In {
    private final BufferedReader reader;

    public In(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
    
    public void close() throws IOException{
        reader.close();
    }
}