package pebbles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**The main PebbleGame class that handles all of the objects
 * and controls the flow of the game.
 * 
 * @date 14/10/15
 * @author Candidate numbers 35092 and 8744
 */

public class PebbleGame
{
	private volatile boolean isFinished = false;
	
	private int numOfPlayers;
	private Player[] p;
	private BagPair[] bags;
	
	private BufferedWriter[] w;
	
	public PebbleGame(int numOfPlayers, ArrayList<Integer> bag1, ArrayList<Integer> bag2, ArrayList<Integer> bag3)
	{
		this.numOfPlayers = numOfPlayers;
		this.w = new BufferedWriter[numOfPlayers];
		
		this.p = new Player[numOfPlayers];
		
		this.bags = new BagPair[3];
		this.bags[0] = new BagPair(bag1);
		this.bags[1] = new BagPair(bag2);
		this.bags[2] = new BagPair(bag3);
	}
	
	/**Nested class that controls the players of PebbleGame.
	 * Acts as a thread.
	 * 
	 * @date 18/10/15
	 * @author Candidate numbers 35092 and 8744
	 */
	
	public class Player extends Thread
	{	
		private ArrayList<Integer> hand;
		private int bagLastDrawnFrom;
		private boolean won = false;
		
		private String name;
		private int number;
		
		public Player(String name, int number)
		{
			hand = new ArrayList<Integer>();
			this.name = name;
			this.number = number;
		}
		
		@Override
		public void run()
		{
			for(int i = 0; i < 10; i++)
			{
				draw();
				try {Thread.sleep(10);} catch (InterruptedException e){}
			}
			
			if(getSum() == 100 & won)
			{
				won = true;
				isFinished = true;
			}

			while(!isFinished)
			{
				if(getSum() == 100 & !isFinished)
				{
					won = true;
					isFinished = true;
					break;
				}
				
				discardAndDraw();
				
				if(getSum() == 100 & !isFinished)
				{
					won = true;
					isFinished = true;
					break;
				}
				
				try {Thread.sleep(10);} catch (InterruptedException e){}
				
			}
				
			if(won)
			{
				try {w[number].write(name + " won.");} catch (IOException e1){}
				
				System.out.println("Game is over. Exiting...");
				
				for(int i = 0; i < numOfPlayers; i++)
					try {w[i].close();} catch (IOException e){}
			}
			
		}
			
		public synchronized void discardAndDraw()
		{	
			assert(hand.size() == 10);
			
			if(!isFinished)
			{	
				
				discard();
				draw();
			}
			
			assert(hand.size() == 10);
		}
		
		public synchronized void draw()
		{
			int index = new Random().nextInt(3);
			
			while(bags[index].getBlackBag().getWeights().size() == 0)
			{
				index = new Random().nextInt(3);
			}
			
			bags[index].pickUpPebble(hand);
			setBagLastDrawnFrom(index);
			
			String drawStatus = name + " has drawn a " + hand.get(hand.size() - 1) + " from bag " + (bagLastDrawnFrom + 1) + 
			"\n" + name + "'s hand is " + hand.toString().substring(1, hand.toString().length() - 1) + "\n";
			
			try {w[number].write(drawStatus);} catch (IOException e){}
		}
		
		private synchronized void discard()
		{
			bags[bagLastDrawnFrom].putPebbleBack(hand);
			
			String discardStatus = name + " has discarded a " + bags[bagLastDrawnFrom].getWhiteBag().getWeights().get(bags[bagLastDrawnFrom].getWhiteBag().getWeights().size() - 1) 
			+ " to bag " + (bagLastDrawnFrom + 1) + "\n" + name + "'s hand is " +hand.toString().substring(1, hand.toString().length() - 1) + "\n";
			
			try {w[number].write(discardStatus);} catch (IOException e){}
		}
		
		private int getSum()
		{
			int sum = 0;
			
			for(int i = 0; i < hand.size(); i++)
			{
				sum += hand.get(i);
			}
			
			return sum;
		}
		
		public void setBagLastDrawnFrom(int index)
		{
			this.bagLastDrawnFrom = index;
		}

	}
	
	public void play()
	{	
		ExecutorService s = Executors.newFixedThreadPool(numOfPlayers);
		
		for(int i = 0; i < numOfPlayers; i++)
		{
			try 
			{
				//Instantiates the BufferedWriter to write to the appropriate player output file
				w[i] = new BufferedWriter(new FileWriter("player" + (i + 1) + "output.txt"));
			} 
			catch (IOException e){}
			
			p[i] = new Player("player" + (i + 1), i);
			
			s.execute(p[i]);
		}
			
		s.shutdown();
		
	}
	
