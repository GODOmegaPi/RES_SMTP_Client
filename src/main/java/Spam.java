import java.io.IOException;
import java.util.ArrayList;

public class Spam {
    private String hostname;
    private int port;
    private String sender;
    private ArrayList<String> receivers;
    private String title;
    private String message;

    private final int DELAY = 10000;

    public Spam(String hostname, int port, String sender, ArrayList<String> receivers, String title, String message) {
        this.hostname = hostname;
        this.port = port;
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.message = message;
    }

    public void start(){
        Client client = new Client();

        for(String to : receivers) {
            try {
                client.startConnection(this.hostname, this.port);
                client.sendMessage("EHLO " + this.hostname);

                client.sendMessage("AUTH LOGIN");
                client.sendMessage("MTUzOGIyMTliNzUxNjM=");
                client.sendMessage("ODY2ODk0ODY3ZjIwMDY=");

                client.sendMessage("MAIL FROM: <" + this.sender + ">");
                client.sendMessage("RCPT TO: <" + to + ">");
                client.sendMessage("DATA");
                client.sendMessage("To: " +to + "\n" +
                        "From: " + this.sender + "\n" +
                        "Subject: " + this.title + "\n" +
                        "\n" +
                        this.message + "\n" +
                        ".");
                client.sendMessage("quit");
                client.stopConnection();

                System.out.println("Message sent to: " + to);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
