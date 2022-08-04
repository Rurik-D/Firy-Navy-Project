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

public class Background {
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
	
	public static JPanel getTitle(int width, int height) {
		int titleX = (int)Math.round(width * 66.40 / 100);
		int titleY = (int)Math.round(height * 8.10 / 100);
		int titleW = (int)Math.round(width * 26.04 / 100);
		int titleH = (int)Math.round(height * 57.87 / 100);
		int fontDim = (int)Math.round((width + height) * 2.08 / 100);
		
		JLabel title = new JLabel("Firy");
		JLabel title1 = new JLabel("Navy");
		JLabel title2 = new JLabel("Project");
		JPanel titlePanel = new JPanel();
		
		
		setTitle(title, 0, fontDim);
		setTitle(title1, 50, fontDim);
		setTitle(title2, 100, fontDim);
		
		
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
		title.setBounds(0, y, 400, 100);
		title.setVisible(true);
		title.setForeground(Color.RED.darker().darker());
	}
}
