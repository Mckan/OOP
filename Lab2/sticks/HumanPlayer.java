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
        
        while(true)
        {
            ui.howManySticksMsg();
            nr = ui.nextInt();
            
            if(sticks.take(nr) >= 0)
            {
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