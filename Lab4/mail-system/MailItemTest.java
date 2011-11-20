

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
    public void testAccessors()
    {
        MailItem mail1 = new MailItem("FROM", "TO", "SUBJECT", "BODY");
        assertEquals("FROM",mail1.getFrom());
        assertEquals("TO",mail1.getTo()[0]);
        assertEquals("SUBJECT",mail1.getSubject());
        assertEquals("BODY",mail1.getMessage());
    }
}
