package main.core;

/**
 * This class manage the PVE (player vs enviorment) mode.
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Pve {
	private static Grid positionGrid = new Grid(300, 200);
	private static Navy navy = new Navy();
	private static Grid attackGrid = new Grid(950, 200, positionGrid);
	
	
	/**
	 * @return the grid (JLabel) to attack the computer navy
	 */
	public static Grid getAttackGrid() {
		return attackGrid;
	}
	
	
	/**
	 * @return the grid (JLabel) to place the ships
	 */
	public static Grid getPositionGrid() {
		return positionGrid;
	}
	

	
	/**
	 * @return the grid (JLabel) to place the ships
	 */
	public static Navy getNavy() {
		return navy;
	}
}
