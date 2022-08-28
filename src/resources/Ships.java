package resources;

import javax.swing.JLabel;
import java.awt.Image;
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
//	private JLabel carrier;
//	private JLabel battleship;
//	private JLabel cruiser;
//	private JLabel submarine;
//	private JLabel assaultShip;
	private Image image;
	private int xPos = 350;
	private String type;

	/**
	 *  1 carrier		0
	 *  1 battleship	1
	 *  2 cruisers		2-3
	 *  3 submarines	4-6
	 *  3 assultShip	7-9
	 */
	public Ships() {
//		carrier = getShip(350, 650, "5_carrier");
//		battleship = getShip(400, 650, "4_battleship");
//		cruiser = getShip(450, 650, "3_cruiser");
//		submarine = getShip(500, 650, "3_submarine");
//		assaultShip = getShip(550, 650, "2_assaultShip");
		
		for(int i = 0; i < 10; i++) {
			switch (i) {
				case 0:
					navy.add(new Ships(xPos, "5_carrier"));
					break;
				case 1:
					navy.add(new Ships(xPos, "4_battleship"));
					break;
				case 2, 3:
					navy.add(new Ships(xPos, "3_cruiser"));
					break;
				case 4, 5, 6:
					navy.add(new Ships(xPos, "3_submarine"));
					break;
				case 7, 8, 9:
					navy.add(new Ships(xPos, "2_assaultShip"));
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
			case "5_carrier":
				generateShip(xPos, 650, "5_carrier");
				break;
			case "4_battleship":
				generateShip(xPos, 650, "4_battleship");
				break;
			case "3_cruiser":
				generateShip(xPos, 650, "3_cruiser");
				break;
			case "3_submarine":
				generateShip(xPos, 650, "3_submarine");
				break;
			case "2_assaultShip":
				generateShip(xPos, 650, "2_assaultShip");
				break;
			default:
				break;
		}
	}

	private void generateShip(int x, int y, String type) {
		int shipW = 30;
		int shipH = Integer.parseInt(type.substring(0, 1)) * shipW;
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File(imagesBundle.getString("image." + type)));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		image = img.getScaledInstance(shipW, shipH, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		this.setIcon(imageIcon);
		this.setBounds(x, y, shipW, shipH);
		this.setVisible(false);
//		
//		Ships ship = (Ships) new JLabel(imageIcon);
//		ship.setBounds(x, y, shipW, shipH);
//		ship.setVisible(false);
//		return ship;
//		JLabel ship = new JLabel();
//		ship.setIcon(imageIcon);
//		ship.setBounds(x, y, shipW, shipH);
//		ship.setVisible(false);
//		return ship;
	}
	public List<Ships> getNavy() {
		return navy;
	}
	
//	public JLabel getAssaultShip() {
//		return assaultShip;
//	}
//	
//	public JLabel getBattleship() {
//		return battleship;
//	}
//	
//	public JLabel getCarrier() {
//		return carrier;
//		
//	}
//	public JLabel getCruiser() {
//		return cruiser;
//	}
//	
//	public JLabel getSubmarine() {
//		return submarine;
//	}
}