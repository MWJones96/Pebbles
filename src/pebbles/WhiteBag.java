package pebbles;

import java.util.ArrayList;
import java.util.Random;

public class WhiteBag extends Bag
{
	public WhiteBag(ArrayList<Integer> weights)
	{
		super(weights);
	}
	
	public void receiveOneFromHand(ArrayList<Integer> hand)
	{
		//Adds the last element of Bag b to weights
		super.getWeights().add(hand.get(hand.size() - 1));
		//Removes the last element of Bag b
		hand.remove(new Random().nextInt(hand.size()));
	}
	
	public void transferAll(BlackBag b)
	{
		//Adds the contents of this Bag to Bag b
		b.getWeights().addAll(super.getWeights());
		//Clears the contents of this Bag
		super.getWeights().clear();
	}

}