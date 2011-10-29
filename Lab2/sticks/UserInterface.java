import java.util.Scanner;

/**
 * I/O class for the sticks game.
 * 
 * @author Uno Holmer
 * @version 2009-10-29
 */
public class UserInterface
{
    private Scanner inputScanner;

    public UserInterface()
    {
        inputScanner = new Scanner(System.in);
    }
    
    public int nextInt()
    {
        if ( inputScanner.hasNextInt() )
            return inputScanner.nextInt();
        else {
            inputScanner.skip(".*\n");
            return -1;
        }
    }
    
    public void howManySticksMsg()
    {
        System.out.print("How many sticks? ");
    }
    
    public void sticksLeftMsg(int left)
    {
        System.out.println("Sticks left: " + left);
    }
    
    public void illegalMoveMsg()
    {
        System.out.println("Illegal move, try again!");
    }
    
    public void computerWinMsg()
    {
        System.out.print("Computer wins!");
    }
    
    public void playerWinMsg()
    {
        System.out.print("You win!");
    }
}
