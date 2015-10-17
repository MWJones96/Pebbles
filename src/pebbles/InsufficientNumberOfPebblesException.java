package pebbles;

/**An exception that is thrown when a file supplied
 * to the PebbleGame application contains an insufficient
 * number of pebbles (i.e. less that 11 times the number
 * of players)
 * 
 * @date 14/10/15
 * @author 35092 and 8744
 */

public class InsufficientNumberOfPebblesException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InsufficientNumberOfPebblesException()
	{
		super();
	}
	
	public InsufficientNumberOfPebblesException(String message)
	{
		super(message);
	}

}