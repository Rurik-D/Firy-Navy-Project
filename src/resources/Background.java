package resources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.frame.Menu;
import utils.FrameProportion;

public class Background extends FrameProportion {

	private static Image image;
	private static JLabel background;
	private static JLabel menuBackground = setBackground("src/resources/images/yamato.jpg");
	private static JLabel gameBackground = setBackground("src/resources/images/world_map.jpg");
	private static JLabel title = new JLabel("Firy");
	private static JLabel title1 = new JLabel("Navy");
	private static JLabel title2 = new JLabel("Project");
	private static JPanel titlePanel = new JPanel();
	
	public static JLabel getMenuBackground() {
		return menuBackground;
	}
	
	public static JLabel getGameBackground() {

		return gameBackground;
	}
	
	public static JLabel getGridBackground(int width, int height) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("src/resources/images/water.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		image = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		menuBackground = new JLabel(imageIcon);
		menuBackground.setBounds(0, 0, width, height);
		return menuBackground;
	}
	
	public static JPanel getTitle() {
		
		setTitle(title, 0, titleFontDim);
		setTitle(title1, titleSpacing, titleFontDim);
		setTitle(title2, titleSpacing*2, titleFontDim);
		
		titlePanel.setBounds(titleX, titleY, titleW, titleH);
		titlePanel.setLayout(null);
		titlePanel.add(title);
		titlePanel.add(title1);
		titlePanel.add(title2);
		titlePanel.setOpaque(false);
		return titlePanel;
	}
	
	private static JLabel setBackground(String file) {
	BufferedImage img = null;
	try {
	    img = ImageIO.read(new File(file));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	image = img.getScaledInstance(Menu.WIDTH, Menu.HEIGHT, Image.SCALE_SMOOTH);
	ImageIcon imageIcon = new ImageIcon(image);
	
	background = new JLabel(imageIcon);
	background.setBounds(0, 0, Menu.WIDTH, Menu.HEIGHT);
	return background;
}
	
	private static void setTitle(JLabel title, int y, int fontDim) {
		title.setFont(new Font("Segoe Script", Font.BOLD, fontDim));
		title.setBounds(0, y, titleLblW, titleLblH);
		title.setVisible(true);
		title.setForeground(Color.RED.darker().darker());
	}
	
	
	public static void showTitle() {
		title.setVisible(true);
		title1.setVisible(true);
		title2.setVisible(true);
		titlePanel.setVisible(true);
	}
	
	public static void hideTitle() {
		title.setVisible(false);
		title1.setVisible(false);
		title2.setVisible(false);
		titlePanel.setVisible(false);
	}
}
