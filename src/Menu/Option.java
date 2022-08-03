package Menu;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Option {
	private final int WIDTH;
	private final int HEIGHT;
	private Background background;
	private JPanel option = new JPanel();
	private JPanel menu;
	private JFrame frame;
	
	public Option(int width, int height, JFrame frame, JPanel menu) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.background = new Background(WIDTH, HEIGHT);
		this.frame = frame;
		this.menu = menu;
		
		option.setBounds(0, 0, WIDTH, HEIGHT);
		option.setLayout(null);
		option.add(background.getBackground());
		option.setVisible(false);
		
		
		JButton backBtn = new JButton("BACK");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.getContentPane().add(menu);
				menu.setVisible(true);
				option.setVisible(false);
				
			}
		});
		backBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		backBtn.setBounds(68, 679, 218, 21);
		option.add(backBtn);
	}
	
	
	public JPanel getOption() {
		return option;
	}
	
	public void start() {
		option.setVisible(true);
	}
	
	public void off() {
		option.setVisible(false);
	}
	
}
