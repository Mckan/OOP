import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Alternative I/O class for the sticks game, based on pop-up-dialogs.
 * 
 * @author Uno Holmer
 * @version 2009-10-30
 */
public class UserInterface2
{
    private int inputValue = 0;
    
    public int nextInt() {
        return inputValue;
    }
    
    public void howManySticksMsg()
    {
        String inputString = 
            JOptionPane.showInputDialog(null,
                                        "How many sticks? ",
                                        "Sticks",
                                        JOptionPane.QUESTION_MESSAGE);
        if ( inputString == null )
            System.exit(0);
            
        Scanner inputScanner = new Scanner(inputString);
        if ( inputScanner.hasNextInt() )
            inputValue = inputScanner.nextInt();
        else 
            inputValue = 0;
    }
    
    public void sticksLeftMsg(int left) {
        popUpMsg("Sticks left: " + left);
    }
    
    public void illegalMoveMsg() {
        popUpMsg("Illegal move, try again!");
        howManySticksMsg();
    }
    
    public void computerWinMsg() {
        popUpMsg("Computer wins!");
    }
    
    public void playerWinMsg() {
        popUpMsg("You win!");
    }
    
    private void popUpMsg(String msg) {
        JOptionPane.showMessageDialog(null,
                                      msg,
                                      "Sticks Game",
                                      JOptionPane.INFORMATION_MESSAGE);
    }
}
