package tiles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class testCases {
	
	@Test
	public void testTileCreation() {
		
		//Test to check 136 tiles are created
		
		Mahjong test = new Mahjong();
		test.makeTiles();
		assertEquals(136, test.tilePool.size());
	}
	
	@Test
	public void testComparator() {
		
		//Test to order of number tiles
		
		CompareTiles tileCompare = new CompareTiles();
		ArrayList<String> sortTest = new ArrayList<>(Arrays.asList("3m", "1m", "2m", "9m", "4m"));
		ArrayList<String> sortResult = new ArrayList<>(Arrays.asList("1m", "2m", "3m", "4m", "9m"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test order of the tile suit
		
		sortTest = new ArrayList<>(Arrays.asList("1p", "1s", "1m"));
		sortResult = new ArrayList<>(Arrays.asList("1m", "1p", "1s"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test order of suit and number
		
		sortTest = new ArrayList<>(Arrays.asList("3m", "1p", "2s", "9m", "4p"));
		sortResult = new ArrayList<>(Arrays.asList("3m", "9m", "1p", "4p", "2s"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test order of suit and number with duplicates
		
		sortTest = new ArrayList<>(Arrays.asList("3m", "1p", "2s", "9m", "1p", "4p", "3m"));
		sortResult = new ArrayList<>(Arrays.asList("3m", "3m", "9m", "1p", "1p", "4p", "2s"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test the order of the dragon tiles
		
		sortTest = new ArrayList<>(Arrays.asList("r", "t", "g"));
		sortResult = new ArrayList<>(Arrays.asList("r", "g", "t"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test the order of the dragon tiles with duplicates
		
		sortTest = new ArrayList<>(Arrays.asList("r", "t", "g", "r", "t", "g", "g"));
		sortResult = new ArrayList<>(Arrays.asList("r", "r", "g", "g", "g", "t", "t"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test the order of the dragon tiles and number tiles
		
		sortTest = new ArrayList<>(Arrays.asList("t", "3p", "1m"));
		sortResult = new ArrayList<>(Arrays.asList("1m", "3p", "t"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
		//Test the order of the dragon tiles and number tiles with duplicates
		
		sortTest = new ArrayList<>(Arrays.asList("3m", "r", "1p", "r", "2s", "g", "g", "9m", "1p", "g", "4p", "3m"));
		sortResult = new ArrayList<>(Arrays.asList("3m", "3m", "9m", "1p", "1p", "4p", "2s", "r",  "r", "g", "g", "g"));
		Collections.sort(sortTest, tileCompare);
		assertEquals(sortResult, sortTest);
		
	}
}
