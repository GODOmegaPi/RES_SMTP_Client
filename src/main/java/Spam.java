import java.io.IOException;

public class Spam {
    private String hostname;
    private int port;
    private Group group;

    private boolean useAuth;
    private String authLogin;
    private String authPassword;

    private final int DELAY = 5000;

    public Spam(String hostname, int port, Group group) {
        this.hostname = hostname;
        this.port = port;
        this.group = group;
        this.useAuth = false;
    }

    public void setAuthInfos(String authLogin, String authPassword) {
        this.useAuth = true;
        this.authLogin = authLogin;
        this.authPassword = authPassword;
    }

    public void start() {
        Client client = new Client();

        try {
            client.startConnection(this.hostname, this.port);
            client.sendMessage("EHLO " + this.hostname);

            for (String to : this.group.getRecipients()) {
                if (this.useAuth) {
                    client.sendMessage("AUTH LOGIN");
                    client.sendMessage(this.authLogin);
                    client.sendMessage(this.authPassword);
                }

                client.sendMessage("MAIL FROM: <" + this.group.getSender() + ">");
                client.sendMessage("RCPT TO: <" + to + ">");
                client.sendMessage("DATA");
                client.sendMessage("To: " + to + "\r\n" +
                        "From: " + this.group.getSender() + "\r\n" +
                        "Subject: " + this.group.getMessage().getTitle() + "\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        this.group.getMessage().getContent() +
                        "\r\n.");

                System.out.println("Message sent to: " + to);

                try {
                    Thread.sleep(DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            client.sendMessage("QUIT");
            client.stopConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
