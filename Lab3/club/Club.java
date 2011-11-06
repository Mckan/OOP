import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private LinkedList<Membership> membersList;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        membersList = new LinkedList<Membership>();
        
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return 0;
    }
}
