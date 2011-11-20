import java.util.*;


/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    private HashMap <String, ArrayList<MailItem>> mailboxes;

    /**
     * Construct a mail server.
     */
    public MailServer()
    {
        mailboxes = new HashMap<String, ArrayList<MailItem>>();
        mailboxes.put("Postmaster", new ArrayList<MailItem>());
    }
    
    /**
     * Create a mailbox for a single user
     * @param the name of the new user
     * @return 1 if the creation succeeded
     * 0 if a mailbox with that name already existed
     */
    public int createMailbox(String user)
    {
        if(mailboxes.containsKey(user))
        {
            return 0;
        }
        
        mailboxes.put(user, new ArrayList<MailItem>());
        return 1;
    }
    
    /**
     * Create mailboxes for users
     * @param an array containing the names of the new users
     * @return the number of successfully created mailboxes,
     * this number will be less than the number of
     * specified users if some mailboxes already existed
     */
    public int createMailbox(String[] users)
    {
        int count = 0;
        for(String user : users)
        {
            if(!mailboxes.containsKey(user))
            {
                mailboxes.put(user, new ArrayList<MailItem>());
                count++;
            }
        }
        return count;
    }
    
    /**
     * Retrieves the mailbox for a user
     *
     * @param who the owner of the requested mailbox
     * @return the mailbox belonging to who,
     * null if it does not exist
     */
    private ArrayList<MailItem> getMailbox(String who)
    {
        return mailboxes.get(who);
    }
    
    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
        ArrayList<MailItem> mailbox = getMailbox(who);
        
        if(!mailbox.isEmpty())
        {
            // Creat a index
            int i;
            i = mailbox.size()-1;
        
            MailItem mail = mailbox.get(i);
            mailbox.remove(i);
            
            return mail;
        }
        return null;
    }
    
    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
        ArrayList<MailItem> tempMailbox = getMailbox(who);
        return tempMailbox.size();
    }
    
    /**
     * Check how many messages there is on the server
     * @return How many messages
     */
    
    public int howManyMessages()
    {
        int count = 0;
        // Gå igenom alla mailboxes och titta hur många mailItems det finns
        for(ArrayList<MailItem> mailbox : mailboxes.values())
        {
            count += mailbox.size();
        }
        
        return count;
    }


    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {
        //kolla om mailet är giltigt mha en boolskt hjälpmetod
        //om giltigt lägg till i box
        if(validMessage(item))
        {
            String[] receivers = item.getTo();
            for(String receiver : receivers)
            {
                ArrayList<MailItem> mailbox = getMailbox(receiver.trim());
            
                if(mailbox != null)
                {
                    mailbox.add(item);
                }
                else
                {
                    returnToSender(item, receiver.trim());
                }
            }   
        }
    }
    
    
    /**
     * Return a message with unknown receiver to the sender
     *
     * @param the message to be returned
     */
    private void returnToSender(MailItem message, String receiver)
    {
        ArrayList<MailItem> mailbox = getMailbox(message.getFrom());
        
        if(mailbox != null)
        {
            String newMessage = "Transcript of original message follows:\n" +
            "---------------------------------------" +
            message.toString().replace("\n","\n> ");
            
            String subject = "Unknown receiver: " + receiver;
            
            MailItem returnMessage = 
            new MailItem("Postmaster",message.getFrom(),subject,newMessage);
            
            mailbox.add(returnMessage);
        }
        
    }
    
    /**
     * Checks if the message is valid
     * 
     * @return true if valid else false
     */
     private boolean validMessage(MailItem item)
    {
        String[] receivers = item.getTo();
        
        if(item.getFrom().isEmpty())
        {
            return false;
        }
        
        for(String receiver : receivers)
        {
            if (receiver.isEmpty())
            {
                return false;
            }
        }
        
        if(item.getSubject().matches("(?i:.*spam.*)"))
        {
            return false;
        }
        
        if(item.getMessage().matches("(?i:.*v.*i.*[a|@].*g.*r.*[a|@].*)"))
        {
            return false;
        }
        
        return true;
    }
}
