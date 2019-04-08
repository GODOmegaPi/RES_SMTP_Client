import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class GroupTest {

    @Test
    public void groups() {
        EmailList emailList = new EmailList("src/test/resources/emailsExample.txt");
        MessageList messageList = new MessageList("src/test/resources/messagesExample.txt");
        ArrayList<Group> groups = Group.createGroups(10, emailList, messageList);

        for(Group group : groups) {
            ArrayList<String> recipients = group.getRecipients();
            String sender = group.getSender();

            // principe des tiroirs de Dirichlet :
            // il y aura au moins ceil(n/m) objets dans m boîtes
            // ici on doit avoir au moins ceil(n/m) - nb d'expéditeur, emails dans la liste d'émails récepteurs
            assertFalse(recipients.size() < (Math.ceil(emailList.getEmails().size() / groups.size()) - groups.size()));
            assertFalse("".equals(sender));
        }
    }
}
