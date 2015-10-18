package pebbles;

import java.util.ArrayList;

public class WhiteBag extends Bag
{
	public WhiteBag(ArrayList<Integer> weights)
	{
		super(weights);
	}
	
	public void receiveOne(BlackBag b)
	{
		//Adds the last element of Bag b to weights
		super.getWeights().add(b.getWeights().get(b.getWeights().size() - 1));
		//Removes the last element of Bag b
		b.getWeights().remove(b.getWeights().size() - 1);
	}
	
	public void transferAll(BlackBag b)
	{
		//Adds the contents of this Bag to Bag b
		b.getWeights().addAll(super.getWeights());
		//Clears the contents of this Bag
		super.getWeights().clear();
	}

}