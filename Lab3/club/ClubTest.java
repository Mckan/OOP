import java.util.ArrayList;

/**
 * The test class ClubTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubTest extends junit.framework.TestCase
{
    private Club club;
    private Membership mem1;
    private Membership mem2;
    private Membership mem3;
    private Membership mem4;
    private Membership mem1_double;
    
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    public void setUp()
    {
        club = new Club();
        mem1 = new Membership("mem1", "mem1@mail.com", 6, 10);
        mem1_double = new Membership("mem1_double", "mem1@mail.com", 6, 10);
        mem2 = new Membership("mem2", "mem2@mail.com", 6, 10);
        mem3 = new Membership("mem3", "mem3@mail.com", 3, 10);
        mem4 = new Membership("mem4", "mem4@mail.com", 6, 11);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    public void tearDown()
    {
    }
    
    public void testGetEmailAdresses()
    {
        club.join(mem1);
        club.join(mem2);
        assertEquals("mem1@mail.com,mem2@mail.com", club.getEmailAdresses());
    }
    
    public void testJoinAndNumberOfMembers()
    {
        club.join(mem1);
        club.join(mem2);
        assertEquals(2, club.numberOfMembers());
    }
    
    public void testJoinAndNumberOfMembersFail()
    {
        club.join(mem1);
        club.join(mem1_double);
        assertEquals(1, club.numberOfMembers());
    }
    
    public void testJoinedInMonth()
    {
        club.join(mem1);
        club.join(mem2);
        club.join(mem3);
        assertEquals(2, club.joinedInMonth(06, 10));
    }
    
    public void testPurge()
    {
        club.join(mem1);
        club.join(mem2);
        club.join(mem3);
        club.join(mem4);
        
        ArrayList<Membership> purgedMembers = club.purge(6, 10);
        
        assertEquals("Size of returned list is wrong", 2, purgedMembers.size());
        assertEquals("Size of orginal list is wrong", 2, club.numberOfMembers());
    }
    
    public void testPurgeFail()
    {
        club.join(mem1);
        
        ArrayList<Membership> purgedMembers = club.purge(13, 10);
        assertNull(purgedMembers);
    }
    
    public void testSearch()
    {
        club.join(mem1);
        assertNotNull(club.search(mem1.getEmail()));
    }
    
    public void testSearchFail()
    {
        club.join(mem1);
        assertNull(club.search(mem2.getEmail()));
    }
}
