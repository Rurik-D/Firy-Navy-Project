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
import utils.GameTimer;
import main.core.Main;
import main.core.Pve;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
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
	private static JLabel timerLbl = GameTimer.getTimerLbl();
	private static boolean confirmSetupVisible = true;
	private static boolean confirmSetupEnabled = false;
	private static boolean pause = false;
	private static TextManagement textManage = Main.getTextManage();
	

	
	
	public GameButtons(JPanel mainPanel) {
		
		gameOptionBtn.setVisible(false);
		mainMenuBtn.setVisible(false);
		backToGameBtn.setVisible(false);
		yesSaveBtn.setVisible(false);
		noSaveBtn.setVisible(false);
		saveLabel.setVisible(false);
		backToGameOptionBtn.setVisible(false);
		timerLbl.setVisible(false);
		confirmSetupBtn.setVisible(false);
		
		gameOptionBtn.setBounds((Main.WIDTH/2) - 100, 10, 200, 40);
		mainMenuBtn.setBounds((Main.WIDTH/2) - 150, 60, 300, 40);
		backToGameBtn.setBounds((Main.WIDTH/2) - 200, 100, 400, 40);
		yesSaveBtn.setBounds((Main.WIDTH/2) - extLabelW/2 +20 , 60, yesBtnW, buttonH);
		noSaveBtn.setBounds((Main.WIDTH/2) - 85, 60, yesBtnW, buttonH);
		backToGameOptionBtn.setBounds((Main.WIDTH/2) - 30, 60, buttonW, buttonH);
		saveLabel.setBounds((Main.WIDTH/2) - extLabelW/2, 10, extLabelW, buttonH);
		timerLbl.setBounds((Main.WIDTH/2) - 60, 60, 150, 40);
		confirmSetupBtn.setBounds(300, 760, 300, 40);
		
		gameOptionBtn.setFont(font);
		mainMenuBtn.setFont(font);
		backToGameBtn.setFont(font);
		yesSaveBtn.setFont(font);
		noSaveBtn.setFont(font);
		backToGameOptionBtn.setFont(font);
		saveLabel.setFont(font);
		timerLbl.setFont(font);
		confirmSetupBtn.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(mainMenuBtn);
		setTrasparent(backToGameBtn);
		setTrasparent(yesSaveBtn);
		setTrasparent(noSaveBtn);
		setTrasparent(backToGameOptionBtn);
		setTrasparent(confirmSetupBtn);
		
		mainPanel.add(mainMenuBtn);
		mainPanel.add(gameOptionBtn);
		mainPanel.add(backToGameBtn);
		mainPanel.add(noSaveBtn);
		mainPanel.add(yesSaveBtn);
		mainPanel.add(backToGameOptionBtn);
		mainPanel.add(saveLabel);
		mainPanel.add(timerLbl);
		mainPanel.add(confirmSetupBtn);

		
		gameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				gameOptionBtn.setVisible(false);
				confirmSetupBtn.setVisible(false);
				timerLbl.setVisible(false);
				mainMenuBtn.setVisible(true);
				backToGameBtn.setVisible(true);
				GameTimer.stopTimer();
				pause = true;
				textManage.pauseMessage();
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
				SoundsManagement.stop("gameSong");
				SoundsManagement.start("menuSong");

				backToGameOptionBtn.setVisible(false);
				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				Main.getScrollPnl().setVisible(false);
				Pve.getPositionGrid().setVisible(false);
				Pve.getAttackGrid().setVisible(false);
				pause = false;
				
				int Xpos = 200;
				for (int i = 0; i<10; i++) {
					Pve.getNavy().getPlayerNavy().get(i).setVisible(false);
					Pve.getNavy().getPlayerNavy().get(i).setLocation(Xpos, 650);
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
				timerLbl.setVisible(false);
				GameTimer.resetTimer();

			}
		});
	
		noSaveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				SoundsManagement.stop("gameSong");
				SoundsManagement.start("menuSong");
				
				backToGameOptionBtn.setVisible(false);
				Main.getScrollPnl().setVisible(false);
				Pve.getPositionGrid().setVisible(false);
				Pve.getAttackGrid().setVisible(false);
				pause = false;
				
				int Xpos = 200;
				for (int i = 0; i<10; i++) {
					Pve.getNavy().getPlayerNavy().get(i).setVisible(false);
					Pve.getNavy().getPlayerNavy().get(i).setLocation(Xpos, 650);
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
				timerLbl.setVisible(false);
				GameTimer.resetTimer();


			}
		});
		
		backToGameBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				if (confirmSetupVisible) {confirmSetupBtn.setVisible(true);}
				gameOptionBtn.setVisible(true);
				timerLbl.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				pause = false;
				textManage.resumeMessage();
				GameTimer.startTimer();
			}
		});
		backToGameOptionBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				if (confirmSetupVisible) {confirmSetupBtn.setVisible(true);}
				gameOptionBtn.setVisible(true);
				timerLbl.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				backToGameOptionBtn.setVisible(false);
				pause = false;
				textManage.resumeMessage();
				GameTimer.startTimer();
			}
		});
		
		confirmSetupBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (confirmSetupEnabled)  {
					confirmSetupVisible = false;
					confirmSetupEnabled = false;
					confirmSetupBtn.setVisible(false);
					Main.getOldScroll().setVisible(false);
					SoundsManagement.clickMenuBtn();
					Pve.getAttackGrid().setAttackGrid(Pve.getRandomNavy(), Pve.getNavy().getPlayerNavy());
					Main.getTextManage().confirmSetupMessage();;
				} else {
					Main.getTextManage().notConfirmMessage();
				}

			}
		});
	}
	public static JButton getGameOptionBtn() {
		return gameOptionBtn;
	}
	
	public static JButton getConfirmSetupBtn() {
		return confirmSetupBtn;
	}
	
	public static void setConfirmSetupEnabled(boolean en) {
		confirmSetupEnabled = en;
	}
	
	public static boolean getPause() {
		return pause;
	}
	
	public static boolean getConfirmSetupVisible() {
		return confirmSetupVisible;
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