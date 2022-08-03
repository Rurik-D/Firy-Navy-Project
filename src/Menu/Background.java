package Menu;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background {
	private final int WIDTH;
	private final int HEIGHT;
	private Image image;
	private JLabel background;
	
	/*
	 * Create a label that will be used as background in 
	 * menu panels 
	 */
	public Background(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("img\\yamato.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		image = img.getScaledInstance(WIDTH, HEIGHT,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		background = new JLabel(imageIcon);
		background.setBounds(0, 0, WIDTH, HEIGHT);
		
	}

	
	public JLabel getBackground() {
		return background;
	}
	
	
}
