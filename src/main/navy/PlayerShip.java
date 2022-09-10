package main.navy;

import java.awt.Point;
import java.util.List;
import java.util.ResourceBundle;

import main.core.Movement;
import main.core.Pve;
import main.gui.Grid;
import resources.ImagesManagement;

public class PlayerShip extends Ship{
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private int gridX = Pve.getPositionGrid().getX() + Grid.getLblBorder();
	private int gridY = Pve.getPositionGrid().getY() + Grid.getLblBorder();
	private int gridH = Pve.getPositionGrid().getHeight();
	private int squareSide = super.squareSide;
	private int shipW = super.shipW;
	private int shipH = super.shipH;
	private int xPos = super.xPos;
	private int yPos = super.yPos;
	private String type = super.type;

	
	
	public PlayerShip(int xPos, String type, int shipIndex) {
		super(xPos, type, shipIndex);
		
		generateShip();
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setShipIcon() {
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		setBounds(xPos, yPos, shipW, shipH);
	}
	
	/**
	 * 
	 * 
	 */
	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setShipIcon();
		setVisible(false);
		updateShipPosition();
		Movement move = new Movement(this, new Point(xPos, yPos));
	}
	
	
    public void resetLocation(Point p) {
		if (shipW > shipH) {
			int temp = shipW;
			shipW = shipH;
			shipH = temp;
		}
		setBounds(p.x, p.y, shipW, shipH);
		type = type.substring(0, type.length() - 2) + "up";
		
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		
		
		shipPosition.clear();
		
//		shipPos_Hit.clear();
		
		updateShipPosition();
			
    }
    
    
	/**
	 * 
	 * 
	 */
	public void rotateShip() {
		int temp = shipW;
		type = switch(type.charAt(type.length() - 2)) {
			case 'u' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "ri";}
			case 'r' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "do";}
			case 'd' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "le";}
			case 'l' -> {shipW = shipH; shipH = temp; yield type.substring(0, type.length() - 2) + "up";}
			default -> "";
		};
		
		
		setIcon(ImagesManagement.getShipImage(shipW, shipH, type));
		setSize(shipW, shipH);
		updateShipPosition();
	}
	
	public void updateShipPosition() {
		int currentSquareX = (int) (this.getX() - gridX) / squareSide;
		int currentSquareY = (int) (this.getY() - gridY) / squareSide;
		
		if (shipPosition.size() == 0) {
			for (int i = 0; i < shipSize; i++) {
				int[] voidSquare = {-1, -1};
				shipPosition.add(voidSquare);
//				shipPos_Hit.put(voidSquare, false);
			}
		} else if (this.getY() > gridY + gridH  || this.getX() < gridX) {
			shipPosition.clear();
//			shipPos_Hit.clear();
			updateShipPosition();

		} else {
			shipPosition.clear();
//			shipPos_Hit.clear();
			for (int i = 0; i < shipSize; i++) {
				int[] currentSquare = {currentSquareX, currentSquareY};

				switch(type.charAt(type.length() - 2)) {
					case 'u', 'd':
						currentSquare[1] += i;
						break;
					case 'r', 'l':
						currentSquare[0] += i;
						break;
				};
				
				shipPosition.add(currentSquare);
//				shipPos_Hit.put(currentSquare, false);
			}
		}
	}
}
