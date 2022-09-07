package main.core;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Navy{
	private List<Ship> playerNavy = new ArrayList<>();
	private int xPos = 200;
	
	
	/**
	 * 
	 * 
	 */
	public Navy() {
		
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					playerNavy.add(new Ship(xPos, "5_carrier_up", i));
					break;
				case 1:
					playerNavy.add(new Ship(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					playerNavy.add(new Ship(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					playerNavy.add(new Ship(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					playerNavy.add(new Ship(xPos, "2_assaultShip_up", i));
					break;
				default:
					break;
		}
			xPos += 50;
		}
		
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<Ship> getPlayerNavy() {
		return playerNavy;
	}

}
