import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Group {
    private String sender;
    private ArrayList<String> recipients = new ArrayList<>();

    public static ArrayList<Group> createGroups(int nbGroup, EmailList emailList) {
        ArrayList<Group> groups = new ArrayList<Group>();
        ArrayList<String> emails = emailList.getEmails();
        Iterator<String> emailIterator = emails.iterator();

        for(int i = 0; i < nbGroup; ++i) {
            // create a new group with a sender
            groups.add(new Group(emailIterator.next()));
        }

        // add recipients
        for(int i = nbGroup; i < emails.size(); ++i) {
            String email = emailIterator.next();
            groups.get(i % nbGroup).addRecipient(email);
        }

        return groups;
    }

    public Group(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void addRecipient(String recipient) {
        this.recipients.add(recipient);
    }

    public String toString() {
        String result = "--------\nSender :\n" + sender + "\n\nRecipients :\n";
        Iterator<String> it = getRecipients().iterator();

        while(it.hasNext()) {
            result += it.next() + "\n";
        }

        return result;
    }
}
