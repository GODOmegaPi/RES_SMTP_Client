import java.io.IOException;

public class Application {
    public static void main(String[] args){
        try {
            Client client = new Client();
            client.startConnection("smtp.mailtrap.io", 2525);
            client.sendMessage("EHLO smtp.mailtrap.io");

            client.sendMessage("AUTH LOGIN");
            client.sendMessage("MTUzOGIyMTliNzUxNjM=");
            client.sendMessage("ODY2ODk0ODY3ZjIwMDY=");

            client.sendMessage("MAIL FROM: <from@smtp.mailtrap.io>");
            client.sendMessage("RCPT TO: <to@smtp.mailtrap.io>");
            client.sendMessage("DATA");
            client.sendMessage("To: to@smtp.mailtrap.io\n" +
                    "From: from@smtp.mailtrap.io\n" +
                    "Subject: Hello world!\n" +
                    "\n" +
                    "This is the test message...\n" +
                    ".");
            client.sendMessage("quit");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
