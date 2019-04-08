import java.util.ArrayList;

public class Application {
    private static final String EMAILS_PATH = "emailsExample.txt";
    private static final String MESSAGES_PATH = "messagesExample.txt";
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 2525;

    private static final boolean USE_AUTH = false;
    private static final String AUTH_LOGIN = "";
    private static final String AUTH_PASSWORD = "";

    public static void main(String[] args){
        String emailsPath = EMAILS_PATH;
        String messagesPath = MESSAGES_PATH;

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
            Spam spam = new Spam(SERVER_IP, SERVER_PORT, group);
            if(USE_AUTH) {
                spam.setAuthInfos(AUTH_LOGIN, AUTH_PASSWORD);
            }
            spam.start();
        }
    }
}
