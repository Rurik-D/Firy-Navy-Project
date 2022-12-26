package main.gui;

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
import main.core.Pve;
import main.navy.Ship;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class GameButtons implements FrameProportion{
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.gameOption"));
	private static JButton mainMenuBtn = new JButton(resourceBundle.getString("button.mainMenu"));
	private static JButton backToGameBtn = new JButton(resourceBundle.getString("button.back")); 
	private static JButton yesBtn = new JButton(resourceBundle.getString("button.yes"));
	private static JButton noBtn = new JButton(resourceBundle.getString("button.no"));
	private static JButton confirmSetupBtn = new JButton(resourceBundle.getString("button.confirmSetup"));
	private static JLabel mainMenuLbl = new JLabel(resourceBundle.getString("button.saveLabel"));
	private static JLabel timerLbl = GameTimer.getTimerLbl();
	private static JLabel oldScroll = ImagesManagement.getOldScroll();
	private static TextManagement textManage = MainFrame.getTextManage();
	private static boolean confirmSetupVisible = true;
	private static boolean confirmSetupEnabled = false;
	private static boolean pause = false;

	
	/**
	 * 
	 * 
	 */
	public GameButtons(JPanel mainPanel) {
		
		gameOptionBtn.setVisible(false);
		mainMenuBtn.setVisible(false);
		backToGameBtn.setVisible(false);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
		mainMenuLbl.setVisible(false);
		timerLbl.setVisible(false);
		confirmSetupBtn.setVisible(false);
		
		gameOptionBtn.setBounds(gameOptionX, gameOptionY, gameOptionW, buttonH);
		backToGameBtn.setBounds(backToGameX, gameTopBtnsY, backToGameW, buttonH);
		mainMenuBtn.setBounds(mainMenuBtnX, gameOptionY, mainMenuBtnW, buttonH);
		yesBtn.setBounds(yesSaveBtnX, gameTopBtnsY, yesBtnW, buttonH);
		noBtn.setBounds(noSaveBtnX, gameTopBtnsY, yesBtnW, buttonH);
		mainMenuLbl.setBounds(mainMenuLblX, gameOptionY, mainMenuLblW, buttonH);
		timerLbl.setBounds(timerLblX, gameTopBtnsY, timerLblW, buttonH);
		confirmSetupBtn.setBounds(confirmSetupX, confirmSetupY, confirmSetupW, buttonH);
		
		gameOptionBtn.setFont(font);
		mainMenuBtn.setFont(font);
		backToGameBtn.setFont(font);
		yesBtn.setFont(font);
		noBtn.setFont(font);
		mainMenuLbl.setFont(font);
		timerLbl.setFont(font);
		confirmSetupBtn.setFont(font);
		
		setTrasparent(gameOptionBtn);
		setTrasparent(mainMenuBtn);
		setTrasparent(backToGameBtn);
		setTrasparent(yesBtn);
		setTrasparent(noBtn);
		setTrasparent(confirmSetupBtn);
		
		mainPanel.add(mainMenuBtn);
		mainPanel.add(gameOptionBtn);
		mainPanel.add(backToGameBtn);
		mainPanel.add(noBtn);
		mainPanel.add(yesBtn);
		mainPanel.add(mainMenuLbl);
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
				yesBtn.setVisible(true);
				noBtn.setVisible(true);
				mainMenuLbl.setVisible(true);

			}
		});
		yesBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				SoundsManagement.stop("gameSong");
				SoundsManagement.start("menuSong");

				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				mainMenuLbl.setVisible(false);
				MainFrame.getScrollPnl().setVisible(false);
				Pve.getPositionGrid().setVisible(false);
				Pve.getAttackGrid().setVisible(false);
				pause = false;
				
				int Xpos = 200;				
				for (Ship ship: Pve.getNavy().getPlayerNavy()) {
					
					// se ho confermato il setup rimuovo le navi dalla griglia e le aggiungo al main panel
					if (!confirmSetupVisible) {
						Pve.getPositionGrid().remove(ship);;
						MainFrame.getMainPanel().add(ship);
					}
					ship.setLocation(Xpos, 650);
					ship.setVisible(false);
					Xpos += 50;
				}
				
				// se ho confermato il setup rimuovo le navi dalla griglia e le aggiungo al main panel
				if (!confirmSetupVisible) {
					Pve.resetGrids();

					MainFrame.getMainPanel().remove(ImagesManagement.getGameBackground());
					MainFrame.getMainPanel().remove(oldScroll);
					MainFrame.getMainPanel().remove(Pve.getPositionGrid());
					MainFrame.getMainPanel().add(Pve.getPositionGrid());
					MainFrame.getMainPanel().add(oldScroll);
					MainFrame.getMainPanel().add(ImagesManagement.getGameBackground());
				}
				
				oldScroll.setVisible(false);

				ImagesManagement.getMenuBackground().setVisible(true);
				TextManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getPlayerAvatarLbl().setVisible(false);
				MenuButtons.getSquareLabel().setVisible(false);
				MenuButtons.getComputerAvatarLbl().setVisible(false);
				MenuButtons.getSquareCpuLabel().setVisible(false);
				timerLbl.setVisible(false);
				confirmSetupVisible = true;
				
