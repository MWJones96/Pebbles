package pebbles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**A strictly utility class that handles parsing csv files and 
 * returning the contained values to the main PebbleGame class 
 * to be loaded into the bags.
 * 
 * @date 14/10/15
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
	
	public static ArrayList<Integer> loadFile(String filename, int numberOfPlayers) throws IOException, NegativePebbleWeightException, InsufficientNumberOfPebblesException
	{
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        
        if(lines.size() < numberOfPlayers * 11)
        	throw new InsufficientNumberOfPebblesException("Not enough pebbles for the number of pebbles given");
        
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        for (int i = 0; i < lines.size(); i++) 
        {
        	values.add(Integer.parseInt(lines.get(i).replace(",", "")));
        	if(values.get(i) <= 0)
        		throw new NegativePebbleWeightException("File contains a negative integer.");
        }
            
		return values;
	}
	
}