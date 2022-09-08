package main.navy;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Navy{
	private List<PlayerShip> playerNavy = new ArrayList<>();
	private List<ComputerShip> computerNavy = new ArrayList<>();

	private int xPos;
	
	
	/**
	 * 
	 * 
	 */
	public Navy() {
		setComputerNavy();
		setPlayerNavy();
		
//		System.out.println("");
//		for (Ship ship : computerNavy) {
//			for (int[] pos : ship.getShipPosition()) {
//				System.out.println(pos[0] + " " + pos[1]);
//			}
//			System.out.println("");
//		}
//		System.out.println("");
	}
	
	
	/**
	 * 
	 * 
	 */
	public List<ComputerShip> getComputerNavy() {
		return computerNavy;
	}
	
	
	
	/**
	 * 
	 * 
	 */
	public List<PlayerShip> getPlayerNavy() {
		return playerNavy;
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setComputerNavy() {
		xPos = 200;
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					computerNavy.add(new ComputerShip(xPos, "5_carrier_up", i));
					break;
				case 1:
					computerNavy.add(new ComputerShip(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					computerNavy.add(new ComputerShip(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					computerNavy.add(new ComputerShip(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					computerNavy.add(new ComputerShip(xPos, "2_assaultShip_up", i));
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
	private void setPlayerNavy() {
		xPos = 200;
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					playerNavy.add(new PlayerShip(xPos, "5_carrier_up", i));
					break;
				case 1:
					playerNavy.add(new PlayerShip(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					playerNavy.add(new PlayerShip(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					playerNavy.add(new PlayerShip(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					playerNavy.add(new PlayerShip(xPos, "2_assaultShip_up", i));
					break;
				default:
					break;
		}
			xPos += 50;
		}
	}
	

}
