/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer
{
    private Sticks sticks;
    
    public ComputerPlayer( Sticks sticks)
    {
        this.sticks = sticks;
    }
    
    // Makes the move for the computerplayer
    public int move()
    {
        if( (sticks.sticksLeft() % 2) == 0 || (sticks.sticksLeft() == 1) )
        {
            sticks.take(1);
        }
        else
        {
            sticks.take(2);
        }
        return sticks.sticksLeft();
    }
}
