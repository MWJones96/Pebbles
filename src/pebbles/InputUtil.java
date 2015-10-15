package pebbles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* A strictly utility class that handles parsing csv files and 
 * returning the contained values to the main PebbleGame class 
 * to be loaded into the bags.
 * 
 * @date 14/10/15 - 4:02PM GMT
 * @author 35092 and 8744
 */

public class InputUtil 
{
	/* Takes in a csv file as input and returns an array of
	 * integers that correspond to the weights of the pebbles.
	 * 
	 * @date 14/10/15 - 4:58PM
	 * @author 35092 and 8744
	 */
	
	public static int[] loadFile(String filename) throws NegativeValueException, IOException
	{
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        int[] values = new int[lines.size()];
        
        for (int i = 0; i < lines.size(); i++) 
        {
        	values[i] = Integer.parseInt(lines.get(i).replace(",", ""));
        	if(values[i] < 0)
        		throw new NegativeValueException("The file given has a negative value.");
        }
            
		return values;
	}
	
}