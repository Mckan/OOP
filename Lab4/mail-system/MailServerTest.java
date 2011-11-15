

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailServerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailServerTest
{
    private MailServer mailServer;
    private MailItem messEmptyFrom;
    private MailItem messEmptyTo;
    private MailItem mess1User1to2;
    private MailItem mess2User1to2;
    private MailItem messTwoReceivers;
    private MailItem messUnknownReceiver;
    private MailItem messSpamSubj;
    private MailItem messSpamBody;

    
    
    /**
     * Default constructor for test class MailServerTest
     */
    public MailServerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        mailServer = new MailServer();
        //mailServer.createMailbox("user1");
        //mailServer.createMailbox("user2"); 
        //mailServer.createMailbox("user3");
        
        messEmptyFrom = new MailItem("", "foo", "", "");
        messEmptyTo = new MailItem("foo", "", "", "");
        
        mess1User1to2 = new MailItem("user1", "user2", "1", "");
        mess2User1to2 = new MailItem("user1", "user2", "2", "");
        
        //messTwoReceivers = new MailItem("user1", "user2, user3", "", "");
        //messUnknownReceiver = new MailItem("user1", "unknown", "foo", "bar"); 
        
        //messSpamSubj = new MailItem("user1", "user2", "xxxSpAmyyy", ""); 
        //messSpamBody = new MailItem("user1", "user2", "", "xxxvI a Gr @A yyy");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testEmptyFrom()
    {
        mailServer.post(messEmptyFrom);
        assertEquals(0, mailServer.howManyMessages());
    }

    @Test
    public void testEmptyTo()
    {
        mailServer.post(messEmptyTo);
        assertEquals(0, mailServer.howManyMessages());
    }

    @Test
    public void testMessageRemoval()
    {
        mailServer.post(mess1User1to2);
        mailServer.post(mess2User1to2);
        
        mailServer.getNextMailItem("user2");
        assertEquals(1, mailServer.howManyMessages());
    }
}



