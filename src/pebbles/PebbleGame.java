package pebbles;

import java.io.IOException;
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
	//private BagPair[] m_bags = new BagPair[3];
	
	public PebbleGame(int numOfPlayers, int[] bag1, int[] bag2, int[] bag3)
	{
		m_numOfPlayers = numOfPlayers;
		
		System.out.println(numOfPlayers);
		System.out.println(bag1);
		System.out.println(bag2);
		System.out.println(bag3);
		
		//m_bags[0] = new BagPair(bag1);
		//m_bags[1] = new BagPair(bag2);
		//m_bags[2] = new BagPair(bag3);
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
		//Create a scanner so we can read the command-line input
    	Scanner scanner = new Scanner(System.in);
    	
    	int numberOfPlayers = 0;
    	
    	int[] bag1 = null;
    	int[] bag2 = null;
    	int[] bag3 = null;
		
		//Boolean condition that is loops through input until valid input is received
		boolean bError = true;
		
		System.out.println("Welcome to Pebble Game!");
		
		while (bError) 
		{
			try
			{
            	//Prompt for no.players
            	System.out.print("Number of players? ");
        
            	//Get their input as a integer
            	numberOfPlayers  = scanner.nextInt();
            
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
			try
			{
            	//Prompt for no.players
            	System.out.print("Please enter the path for csv file 1: ");
        
            	//Get their input as a integer
            	bag1 = InputUtil.loadFile(scanner.nextLine(), numberOfPlayers);
            
            	bError = false;
			}   
			//If not integer input then error is display
			catch(IOException e) 
			{
				System.out.println("Path name not valid. Please provide a valid path name.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("File contains a negative integer.");
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		bError = true;
		
		while(bError)
		{
			try
			{
            	//Prompt for no.players
            	System.out.print("Please enter the path for csv file 2: ");
        
            	//Get their input as a integer
            	bag2 = InputUtil.loadFile(scanner.nextLine(), numberOfPlayers);
            
            	bError = false;
			}   
			//If not integer input then error is display
			catch(IOException e) 
			{
				System.out.println("Path name not valid. Please provide a valid path name.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("File contains a negative integer.");
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		bError = true;
		
		while(bError)
		{
			try
			{
            	//Prompt for no.players
            	System.out.print("Please enter the path for csv file 3: ");
        
            	//Get their input as a integer
            	bag3 = InputUtil.loadFile(scanner.nextLine(), numberOfPlayers);
            
            	bError = false;
			}   
			//If not integer input then error is display
			catch(IOException e) 
			{
				System.out.println("Path name not valid. Please provide a valid path name.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("File contains a negative integer.");
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		new PebbleGame(numberOfPlayers, bag1, bag2, bag3).play();
	}
		
}