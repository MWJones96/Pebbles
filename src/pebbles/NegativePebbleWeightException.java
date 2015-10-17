package pebbles;

/**An exception that is thrown when a file supplied to the
 * PebbleGame application contains a negative value.
 * 
 * @date 14/10/15
 * @author 35092 and 8744
 */

public class NegativePebbleWeightException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public NegativePebbleWeightException()
	{
		super();
	}
	
	public NegativePebbleWeightException(String message)
	{
		super(message);
	}

}