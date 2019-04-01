import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final String CRLF = "\r\n";

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void sendMessage(String msg) throws IOException {
        System.out.println(msg);
        out.print(msg + CRLF);
        out.flush();
        String resp;
        while((resp = in.readLine()) != null && !matchEndOfInstrcutions(resp)){
            System.out.println(resp);
        }
        System.out.println(resp);
    }

    public boolean matchEndOfInstrcutions(String instruction){
        if (instruction.startsWith("250 ")){
            return true;
        }else if (instruction.startsWith("334 ")){
            return true;
        }else if (instruction.startsWith("235 ")){
            return true;
        }else if (instruction.startsWith("354 ")){
            return true;
        }else if (instruction.startsWith("221 ")){
            return true;
        }

        return false;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
