package pebbles;

import java.util.ArrayList;

public class BagPair 
{
	private BlackBag b;
	private WhiteBag w;
	
	public BagPair(ArrayList<Integer> bag)
	{
		b = new BlackBag(bag);
		w = new WhiteBag(new ArrayList<Integer>());
	}
	
	public BlackBag getBlackBag()
	{
		return b;
	}
	
	public WhiteBag getWhiteBag()
	{
		return w;
	}

}