	public static void main(String[] args)
	{	
		//Create a scanner so we can read the command-line input
    	Scanner scanner = new Scanner(System.in);
    	
    	//Integer that stores the number of players
    	int numberOfPlayers = 0;
    	
    	//Arrays that store the integer weights of the pebbles in the bags
    	ArrayList<Integer> bag1 = null;
    	ArrayList<Integer> bag2 = null;
    	ArrayList<Integer> bag3 = null;
		
		//Boolean condition that is loops through input until valid input is received
		boolean canContinue = false;
			
		System.out.println("Welcome to Pebble Game!");
		
		//Loops through until a valid input is given
		while(!canContinue) 
		{
			try
			{
            	//Prompt for number of players
            	System.out.print("Number of players? ");
				
				String input = scanner.nextLine();
				
				//Testing program exit condition
				if(input.equals("X"))
				{
					System.out.println("Exiting...");
					System.exit(0);
				}
				
            	//Attempts to parse line to an integer
				numberOfPlayers = Integer.parseInt(input);
            
				//Valid input given; can move on
            	canContinue = true;
			}   
			//If not integer input then error is display
			catch(NumberFormatException e) 
			{
				System.out.println("Only integers accepted. Please try again.");
			}
		
		}
		
		canContinue = false;
		
		while(!canContinue)
		{
			try
			{
            	//Prompt for file 1
            	System.out.print("Please enter the path for csv file 1: ");
            	
            	String input = scanner.nextLine();
            	
				if(input.equals("X"))
				{
					System.out.println("Exiting...");
					System.exit(0);
				}
            	
            	bag1 = InputUtil.loadFile(input, numberOfPlayers);
            
            	canContinue = true;
			}   
			catch(IOException e)
			{
				System.out.println("Error loading file.");
			}
			catch(InvalidPathException e) 
			{
				System.out.println("Path name not valid.");
			}
			catch(NumberFormatException e)
			{
				System.out.println("File supplied does not exclusively contain integers.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("Warning: File contains negative value integer(s). Continue anyway? (Y/N): ");
				if(scanner.nextLine().equals("Y"))
					canContinue = true;
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		canContinue = false;
		
		while(!canContinue)
		{
			try
			{
				
				//Prompt for file 2
            	System.out.print("Please enter the path for csv file 2: ");
            	
            	String input = scanner.nextLine();
            	
				if(input.equals("X"))
				{
					System.out.println("Exiting...");
					System.exit(0);
				}
            	
            	bag2 = InputUtil.loadFile(input, numberOfPlayers);
            
            	canContinue = true;
			}   
			catch(IOException e)
			{
				System.out.println("Error loading file.");
			}
			catch(InvalidPathException e) 
			{
				System.out.println("Path name not valid.");
			}
			catch(NumberFormatException e)
			{
				System.out.println("File supplied does not exclusively contain integers.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("Warning: File contains negative value integer(s). Continue anyway? (Y/N): ");
				if(scanner.nextLine().equals("Y"))
					canContinue = true;
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		canContinue = false;
		
		while(!canContinue)
		{
			try
			{
            	//Prompt for file number 3
            	System.out.print("Please enter the path for csv file 3: ");
            			
            	String input = scanner.nextLine();
            	
				if(input.equals("X"))
				{
					System.out.println("Exiting...");
					System.exit(0);
				}
            	
            	bag3 = InputUtil.loadFile(input, numberOfPlayers);
            
            	canContinue = true;
			}   
			catch(IOException e)
			{
				System.out.println("Error loading file.");
			}
			catch(InvalidPathException e) 
			{
				System.out.println("Path name not valid.");
			}
			catch(NumberFormatException e)
			{
				System.out.println("File supplied does not exclusively contain integers.");
			}
			catch(NegativePebbleWeightException e)
			{
				System.out.println("Warning: File contains negative value integer(s). Continue anyway? (Y/N): ");
				if(scanner.nextLine().equals("Y"))
					canContinue = true;
			}
			catch(InsufficientNumberOfPebblesException e)
			{
				System.out.println("File contains an insufficient number of pebbles for the number of players supplied.");
			}
		}
		
		new PebbleGame(numberOfPlayers, bag1, bag2, bag3).play();
	}
		
}
