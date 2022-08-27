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
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.newOptionBtn"));
	private JButton gameBackBtn = new JButton(resourceBundle.getString("button.newBackToMenuBtn"));
	private JButton newPauseBtn = new JButton(resourceBundle.getString("button.newPauseBtn")); 
	
	public GameButtons(JPanel menu) {
		
		gameOptionBtn.setVisible(false);
		gameBackBtn.setVisible(false);
		newPauseBtn.setVisible(false);
		
		gameOptionBtn.setBounds((Menu.WIDTH/2) - 100, 20, 200, 50);
		gameBackBtn.setBounds((Menu.WIDTH/2) - 200, 60, 200, 50);
		newPauseBtn.setBounds((Menu.WIDTH/2) - 50, 60, 200, 50);
		
		gameOptionBtn.setFont(font);
		gameBackBtn.setFont(font);
		newPauseBtn.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(gameBackBtn);
		setTrasparent(newPauseBtn);
		
		menu.add(gameBackBtn);
		menu.add(gameOptionBtn);
		menu.add(newPauseBtn);
		
		gameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				gameBackBtn.setVisible(true);
				newPauseBtn.setVisible(true);
			}
		});
		
		gameBackBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				gameBackBtn.setVisible(false);
				newPauseBtn.setVisible(false);
				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
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
