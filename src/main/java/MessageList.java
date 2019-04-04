import java.io.*;
import java.util.ArrayList;

public class MessageList {
    private ArrayList<String> messageList = new ArrayList<String>();

    public MessageList(String path) {
        File file = new File(path);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };

        String message = "";
        String line = "";

        try {
           while((line = br.readLine()) != null) {
                // each messages end with ---
                if("---".equals(line)) {
                    messageList.add(message);

                    // reset message
                    message = "";
                } else {
                    message += line;
                }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getMessages() {
        return messageList;
    }
}
