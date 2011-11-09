

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailItemTest
{

    private MailItem mail1; 
    
    /**
     * Default constructor for test class MailItemTest
     */
    public MailItemTest()
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
       mail1 = new MailItem("Martin", "Mr.X", "test", "Hej!");
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
    public void testMailItem()
    {
        assertEquals("Martin",mail1.getFrom());
        assertEquals("Mr.X",mail1.getTo());
        assertEquals("test",mail1.getSubject());
        assertEquals("Hej!",mail1.getMessage());
    }
}
