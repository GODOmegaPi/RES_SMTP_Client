import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Application {
    private final static Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        String emailsPath = "emailsExample.txt";
        String messagesPath = "messagesExample.txt";

        EmailList emailList = new EmailList(emailsPath);

        int groupNb = Integer.parseInt(args[0]);
        int emailListSize = emailList.getEmails().size();

        // if there would be groups too small
        if(3 * groupNb > emailListSize) {
            System.out.println("You have requested " + groupNb + " groups for only " + emailListSize + " emails\n");
            System.out.println("Please, specify a number of group leaving at least 3 emails by groups");
            return;
        }

        ArrayList<Group> groups = Group.createGroups(groupNb, new EmailList(emailsPath), new MessageList(messagesPath));

        System.out.println("Les groupes :");
        System.out.println(groups);

        /*try {
            Client client = new Client();
            client.startConnection("smtp.mailtrap.io", 2525);
            client.sendMessage("EHLO smtp.mailtrap.io");
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }
}
