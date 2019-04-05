import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args){
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
      
        ArrayList<String> receivers = new ArrayList<String>();
        receivers.add("receiver1@gmail.com");
        receivers.add("receiver2@gmail.com");
        receivers.add("receiver3@gmail.com");
        receivers.add("receiver4@gmail.com");

        Spam spam = new Spam("smtp.mailtrap.io", 2525, "sender@gmail.com", receivers, "Test Spam", "This is a test email spam.");
        spam.setAuthInfos("MTUzOGIyMTliNzUxNjM=", "ODY2ODk0ODY3ZjIwMDY=");
        spam.start();
      
        ArrayList<Group> groups = Group.createGroups(groupNb, new EmailList(emailsPath), new MessageList(messagesPath));

        System.out.println("Les groupes :");
        System.out.println(groups);
    }
}
