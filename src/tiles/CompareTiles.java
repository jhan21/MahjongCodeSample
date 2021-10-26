/**

* Implementation of Comparator to create a custom sort
* Specifically for Dragon tiles
* Order is Red (R) Green (G) White (T)


*/

package tiles;

import java.util.Comparator;

public class CompareTiles implements Comparator<String> {

	@Override
	public int compare(String tile1, String tile2) {
		
		int marker = 0;
		
		if (tile1.length() < tile2.length()) {
			marker = 1;
		}
		else if (tile1.length() > tile2.length()) {
			marker = -1;
		}
		
		else if (tile1.length() == 1 && tile2.length() == 1) {

			if (tile1.charAt(0) == 't') {
				marker = 1;
			}
			else if (tile2.charAt(0) == 't') {
				marker = -1;
			}

			else if (tile1.charAt(0) == 'g') {
				marker = 1;
			}
			else if (tile1.charAt(0) == 'r') {
				marker = -1;
			}
		}
		else {
			marker = Character.compare(tile1.charAt(1), tile2.charAt(1));
			
			if (marker == 0) {
				marker = Character.compare(tile1.charAt(0), tile2.charAt(0));
				}
			}
	return marker;
	}
}