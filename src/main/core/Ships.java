package main.core;

import javax.swing.JLabel;

import main.frame.Main;
import resources.ImagesManagement;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Ships extends JLabel{
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private List<int[]> playerPosition = new ArrayList<>();
	
	private List<Ships> navy = new ArrayList<>();
	private Image image;
	private int xPos = 200;
	private int yPos = 650;
	private String type;
	private int boxSide = Grid.getBoxSide();
	private int gridX = Main.getPlayerGrid().getX() + Grid.getLblBorder();
	private int gridY = Main.getPlayerGrid().getY() + Grid.getLblBorder();
	private int gridH = Main.getPlayerGrid().getHeight();
	private int shipW = Grid.getBoxSide();
	private int shipH;
	private int shipIndex;

	public Ships() {
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					navy.add(new Ships(xPos, "5_carrier_up", i));
					break;
				case 1:
					navy.add(new Ships(xPos, "4_battleship_up", i));
					break;
				case 2, 3:
					navy.add(new Ships(xPos, "3_cruiser_up", i));
					break;
				case 4, 5, 6:
					navy.add(new Ships(xPos, "3_submarine_up", i));
					break;
				case 7, 8, 9:
					navy.add(new Ships(xPos, "2_assaultShip_up", i));
					break;
				default:
					break;
		}
			xPos += 50;
		}
		
	}
	
	private Ships(int xPos, String type, int shipIndex) {
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
	
	public List<Ships> getNavy() {
		return navy;
	}
	
	public String getType() {
		return type;
	}
	
	public List<int[]> getPlayerPosition(){
		return playerPosition;
	}
	
	public int getShipIndex() {
		return shipIndex;
	}
	
	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setShipIcon();
		setVisible(false);
		updatePlayerPosition();
		new Movement(this, new Point(xPos, yPos));
	}
	
	private void setShipIcon() {
		setIcon(ImagesManagement.getImage(shipW, shipH, imagesBundle.getString("image." + type)));
		setBounds(xPos, yPos, shipW, shipH);
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
		updatePlayerPosition();

			
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
		updatePlayerPosition();
	}
	
	public void updatePlayerPosition() {
		int currentBoxX = (int) (this.getX() - gridX) / Grid.getBoxSide();
		int currentBoxY = (int) (this.getY() - gridY) / Grid.getBoxSide();

		if (playerPosition.size() == 0) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				int[] voidBox = {-1, -1};
				playerPosition.add(voidBox);
			}
		} else if (this.getY() > gridY + gridH  || this.getX() < gridX) {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				playerPosition.get(i)[0] = -1;
				playerPosition.get(i)[1] = -1;
			}
		} else {
			for (int i = 0; i < Integer.parseInt(type.substring(0, 1)); i++) {
				playerPosition.get(i)[0] = currentBoxX;
				playerPosition.get(i)[1] = currentBoxY;
				switch(type.charAt(type.length() - 2)) {
					case 'u', 'd':
						playerPosition.get(i)[1] += i;
						break;
					case 'r', 'l':
						playerPosition.get(i)[0] += i;
						break;
				};
				System.out.println(playerPosition.get(i)[0] + ", " + playerPosition.get(i)[1]);
			}
			System.out.println();
		}
	}
}
