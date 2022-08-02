package Menu;

import javax.swing.*;
import java.awt.*;

public class FrameM {
	
	private ImageIcon img;
	private JLabel jlabel;
	private JFrame frame;
	
	
	public FrameM() {
		img = new ImageIcon(this.getClass().getResource("/yamato.jpg"));
		jlabel = new JLabel(img);
		jlabel.setSize(500, 500);
		
		
		frame = new JFrame();
		frame.add(jlabel);
		frame.setVisible(true);
		//frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		
		
	}

}
