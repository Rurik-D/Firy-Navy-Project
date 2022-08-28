package main.core;

import javax.swing.JLabel;

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
	private List<Ships> navy = new ArrayList<>();
	private Image image;
	private int xPos = 200;
	private int yPos = 650;
	private String type;
	private int shipW = 30;
	private int shipH;



	public Ships() {
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					navy.add(new Ships(xPos, "5_carrier_up"));
					break;
				case 1:
					navy.add(new Ships(xPos, "4_battleship_up"));
					break;
				case 2, 3:
					navy.add(new Ships(xPos, "3_cruiser_up"));
					break;
				case 4, 5, 6:
					navy.add(new Ships(xPos, "3_submarine_up"));
					break;
				case 7, 8, 9:
					navy.add(new Ships(xPos, "2_assaultShip_up"));
					break;
				default:
					break;
		}
			xPos += 50;
		}
		
	}
	
	private Ships(int xPos, String type) {
		this.xPos = xPos;
		this.type = type;
		
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

	private void generateShip() {
		shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		setShipIcon();
		setVisible(false);
		new Movement(this, new Point(xPos, yPos));
	}
	
	public List<Ships> getNavy() {
		return navy;
	}
	
	public String getType() {
		return type;
	}
	
	private void setShipIcon() {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(imagesBundle.getString("image." + type)));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		image = img.getScaledInstance(shipW, shipH, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		setIcon(imageIcon);
		setBounds(xPos, yPos, shipW, shipH);
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
		
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File(imagesBundle.getString("image." + type)));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		image = img.getScaledInstance(shipW, shipH, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		setIcon(imageIcon);
		setSize(shipW, shipH);
	}
	
	
	
}