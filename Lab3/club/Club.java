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
     * Return the email addresses of all the club members.
     * @return A comma separated string of email addresses.
     */
    
    public String getEmailAdresses()
    {
        Iterator<Membership> it = membersList.iterator();
        
        StringBuffer sb = new StringBuffer(256); // Startkapacitet 256
        
        while(it.hasNext())
        {
            Membership tempMember = it.next();
            
            sb.append(tempMember.getEmail());
            if(it.hasNext())
            {
                sb.append(",");
            }            
        }
        
        return sb.toString();
    }
    
    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        Iterator<Membership> it = membersList.iterator();
        boolean isMember = false;
        
        while(it.hasNext())
        {
            if(it.next().getEmail().equalsIgnoreCase(member.getEmail()))
            {
                isMember = true;
                break;
            }
        }
        
        if(!isMember)
        {
            membersList.add(member);
        }
        else
        {
            System.out.println("Member \"" + member.getEmail() + "\" alredy exists.");
        }
    }
    
    /**
     * Return how many members joined in the given month.
     * @param month The month we are interested in.
     * @param year The year of the Membership.
     * @return How many members joined in the given month.
     */
    public int joinedInMonth(int month, int year)
    {
        // Skapa iteratorobjekt
        Iterator<Membership> it = membersList.iterator();
        int nrOfMembers = 0;
        
        if(month < 1 || month > 12) 
        {
            throw new IllegalArgumentException("Month " + month + " out of range. Must be in the range 1 ... 12");
        }
        else
        {
            //Loopa igenom iteratorn
            while(it.hasNext())
            {
                Membership tempMember = it.next();
                
                //jämför månad och år
                //om lika öka räknare
                if((tempMember.getYear() == year) && (tempMember.getMonth() == month ))
                {
                    nrOfMembers++;
                }
            }
        }
       return nrOfMembers;
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return membersList.size();
    }
    
     /**
     * Remove from the club's collection all members who joined
     * in the given month, and return them stored in a separate
     * collection object.
     * @param month The month of the Membership.
     * @param year The year of the Membership.
     */
    public ArrayList<Membership> purge(int month,int year)
    {
        Iterator<Membership> it = membersList.iterator();
        ArrayList<Membership> tempList = new ArrayList<Membership>();
        
        if(month < 1 || month > 12) 
        {
            System.out.println("Month " + month + " out of range. Must be in the range 1 ... 12");
            return null;
        }
        
        while(it.hasNext())
        {
            Membership tempMember = it.next();
                
            //jämför månad och år             
            if((tempMember.getYear() == year) && (tempMember.getMonth() == month ))
            {
                tempList.add(tempMember);
                //Ta bort ur orginallistan
                it.remove();
            }
        }
        
        //Retur av listan
        return tempList;
    }
    
    
    /**
     * Search for a member with a given email address.
     * @return A matching membership object if found,
     * null otherwise.
     */
   
    public Membership search(String email)
    {
        Iterator<Membership> it = membersList.iterator();        
        
        while(it.hasNext())
        {
            Membership tempMember = it.next();
            
            if(tempMember.getEmail().equalsIgnoreCase(email))
            {
                return tempMember;                
            }
        }
        return null;
        
    }

}

