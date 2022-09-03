package main.core;

/**
 * This class manage the PVP (player vs player) mode.
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class Pvp {
	private static Grid positionGridP1 = new Grid(300, 200);
	private static Grid positionGridP2 = new Grid(300, 200);
	private static Navy navyP1 = new Navy();
	private static Navy navyP2 = new Navy();
	private static Grid attackGridP1 = new Grid(950, 200, positionGridP1);
	private static Grid attackGridP2 = new Grid(950, 200, positionGridP2);

	
	
	/**
	 * 
	 */
	public static Grid getAttackGrid(int player) {
		return switch(player) {
			case 1 -> attackGridP1;
			case 2 -> attackGridP2;
			default -> null;
		};
	}
	
	
	/**
	 * 
	 */
	public static Grid getPositionGrid(int player) {
		return switch(player) {
			case 1 -> positionGridP1;
			case 2 -> positionGridP2;
			default -> null;
		};
	}
	

	
	/**
	 * 
	 */
	public static Navy getNavy(int player) {
		return switch(player) {
			case 1 -> navyP1;
			case 2 -> navyP2;
			default -> null;
		};
	}
}
