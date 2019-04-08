import java.io.*;
import java.util.ArrayList;

public class EmailList {
    private ArrayList<String> emailList = new ArrayList<String>();

    public ArrayList<String> getEmails() {
        return emailList;
    }

    public EmailList(String path) {
        InputStream in = EmailList.class.getResourceAsStream("/" + path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String email;

        try {
            while((email = br.readLine()) != null) {
                emailList.add(email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
