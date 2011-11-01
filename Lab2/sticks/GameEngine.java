
/**
 * Write a description of class GameEngine here.
 * 
 * @author Martin Augustsson
 * @version 0.2
 */
public class GameEngine
{
    private Sticks sticks;
    private ComputerPlayer computerPlayer;
    private HumanPlayer humanPlayer;
    private UserInterface ui;

    public GameEngine()
    {
        sticks = new Sticks();
        ui = new UserInterface();
        computerPlayer = new ComputerPlayer(sticks);
        humanPlayer = new HumanPlayer(sticks, ui);
        
    }
    
    public int runGame()
    {
        while(true)
        {
            ui.sticksLeftMsg(sticks.sticksLeft());
            if(humanPlayer.move() == 0)
            {
                ui.computerWinMsg();
                break;
            }
            else if (computerPlayer.move() == 0)
            {
                ui.playerWinMsg();
                break;
            }
        }
        return 0;
    }
    
    
}
