package pebbles;

import java.util.ArrayList;

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