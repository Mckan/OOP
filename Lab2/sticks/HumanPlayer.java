/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanPlayer
{
    private Sticks sticks;
    private UserInterface ui;
    
    public HumanPlayer(Sticks sticks, UserInterface ui)
    {
        this.sticks = sticks;
        this.ui = ui;
    }

    
    
    public int move()
    {
        int nr;
        
        while(1 != 0)
        {
            ui.howManySticksMsg();
            nr = ui.nextInt();
            
            if( (nr == 1 || nr == 2) &&  (nr <= sticks.sticksLeft()) )
            {
                sticks.take(nr);
                break;
            }
            else
            {
                ui.illegalMoveMsg();
                
            }
            
        
        }
        return sticks.sticksLeft();
    }
}