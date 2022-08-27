package main.frame;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import resources.*;
import utils.FrameProportion;

import java.util.Locale;
import java.util.ResourceBundle;

public class GameButtons extends FrameProportion{
	
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.gameOptionBtn"));
	private JButton mainMenuBtn = new JButton(resourceBundle.getString("button.mainMenuBtn"));
	private JButton backToGameBtn = new JButton(resourceBundle.getString("button.backToGameBtn")); 
	
	public GameButtons(JPanel menu) {
		
		gameOptionBtn.setVisible(false);
		mainMenuBtn.setVisible(false);
		backToGameBtn.setVisible(false);
		
		gameOptionBtn.setBounds((Menu.WIDTH/2) - 100, 20, 200, 40);
		mainMenuBtn.setBounds((Menu.WIDTH/2) - 150, 60, 300, 40);
		backToGameBtn.setBounds((Menu.WIDTH/2) - 200, 100, 400, 40);
		
		gameOptionBtn.setFont(font);
		mainMenuBtn.setFont(font);
		backToGameBtn.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(mainMenuBtn);
		setTrasparent(backToGameBtn);
		
		menu.add(mainMenuBtn);
		menu.add(gameOptionBtn);
		menu.add(backToGameBtn);
		
		gameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				mainMenuBtn.setVisible(true);
				backToGameBtn.setVisible(true);
			}
		});
		
		mainMenuBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
			}
		});
		
		backToGameBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
			}
		});
	}
	
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	public static JButton getGameOptionBtn() {
		return gameOptionBtn;
	}
	
	

}
