import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MessageListTest {

    @Test
    public void loadMessageList() {
        String configPath = "messagesExample.txt";
        ArrayList<String> expected  = new ArrayList<String>();
        MessageList messageList =  new MessageList(configPath);
        assertEquals(3, messageList.getMessages().size());
    }
}