//				Pve.getAttackGrid().resetGrid();
//				Pve.getPositionGrid().resetGrid();
				
				GameTimer.resetTimer();
			}
		});
	
		noBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				if (confirmSetupVisible) {confirmSetupBtn.setVisible(true);}
				gameOptionBtn.setVisible(true);
				timerLbl.setVisible(true);
				mainMenuBtn.setVisible(false);
				backToGameBtn.setVisible(false);
				yesBtn.setVisible(false);
				noBtn.setVisible(false);
				mainMenuLbl.setVisible(false);
				noBtn.setVisible(false);
				pause = false;
				textManage.resumeMessage();
				GameTimer.startTimer();

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

		
		confirmSetupBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (confirmSetupEnabled)  {
					confirmSetupVisible = false;
					confirmSetupEnabled = false;
					confirmSetupBtn.setVisible(false);
					
					// rimuovo le barche dal MainPanel e le aggiungo alla griglia
					
					Pve.getPositionGrid().remove(Pve.getPositionGrid().getGridBackground());
					
					for (Ship ship: Pve.getNavy().getPlayerNavy()) {
						int shipX = ship.getX() - Pve.getPositionGrid().getX();
						int shipY = ship.getY() - Pve.getPositionGrid().getY();;
						
						MainFrame.getMainPanel().remove(ship);
						ship.setLocation(shipX, shipY);
						Pve.getPositionGrid().add(ship);

					}
					Pve.getPositionGrid().add(Pve.getPositionGrid().getGridBackground());
					
					oldScroll.setVisible(false);
					SoundsManagement.clickMenuBtn();
					Pve.setComputerNavy();
					Pve.getAttackGrid().setAttGridButtons(Pve.getComputerNavy(), Pve.getNavy().getPlayerNavy());
					Pve.getNavy().setPlayerNavyDamages();
					Pve.getNavy().setComputerNavyDamages();
					MainFrame.getTextManage().confirmSetupMessage();;
				} else {
					MainFrame.getTextManage().notConfirmMessage();
				}

			}
		});
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JButton getGameOptionBtn() {
		return gameOptionBtn;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JButton getConfirmSetupBtn() {
		return confirmSetupBtn;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void setConfirmSetupEnabled(boolean en) {
		confirmSetupEnabled = en;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static boolean getPause() {
		return pause;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static boolean getConfirmSetupVisible() {
		return confirmSetupVisible;
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void setGameBtnsLanguage(String kLang) {
		resourceBundle  = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag(kLang)) ;

		gameOptionBtn.setText(resourceBundle.getString("button.gameOption"));
		mainMenuBtn.setText(resourceBundle.getString("button.mainMenu"));
		backToGameBtn.setText(resourceBundle.getString("button.back")); 
		yesBtn.setText(resourceBundle.getString("button.yes"));
		noBtn.setText(resourceBundle.getString("button.no"));
		mainMenuLbl.setText(resourceBundle.getString("button.saveLabel"));
	}
	
}