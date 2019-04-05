import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Group {
    private Message message;
    private String sender;
    private ArrayList<String> recipients = new ArrayList<String>();

    public static ArrayList<Group> createGroups(int nbGroup, EmailList emailList, MessageList messageList) {
        ArrayList<Group> groups = new ArrayList<Group>();
        ArrayList<String> emails = emailList.getEmails();
        ArrayList<Message> messages = messageList.getMessages();
        Iterator<String> emailIterator = emails.iterator();

        for(int i = 0; i < nbGroup; ++i) {
            // create a new group with a sender
            groups.add(new Group(emailIterator.next()));

            // add message
            groups.get(i).setMessage(messages.get(i % messages.size()));
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

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public String toString() {
        String result = "--------\nSender :\n" + sender + "\n\nRecipients :\n";
        Iterator<String> it = getRecipients().iterator();

        while(it.hasNext()) {
            result += it.next() + "\n";
        }

        result += "\nMessage :\n" + message;

        return result;
    }
}
