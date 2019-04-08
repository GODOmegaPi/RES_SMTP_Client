import org.junit.Test;

import static junit.framework.TestCase.*;

import java.util.ArrayList;

public class EmailListTest {

    @Test
    public void loadEmailList() {
        String configPath = "emailsExample.txt";
        ArrayList<String> expected  = new ArrayList<String>();
        EmailList emailList =  new EmailList(configPath);
        assertEquals(39, emailList.getEmails().size());
    }
}
