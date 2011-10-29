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
    
    public Sticks( int n)
    {
        maxNoOfSticks = n;
        sticksLeft = n;
    }
    
    public Sticks()
    {
        maxNoOfSticks = 21;
        sticksLeft = 21;
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
            sticksLeft = sticksLeft - n;
            if(sticksLeft >= 0 )
            {
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
