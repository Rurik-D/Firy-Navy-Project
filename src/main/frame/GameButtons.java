package main.frame;

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Locale;
import java.util.ResourceBundle;

import resources.*;
import utils.FrameProportion;
import main.core.Main;

public class GameButtons extends FrameProportion{
	
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.gameOptionBtn"));
	private static JButton mainMenuBtn = new JButton(resourceBundle.getString("button.mainMenuBtn"));
	private static JButton backToGameBtn = new JButton(resourceBundle.getString("button.backToGameBtn")); 
	private static JButton yesSaveBtn = new JButton(resourceBundle.getString("button.yesSaveBtn"));
	private static JButton noSaveBtn = new JButton(resourceBundle.getString("button.noSaveBtn"));
	private static JButton backToGameOptionBtn = new JButton(resourceBundle.getString("button.backToGameOptionBtn"));
	private static JButton confirmSetupBtn = new JButton(resourceBundle.getString("button.confirmSetup"));
	private static JLabel saveLabel = new JLabel(resourceBundle.getString("button.saveLabel"));
	private static JLabel jlbTimer = new JLabel("");
	private static boolean enable = false;
	
	
	public GameButtons(JPanel menu) {
		
		gameOptionBtn.setVisible(false);
		mainMenuBtn.setVisible(false);
		backToGameBtn.setVisible(false);
		yesSaveBtn.setVisible(false);
		noSaveBtn.setVisible(false);
		saveLabel.setVisible(false);
		backToGameOptionBtn.setVisible(false);
		jlbTimer.setVisible(false);
		confirmSetupBtn.setVisible(false);
		
		gameOptionBtn.setBounds((Main.WIDTH/2) - 100, 10, 200, 40);
		mainMenuBtn.setBounds((Main.WIDTH/2) - 150, 60, 300, 40);
		backToGameBtn.setBounds((Main.WIDTH/2) - 200, 100, 400, 40);
		yesSaveBtn.setBounds((Main.WIDTH/2) - extLabelW/2 +20 , 60, yesBtnW, buttonH);
		noSaveBtn.setBounds((Main.WIDTH/2) - 85, 60, yesBtnW, buttonH);
		backToGameOptionBtn.setBounds((Main.WIDTH/2) - 30, 60, buttonW, buttonH);
		saveLabel.setBounds((Main.WIDTH/2) - extLabelW/2, 10, extLabelW, buttonH);
		jlbTimer.setBounds((Main.WIDTH/2) - 40, 60, 150, 40);
		confirmSetupBtn.setBounds(300, 760, 300, 40);
		
		gameOptionBtn.setFont(font);
		mainMenuBtn.setFont(font);
		backToGameBtn.setFont(font);
		yesSaveBtn.setFont(font);
		noSaveBtn.setFont(font);
		backToGameOptionBtn.setFont(font);
		saveLabel.setFont(font);
		jlbTimer.setFont(font);
		confirmSetupBtn.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(mainMenuBtn);
		setTrasparent(backToGameBtn);
		setTrasparent(yesSaveBtn);
		setTrasparent(noSaveBtn);
		setTrasparent(backToGameOptionBtn);
		setTrasparent(confirmSetupBtn);
		
		menu.add(mainMenuBtn);
		menu.add(gameOptionBtn);
		menu.add(backToGameBtn);
		menu.add(noSaveBtn);
		menu.add(yesSaveBtn);
		menu.add(backToGameOptionBtn);
		menu.add(saveLabel);
		menu.add(jlbTimer);
		menu.add(confirmSetupBtn);

		
		gameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				confirmSetupBtn.setVisible(false);
				jlbTimer.setVisible(false);
				MenuButtons.timer.stop();
				mainMenuBtn.setVisible(true);
				backToGameBtn.setVisible(true);
				
			}
		});
		
		mainMenuBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				confirmSetupBtn.setVisible(false);
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
				Main.getScrollPnl().setVisible(false);
				Main.getPlayerGrid().setVisible(false);
				Main.getEnemyGrid().setVisible(false);
				int Xpos = 200;
				for (int i = 0; i<10; i++) {
					Main.getShips().getNavy().get(i).setVisible(false);
					Main.getShips().getNavy().get(i).setLocation(Xpos, 650);
					Xpos += 50;
				}
				Main.getOldScroll().setVisible(false);

				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getBoxBtn().setVisible(false);
				MenuButtons.getBoxLabel().setVisible(false);
				MenuButtons.getBoxCpuBtn().setVisible(false);
				MenuButtons.getBoxCpuLabel().setVisible(false);
				jlbTimer.setVisible(false);
			}
		});
	
		noSaveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				backToGameOptionBtn.setVisible(false);
				Main.getScrollPnl().setVisible(false);
				Main.getPlayerGrid().setVisible(false);
				Main.getEnemyGrid().setVisible(false);
				int Xpos = 200;
				for (int i = 0; i<10; i++) {
					Main.getShips().getNavy().get(i).setVisible(false);
					Main.getShips().getNavy().get(i).setLocation(Xpos, 650);
					Xpos += 50;
				}
				Main.getOldScroll().setVisible(false);

				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				ImagesManagement.getMenuBackground().setVisible(true);
				ImagesManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getBoxBtn().setVisible(false);
				MenuButtons.getBoxLabel().setVisible(false);
				MenuButtons.getBoxCpuBtn().setVisible(false);
				MenuButtons.getBoxCpuLabel().setVisible(false);
				jlbTimer.setVisible(false);

			}
		});
		
		backToGameBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(true);
				confirmSetupBtn.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				jlbTimer.setVisible(true);
				MenuButtons.timer.start();


			}
		});
		backToGameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(true);
				confirmSetupBtn.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				backToGameOptionBtn.setVisible(false);
				jlbTimer.setVisible(true);
				MenuButtons.timer.start();


			}
		});
		
		confirmSetupBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (enable)  {
					confirmSetupBtn.setVisible(false);
					Main.getOldScroll().setVisible(false);
					SoundsManagement.clickMenuBtn();
					Main.getEnemyGrid().setAttackGrid(Main.getShips().getrandomNavy(), Main.getShips().getNavy());
					Main.getText().confirmSetupMessage();;
				} else {
					Main.getText().notConfirmMessage();
				}

			}
		});
	}
	public static JButton getGameOptionBtn() {
		return gameOptionBtn;
	}
	
	public static JLabel getJlbTimer() {
		return jlbTimer;
	}
	
	public static JButton getConfirmSetupBtn() {
		return confirmSetupBtn;
	}
	
	public static void setConfirmSetupEnabled(boolean en) {
		enable = en;
	}
	
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
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