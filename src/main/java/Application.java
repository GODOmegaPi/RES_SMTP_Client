import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args){
        ArrayList<String> receivers = new ArrayList<String>();
        receivers.add("receiver1@gmail.com");
        receivers.add("receiver2@gmail.com");
        receivers.add("receiver3@gmail.com");
        receivers.add("receiver4@gmail.com");

        Spam spam = new Spam("smtp.mailtrap.io", 2525, "sender@gmail.com", receivers, "Test Spam", "This is a test email spam.");
        spam.setAuthInfos("MTUzOGIyMTliNzUxNjM=", "ODY2ODk0ODY3ZjIwMDY=");
        spam.start();
    }
}
