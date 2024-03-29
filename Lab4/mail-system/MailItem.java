/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The text of the message.
    private String message;
    //The subject of the message.
    private String subject;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     * @param subject The subject of the message;
     */
    public MailItem(String from, String to, String subject, String message )
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;        
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String[] getTo()
    {   
        String[] temp = to.split(","); 
        return temp;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     *@return The subject of the message; 
     */
    public String getSubject()
    {
        return subject;
    }
    
    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println(toString());
    }
    
    /**
     * compile a text representation of this object
     */
    public String toString()
    {
        return
        "\nFrom:     " + from +
        "\nTo:       " + to +
        "\nSubject:  " + subject +
        "\nMessage:\n" + message;
    }
}
