package main.navy;

public class ComputerShip extends Ship{
	private int shipW = super.shipW;
	private String type = super.type;

	public ComputerShip(int xPos, String type, int shipIndex) {
		super(xPos, type, shipIndex);
		generateShip();

		}
	
	/**
	 * 
	 * 
	 */
	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setVisible(false);
	}
	
	
	/**
	 * 
	 * 
	 */
    public void resetLocation() {
    	super.shipPosition.clear();
    }
    
}
