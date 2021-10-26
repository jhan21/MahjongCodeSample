/**

* Main Class to run the program
* Keeps track of the game state and the pieces

* @author Jong Han

*/
package tiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Mahjong {
	
	//Public Variables to hold the tiles

    public List<String> tilePool;
    public List<String> discardPool;

    //Constructor that starts the game
    
    public Mahjong() {
        makeTiles();
        shuffleTiles();
        Player p1 = new Player();
        initializeHand(p1);
        startGame(p1);
    }

    //Creates all 148 tiles needed for the game
    
    public void makeTiles() {
        tilePool = new ArrayList<String>();
        discardPool = new ArrayList<String>();

        for (int i = 1; i < 10; i++) {
            this.tilePool.add(Integer.toString(i) + "m");
            this.tilePool.add(Integer.toString(i) + "m");
            this.tilePool.add(Integer.toString(i) + "m");
            this.tilePool.add(Integer.toString(i) + "m");
        }
        for (int i = 1; i < 10; i++) {
            this.tilePool.add(Integer.toString(i) + "p");
            this.tilePool.add(Integer.toString(i) + "p");
            this.tilePool.add(Integer.toString(i) + "p");
            this.tilePool.add(Integer.toString(i) + "p");
        }
        for (int i = 1; i < 10; i++) {
            this.tilePool.add(Integer.toString(i) + "s");
            this.tilePool.add(Integer.toString(i) + "s");
            this.tilePool.add(Integer.toString(i) + "s");
            this.tilePool.add(Integer.toString(i) + "s");
        }
        for (int i = 0; i < 4; i++) {
            this.tilePool.add("r");
            this.tilePool.add("t");
            this.tilePool.add("g");
            this.tilePool.add("n");
            this.tilePool.add("e");
            this.tilePool.add("s");
            this.tilePool.add("w");
        }
    }

    public void shuffleTiles() {
        Collections.shuffle(tilePool);
    }

    public void initializeHand(Player p1) {
        startingHand(p1);
    }

    public void startingHand(Player p) {
        for (int i = 0; i < 13; i++) {
            p.addTile(drawTile());
        }
        p.sortTiles(p.hand);
    }

    public void rounds(Player p1) {
        
    	//Placeholder tile to get user input or check if it is empty
    	
    	String circulatingTile = "1m";
    	
        //Keeps drawing tiles until pool is empty or empty string is returned
        
        while (this.tilePool.size() > 14 && !circulatingTile.isEmpty()) {
            p1.addTile(drawTile());
            circulatingTile = p1.discardTile();
            discardPool.add(circulatingTile);
            p1.sortTiles(p1.hand);
        }
    }

    public String drawTile() {
    	
    	//Gets the next tile in the pool and removes it from pool
        String tile = this.tilePool.get(0);
        this.tilePool.remove(0);
        return tile;
    }

    public void startGame(Player p1) {
        System.out.println("Starting game");
        rounds(p1);
    }

    public static void main(String[] args) {
        System.out.println("Making Tiles");
        System.out.println("Initializing Players");
        Mahjong testGame = new Mahjong();
        System.out.println("Goodbye!");
    }
}
