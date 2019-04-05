import java.io.*;
import java.util.ArrayList;

public class EmailList {
    private ArrayList<String> emailList = new ArrayList<String>();

    public EmailList(String path) {
        File file = new File(path);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        };

        String email;

        try {
           while((email = br.readLine()) != null) {
                emailList.add(email);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getEmails() {
        return emailList;
    }
}
