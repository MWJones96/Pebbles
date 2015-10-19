package pebbles;

import java.util.ArrayList;
import java.util.Random;

public class BlackBag extends Bag
{
	public BlackBag(ArrayList<Integer> weights)
	{
		super(weights);
	}
	
	public void receiveAll(WhiteBag w)
	{
		assert(w.getWeights().size() > 0);
		assert(this.getWeights().size() == 0);
		
		//Gets all of the weights from Bag b
		this.getWeights().addAll(w.getWeights());
		//Clear the weights in Bag b
		w.getWeights().clear();
	}
	
	public void transferOneToHand(ArrayList<Integer> hand)
	{	
		assert(this.getWeights().size() > 0);
		
		//Adds the last element of this Bag to Bag b
		hand.add(this.getWeights().get(new Random().nextInt(this.getWeights().size())));
		//Removes the last element from this Bag
		this.getWeights().remove(this.getWeights().size() - 1);
	}
}