import java.io.IOException;
import java.util.logging.Logger;

public class Application {
    private final static Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args){
        try {
            Client client = new Client();
            client.startConnection("smtp.mailtrap.io", 2525);
            client.sendMessage("EHLO smtp.mailtrap.io");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
