package resources;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.core.Main;
import main.gui.MainFrame;
import utils.FrameProportion;


/**
 * This class manage all the images of the program.
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class ImagesManagement implements FrameProportion{
	private static ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private static Image image;
	private static JLabel background;
	private static JLabel menuBackground = setBackground(imagesBundle.getString("image.yamato"));
	private static JLabel gameBackground = setBackground(imagesBundle.getString("image.worldMap"));
	private static JLabel gridBackground;
	private static JLabel oldScroll = setOldScroll(100, 550, 700, 300);;
	private static Toolkit kit = Toolkit.getDefaultToolkit();
	
	
	/**
	 * 
	 * 
	 */
	public static ImageIcon getImage(int w, int h, String file) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(file));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		image = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(image);
	}
	
	
	/**
	 * Returns a label containing the image of an old scroll, on which ships 
	 * will be spawned.
	 * 
	 * @see main.core.Main
	 * 
	 * @return JLabel with the image of an old scroll 
	 */
	public static JLabel getOldScroll() {
		return oldScroll;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JLabel getMenuBackground() {
		return menuBackground;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JLabel getGameBackground() {
		return gameBackground;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JLabel getGridBackground(int x, int y, int width, int height) {
		gridBackground = new JLabel(getImage(width, height, imagesBundle.getString("image.water")));
		gridBackground.setBounds(x, y, width, height);
		return gridBackground;
	}
	
	
	
	/**
	 * 
	 * 
	 */
	public static ImageIcon getShipImage(int shipW, int shipH, String type) {
		return getImage(shipW, shipH, imagesBundle.getString("image." + type));	
	}
	
	
	/**
	 * 
	 * 
	 */
	public static Icon getHitLbl(int squareSide) {
		return getImage(squareSide, squareSide, imagesBundle.getString("image.hit"));	
	}
	
	
	/**
	 * 
	 * 
	 */
	public static Icon getMissLbl(int squareSide) {
		return getImage(squareSide, squareSide, imagesBundle.getString("image.miss"));	
	}
	
	
	/**
	 * 
	 * 
	 */
	private static JLabel setBackground(String file) {
		background = new JLabel(getImage(MainFrame.WIDTH, MainFrame.HEIGHT, file));
		background.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		return background;
	}
	
	

	
	
	/**
	 * 
	 * 
	 */
	public static void setFrameIcon(JFrame frame) {
		Image img = kit.getImage(imagesBundle.getString("image.orangeShip"));
		frame.setIconImage(img);
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void setCursor(JFrame frame) {
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
		    	Image image = kit.getImage(imagesBundle.getString("image.missile"));
		    	Cursor a = kit.createCustomCursor(image , new Point(1, 1), null);
		    	frame.setCursor (a);
			}
		});
	}
	
	
	/**
	 * 
	 * 
	 */
	private static JLabel setOldScroll(int x, int y, int w, int h) {
		oldScroll = new JLabel(getImage(w, h, imagesBundle.getString("image.scroll")));
		oldScroll.setBounds(x, y, w, h);
		oldScroll.setVisible(false);
		return oldScroll;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void createAvatarPicture(String file, List<ImageIcon> avatarList) {
		
		avatarList.add(getImage(avatarSide, avatarSide, file));
	}
	
}
