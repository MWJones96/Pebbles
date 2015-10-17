package pebbles;

import java.util.Scanner;

/**The main PebbleGame class that handles all of the objects
 * and controls the flow of the game.
 * 
 * @date 14/10/15
 * @author 35092 and 8744
 */

public class PebbleGame
{
	private int m_numOfPlayers;
	private BagPair[] m_bags = new BagPair[3];
	
	public Game(int numOfPlayers, int[] bag1, int[] bag2, int[] bag3)
	{
		m_numOfPlayers = numOfPlayers;
		
		m_bags[0] = new BagPair(bag1);
		m_bags[1] = new BagPair(bag2);
		m_bags[2] = new BagPair(bag3);
	}
	
	/**
	 * 
	 * 
	 * 
	 * @date 
	 * @author 
	 */
	
	public class Player extends Thread
	{
		public Player()
		{}
		
		public void start()
		{
			
		}
	}
	
	public void play()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
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
				System.out.println("Only integers accepted. Please try again.");
			}
		
		}
		
		bError = true;
		
		while(bError)
		{
			
		}

		
		
		new PebbleGame().play();
	}
		
}