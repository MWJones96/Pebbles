package pebbles;

import java.util.Scanner;

/**The main PebbleGame class that handles all of the objects
 * and controls the flow of the game.
 * 
 * @date 15/10/15 - 1:48PM
 * @author 35092 and 8744
 */

public class PebbleGame
{
	public static void main (String[] args)
	{
		System.out.println("Welcome to Pebble Game");
		//Boolean condition that is loops through input till valid input is received
		boolean bError = true;
		while (bError) 
		{
			try
			{
				//Create a scanner so we can read the command-line input
            	Scanner scanner = new Scanner(System.in);
        
            	//Prompt for no.players
            	System.out.print("Number of players? ");
        
            	//Get their input as a integer
            	int playernumber  = scanner.nextInt();
            
            	bError = false;
			}   
			//If not integer input then error is display
			catch (Exception e) 
			{
				System.out.println("Numbers only");
			}
			
		}
		
	}
	
}
