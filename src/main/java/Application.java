import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String emailsPath   = "emails.txt";
        String messagesPath = "messages.txt";

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

        for(Group group : groups) {
            Spam spam = new Spam("smtp.mailtrap.io", 2525, group);
            spam.setAuthInfos("MTUzOGIyMTliNzUxNjM=", "ODY2ODk0ODY3ZjIwMDY=");
            spam.start();
        }
    }
}
