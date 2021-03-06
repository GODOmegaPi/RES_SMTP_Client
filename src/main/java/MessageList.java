import java.io.*;
import java.util.ArrayList;

public class MessageList {
    private ArrayList<Message> messageList = new ArrayList<Message>();

    public MessageList(String path) {
        InputStream in = MessageList.class.getResourceAsStream("/" + path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String message = "";
        String line = "";
        String title = "";
        boolean isTitle = true;

        try {
           while((line = br.readLine()) != null) {
                // each messages end with ---
                if("---".equals(line)) {
                    messageList.add(new Message(title, message));

                    // reset message
                    message = "";

                    // next line is a title
                    isTitle = true;
                } else if(isTitle) {
                   title = line;
                   isTitle = false;
                } else {
                    message += line + "\n";
                }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Message> getMessages() {
        return messageList;
    }
}
