package resources;

import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Ships {
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private JLabel carrier;
	private JLabel battleship;
	private JLabel cruiser;
	private JLabel submarine;
	private JLabel assaultShip;
	private Image image;
	
	public Ships() {
		carrier = getShip(100, 700, "5_carrier");
		battleship = getShip(200, 700, "4_battleship");
		cruiser = getShip(300, 700, "3_cruiser");
		submarine = getShip(400, 700, "3_submarine");
		assaultShip = getShip(500, 700, "2_assaultShip");
		
	}

	private  JLabel getShip(int x, int y, String type) {
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
		
		JLabel ship = new JLabel(imageIcon);
		ship.setBounds(x, y, shipW, shipH);

		return ship;
	}
	
	public JLabel getAssaultShip() {
		return assaultShip;
	}
	
	public JLabel getBattleship() {
		return battleship;
	}
	
	public JLabel getCarrier() {
		return carrier;
		
	}
	public JLabel getCruiser() {
		return cruiser;
	}
	
	public JLabel getSubmarine() {
		return submarine;
	}
}