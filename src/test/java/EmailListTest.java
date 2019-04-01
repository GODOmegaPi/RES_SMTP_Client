import org.junit.Test;

import static junit.framework.TestCase.*;

import java.util.ArrayList;

public class EmailListTest {

    @Test
    public void loadEmailList() {
        String configPath = "emails.txt";
        ArrayList<String> expected  = new ArrayList<String>();
        expected.add("simon.walther@heig-vd.ch");
        expected.add("guillaume.laubscher@heig-vd.ch");
        expected.add("alexandre.monteiromarques@heig-vd.ch");
        EmailList emailList =  new EmailList(configPath);
        assertEquals(expected, emailList.getEmails());
    }
}
