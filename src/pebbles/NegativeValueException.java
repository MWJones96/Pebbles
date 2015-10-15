package pebbles; 

/**An exception that is thrown if there is a negative number
 * in an input file.
 * 
 * @date 14/10/15 - 4:06PM
 * @author 35092 and 8744
 */

public class NegativeValueException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public NegativeValueException()
	{
		super();
	}
	
	public NegativeValueException(String message)
	{
		super(message);
	}
	
}