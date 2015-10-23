package pebbles;

import java.util.ArrayList;
import java.util.Random;

/**A class that instantiates a pair of bags as a specific
 * white and black bag will have forced association. Improves 
 * communication between the two bags, resulting in increased
 * 
 * @date 23/10/15
 * @author 35092 and 8744
 */

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
	
	/**Picks a random pebble from the bag and
	 * removes it from the bag and then returns
	 * its value.
	 * 
	 * @param hand The hand of the player to give the pebble to
	 */
	
	public void pickUpPebble(ArrayList<Integer> hand)
	{
		//Gets a random index in the black bag
		int index = new Random().nextInt(b.getWeights().size());
		//Stores the value corresponding to the index in a temporary variable
		int temp = b.getWeights().get(index);
		//Removes the value from the bag
		
		System.out.println(temp);
		b.getWeights().remove(temp);
		
		if(b.getWeights().size() == 0)
			fillBlackBag();
		
		//Returns the value
		hand.add(temp);
	}
	
	/**Picks a random pebble from the player's hand and
	 * puts it in the white bag.
	 * 
	 * @param The array of weights in the player's hand
	 */
	
	public void putPebbleBack(ArrayList<Integer> hand)
	{
		assert(hand.size() == 10);
		//Gets a random pebble index from the player's hand
		int index = new Random().nextInt(hand.size());
		//Puts the random pebble into the white bag
		w.getWeights().add(hand.get(index));
		hand.remove(index);
	}
	
	/**Transfers the contents of the white to the black
	 * bag.
	 */
	
	public void fillBlackBag()
	{
		b.getWeights().addAll(w.getWeights());
		w.getWeights().clear();
	}

}