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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.frame.Menu;
import utils.FrameProportion;

public class ImagesManagement extends FrameProportion {
	private static ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");

	private static Image image;
	private static JLabel background;
	private static JLabel menuBackground = setBackground(imagesBundle.getString("image.yamato"));
	private static JLabel gameBackground = setBackground(imagesBundle.getString("image.worldMap"));
	private static JLabel gridBackground = setBackground(imagesBundle.getString("image.water"));
	private static JLabel title = new JLabel("Firy");
	private static JLabel title1 = new JLabel("Navy");
	private static JLabel title2 = new JLabel("Project");
	private static JPanel titlePanel = new JPanel();
	private static Toolkit kit = Toolkit.getDefaultToolkit();
	private static Image imageAvatar;	
	
	public static JLabel getMenuBackground() {
		return menuBackground;
	}
	
	public static JLabel getGameBackground() {

		return gameBackground;
	}
	
	public static JLabel getGridBackground(int x, int y, int width, int height) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(imagesBundle.getString("image.water")));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		image = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		gridBackground = new JLabel(imageIcon);
		gridBackground.setBounds(x, y, width, height);
		return gridBackground;
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
	
	public static void setFrameIcon(JFrame frame) {
		Image img = kit.getImage(imagesBundle.getString("image.orangeShip"));
		frame.setIconImage(img);
	}
	
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
	
	public static void createAvatarPicture(String file_img, List<ImageIcon> avatarList) {
		BufferedImage imgShip = null;
		try {
		    imgShip = ImageIO.read(new File(file_img));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		imageAvatar = imgShip.getScaledInstance(avatarSide, avatarSide,Image.SCALE_SMOOTH);
		ImageIcon iconAvatar = new ImageIcon(imageAvatar);
		
		avatarList.add(iconAvatar);
		
	}
}
