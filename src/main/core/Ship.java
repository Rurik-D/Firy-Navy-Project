package main.core;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JLabel;

import resources.ImagesManagement;

public class Ship extends JLabel{
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private List<int[]> shipPosition = new ArrayList<>();
	private int boxSide = Grid.getBoxSide();
	private int gridX = Pve.getPositionGrid().getX() + Grid.getLblBorder();
	private int gridY = Pve.getPositionGrid().getY() + Grid.getLblBorder();
	private int gridH = Pve.getPositionGrid().getHeight();
	private int shipW = Grid.getBoxSide();
	private int shipH;
	private int xPos = 200;
	private int yPos = 650;
	private String type;
	private int shipIndex;


	
	public Ship(int xPos, String type, int shipIndex) {
		this.xPos = xPos;
		this.type = type;
		this.shipIndex = shipIndex;
		
		switch (type) {
			case "5_carrier_up":
				generateShip();
				break;
			case "4_battleship_up":
				generateShip();
				break;
			case "3_cruiser_up":
				generateShip();
				break;
			case "3_submarine_up":
				generateShip();
				break;
			case "2_assaultShip_up":
				generateShip();
				break;
			default:
				break;
		}
	}
	
	public int getShipSize() {
		return Integer.parseInt(type.substring(0, 1));
	}
	
	public String getType() {
		return type;
	}
	
	public List<int[]> getShipPosition(){
		return shipPosition;
	}
	
	public int getShipIndex() {
		return shipIndex;
	}
	
	private void setShipIcon() {
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		setBounds(xPos, yPos, shipW, shipH);
	}
	
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
		updateShipPosition();
			
    }
	
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
		int currentBoxX = (int) (this.getX() - gridX) / boxSide;
		int currentBoxY = (int) (this.getY() - gridY) / boxSide;

		if (shipPosition.size() == 0) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				int[] voidBox = {-1, -1};
				shipPosition.add(voidBox);
			}
		} else if (this.getY() > gridY + gridH  || this.getX() < gridX) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				shipPosition.get(i)[0] = -1;
				shipPosition.get(i)[1] = -1;
			}
		} else {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				shipPosition.get(i)[0] = currentBoxX;
				shipPosition.get(i)[1] = currentBoxY;
				switch(type.charAt(type.length() - 2)) {
					case 'u', 'd':
						shipPosition.get(i)[1] += i;
						break;
					case 'r', 'l':
						shipPosition.get(i)[0] += i;
						break;
				};
			}
		}
	}
}