/**
 * Store details of a club membership.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2003.01.10
 */
public class Membership
{
    // The name of the member.
    private String name;
    // The month in which the membership was taken out.
    private int month;
    // The year in which the membership was taken out.
    private int year;
    // The email of the member.
    private String email;

    /**
     * Constructor for objects of class Membership.
     * @param name The name of the member.
     * @param month The month in which they joined. (1 ... 12)
     * @param year The year in which they joined.
     */
    public Membership(String name, String email, int month, int year)
        throws IllegalArgumentException
    {
        if(month < 1 || month > 12) 
        {
            throw new IllegalArgumentException(
                "Month " + month + " out of range. Must be in the range 1 ... 12");
        }
        

        this.name = name;
        this.month = month;
        this.year = year;
        this.email = email;
    }
    
    /**
     * @return The member's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return Member's email.
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * @return The month in which the member joined.
     *         A value in the range 1 ... 12
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return The year in which the member joined.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return A string representation of this membership.
     */
    public String toString()
    {
        return "Name: " + name + " joined in month " + month + " of " + year + "Email: " + email;
    }
}
