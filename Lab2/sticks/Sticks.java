/**
 * Write a description of class Sticks here.
 * 
 * @author 
 * @version 
 */
public class Sticks
{
    private int maxNoOfSticks;
    private int sticksLeft;
       
    public Sticks()
    {
        this(21);
    }
    
    public Sticks( int n)
    {
        maxNoOfSticks = n;
        sticksLeft = n;
    }
    
    
    public void newGame()
    {
        sticksLeft = maxNoOfSticks;
    }
    
    public int sticksLeft()
    {
        return sticksLeft;
    }
    
    public int take ( int n)
    {
        if( n == 1 || n == 2)
        {
            if(sticksLeft >= n )
            {
                sticksLeft = sticksLeft - n;
                return sticksLeft;
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }
}
