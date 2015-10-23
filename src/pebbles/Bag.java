package pebbles;

import java.util.ArrayList;

/**The abstract class that instantiates the bag.
 * The class is abstract because the bags must be either white or black.
 * You cannot simply instantiate a 'Bag'.
 * 
 * @date 23/10/15
 * @author 35092 and 8744
 */

public abstract class Bag
{
	private ArrayList<Integer> weights;
	
	public Bag(ArrayList<Integer> weights)
	{
		this.weights = weights;
	}
	
	public ArrayList<Integer> getWeights()
	{
		return this.weights;
	}
	
}