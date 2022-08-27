package main.frame;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import resources.*;
import utils.FrameProportion;

import java.util.Locale;
import java.util.ResourceBundle;

public class GameButtons extends FrameProportion{
	
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.gameOptionBtn"));
	private static JButton mainMenuBtn = new JButton(resourceBundle.getString("button.mainMenuBtn"));
	private static JButton backToGameBtn = new JButton(resourceBundle.getString("button.backToGameBtn")); 
	private static JButton yesSaveBtn = new JButton(resourceBundle.getString("button.yesSaveBtn"));
	private static JButton noSaveBtn = new JButton(resourceBundle.getString("button.noSaveBtn"));
	private static JButton backToGameOptionBtn = new JButton(resourceBundle.getString("button.backToGameOptionBtn"));
	private static JLabel saveLabel = new JLabel(resourceBundle.getString("button.saveLabel"));
	
	public GameButtons(JPanel menu) {
		
		
		
		gameOptionBtn.setVisible(false);
		mainMenuBtn.setVisible(false);
		backToGameBtn.setVisible(false);
		yesSaveBtn.setVisible(false);
		noSaveBtn.setVisible(false);
		saveLabel.setVisible(false);
		backToGameOptionBtn.setVisible(false);
		
		
		gameOptionBtn.setBounds((Menu.WIDTH/2) - 100, 10, 200, 40);
		mainMenuBtn.setBounds((Menu.WIDTH/2) - 150, 60, 300, 40);
		backToGameBtn.setBounds((Menu.WIDTH/2) - 200, 100, 400, 40);
		yesSaveBtn.setBounds((Menu.WIDTH/2) - extLabelW/2 +20 , 60, yesBtnW, buttonH);
		noSaveBtn.setBounds((Menu.WIDTH/2) - 85, 60, yesBtnW, buttonH);
		backToGameOptionBtn.setBounds((Menu.WIDTH/2) -30 , 60, buttonW, buttonH);
		saveLabel.setBounds((Menu.WIDTH/2) - extLabelW/2, 10, extLabelW, buttonH);
		
		gameOptionBtn.setFont(font);
		mainMenuBtn.setFont(font);
		backToGameBtn.setFont(font);
		yesSaveBtn.setFont(font);
		noSaveBtn.setFont(font);
		backToGameOptionBtn.setFont(font);
		saveLabel.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(mainMenuBtn);
		setTrasparent(backToGameBtn);
		setTrasparent(yesSaveBtn);
		setTrasparent(noSaveBtn);
		setTrasparent(backToGameOptionBtn);
		
		
		menu.add(mainMenuBtn);
		menu.add(gameOptionBtn);
		menu.add(backToGameBtn);
		menu.add(noSaveBtn);
		menu.add(yesSaveBtn);
		menu.add(backToGameOptionBtn);
		menu.add(saveLabel);
		
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
				yesSaveBtn.setVisible(true);
				noSaveBtn.setVisible(true);
				saveLabel.setVisible(true);
				backToGameOptionBtn.setVisible(true);

			}
		});
		yesSaveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				backToGameOptionBtn.setVisible(false);

				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				Menu.getPlayerGrid().setVisible(false);
				Menu.getEnemyGrid().setVisible(false);
				Menu.getShips().getAssaultShip().setVisible(false);
				Menu.getShips().getBattleship().setVisible(false);
				Menu.getShips().getCarrier().setVisible(false);
				Menu.getShips().getCruiser().setVisible(false);
				Menu.getShips().getSubmarine().setVisible(false);

				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getBoxBtn().setVisible(false);
			}
		});
	
		noSaveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				backToGameOptionBtn.setVisible(false);
				Menu.getPlayerGrid().setVisible(false);
				Menu.getEnemyGrid().setVisible(false);
				Menu.getShips().getAssaultShip().setVisible(false);
				Menu.getShips().getBattleship().setVisible(false);
				Menu.getShips().getCarrier().setVisible(false);
				Menu.getShips().getCruiser().setVisible(false);
				Menu.getShips().getSubmarine().setVisible(false);

				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getBoxBtn().setVisible(false);
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
		backToGameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				backToGameOptionBtn.setVisible(false);
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
	public static void setGameBtnsLanguage(String kLang) {
		resourceBundle  = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag(kLang)) ;

		gameOptionBtn.setText(resourceBundle.getString("button.gameOptionBtn"));
		mainMenuBtn.setText(resourceBundle.getString("button.mainMenuBtn"));
		backToGameBtn.setText(resourceBundle.getString("button.backToGameBtn")); 
		yesSaveBtn.setText(resourceBundle.getString("button.yesSaveBtn"));
		noSaveBtn.setText(resourceBundle.getString("button.noSaveBtn"));
		backToGameOptionBtn.setText(resourceBundle.getString("button.backToGameOptionBtn"));
		saveLabel.setText(resourceBundle.getString("button.saveLabel"));
	}
	
	

}