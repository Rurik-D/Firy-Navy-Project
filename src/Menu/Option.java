package Menu;

import javax.swing.JPanel;

public class Option {
	private final int WIDTH;
	private final int HEIGHT;
	private Background background;
	private JPanel option = new JPanel();
	
	public Option(int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.background = new Background(WIDTH, HEIGHT);
		
		option.setBounds(0, 0, WIDTH, HEIGHT);
		option.setLayout(null);
		option.add(background.getBackground());
		
		
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
