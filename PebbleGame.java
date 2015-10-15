import java.util.Scanner;
/**
 * Write a description of class PebbleGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PebbleGame
{
     public static void main (String[] args)
  {
    System.out.println("Welcome to Pebble Game");
    // boolean condition that is loops through input till valid input is received
    boolean bError = true;
    while (bError) {
        try{
            // create a scanner so we can read the command-line input
            Scanner scanner = new Scanner(System.in);
        
            //  prompt for no.players
            System.out.print("Number of players? ");
        
            // get their input as a int
            int playernumber  = scanner.nextInt();
            
            bError = false;
        }   
        // If not integer input then error is displayered
        catch (Exception e) {
                        System.out.println("Numbers only");
                       
                        }
        
        
    }

}
}
