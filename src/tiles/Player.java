/**

* Player Class to keep track of individual Player hands and statistics

*/

package tiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Player {
	
	static Scanner in = new Scanner(System.in);
	public String name;
	public List<String> hand;
	public int points;
	static CompareTiles tileCompare = new CompareTiles(); 

    // Constructor

	public Player() {
		this.name = "Default";
		this.points = 25000;
		this.hand = new ArrayList<String>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
 	
	public void addTile(String tile) {
		this.hand.add(tile); 
	}
	
	public String discardTile() {
		System.out.println(this.hand);
		System.out.println("Please discard a tile (or press enter to quit)");
		String discard = in.nextLine();
		
		if (discard.isEmpty()) {
			return discard;
		}
		
		//Make sure proper input (existing tile) is taken from the user
	
		while (!this.hand.contains(discard)) {
			System.out.println("Please choose a tile in your hand");
			discard = in.nextLine();
		}
		
		this.hand.remove(discard);
		return discard;
	}
	
	public void sortTiles(List<String> hand) {
		Collections.sort(hand, tileCompare);
	}
}
