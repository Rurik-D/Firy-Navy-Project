package Assets;

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

import Frame.Menu;
import Util.FrameProportion;

public class Background extends FrameProportion {

	private static Image image;
	private static JLabel background;
	
	public static JLabel getMenuBackground(int width, int height) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("img\\yamato.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		image = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		background = new JLabel(imageIcon);
		background.setBounds(0, 0, width, height);
		return background;
	}
	
	public static JLabel getGridBackground(int width, int height) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("img\\water.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		image = img.getScaledInstance(width, height,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(image);
		
		background = new JLabel(imageIcon);
		background.setBounds(0, 0, width, height);
		return background;
	}
	
	public static JPanel getTitle() {
		JLabel title = new JLabel("Firy");
		JLabel title1 = new JLabel("Navy");
		JLabel title2 = new JLabel("Project");
		JPanel titlePanel = new JPanel();
		
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
	
	private static void setTitle(JLabel title, int y, int fontDim) {
		title.setFont(new Font("Segoe Script", Font.BOLD, fontDim));
		title.setBounds(0, y, titleLblW, titleLblH);
		title.setVisible(true);
		title.setForeground(Color.RED.darker().darker());
	}
}
