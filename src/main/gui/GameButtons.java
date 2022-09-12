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
import main.core.Main;
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
	private static JButton gameOptionBtn = new JButton(resourceBundle.getString("button.gameOptionBtn"));
	private static JButton mainMenuBtn = new JButton(resourceBundle.getString("button.mainMenuBtn"));
	private static JButton backToGameBtn = new JButton(resourceBundle.getString("button.backToGameBtn")); 
	private static JButton yesSaveBtn = new JButton(resourceBundle.getString("button.yesSaveBtn"));
	private static JButton noSaveBtn = new JButton(resourceBundle.getString("button.noSaveBtn"));
	private static JButton backToGameOptionBtn = new JButton(resourceBundle.getString("button.backToGameOptionBtn"));
	private static JButton confirmSetupBtn = new JButton(resourceBundle.getString("button.confirmSetup"));
	private static JLabel saveLabel = new JLabel(resourceBundle.getString("button.saveLabel"));
	private static JLabel timerLbl = GameTimer.getTimerLbl();
	private static JLabel oldScroll = ImagesManagement.getOldScroll();
	private static boolean confirmSetupVisible = true;
	private static boolean confirmSetupEnabled = false;
	private static boolean pause = false;
	private static TextManagement textManage = MainFrame.getTextManage();

	
	/**
	 * 
	 * 
	 */
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
		
		gameOptionBtn.setBounds(gameOptionX, gameOptionY, gameOptionW, buttonH);
		backToGameBtn.setBounds((MainFrame.WIDTH/2) - 200, 60, 400, buttonH);
		mainMenuBtn.setBounds((MainFrame.WIDTH/2) - 150, 100, 300, buttonH);
		yesSaveBtn.setBounds((MainFrame.WIDTH/2) - extLabelW/2 +20 , 60, yesBtnW, buttonH);
		noSaveBtn.setBounds((MainFrame.WIDTH/2) - 85, 60, yesBtnW, buttonH);
		backToGameOptionBtn.setBounds((MainFrame.WIDTH/2) - 30, 60, buttonW, buttonH);
		saveLabel.setBounds((MainFrame.WIDTH/2) - extLabelW/2, 10, extLabelW, buttonH);
		timerLbl.setBounds((MainFrame.WIDTH/2) - 60, 60, 150, buttonH);
		confirmSetupBtn.setBounds(300, 760, 300, buttonH);
		
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
				GameTimer.resetTimer();

			}
		});
	
		noSaveBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				SoundsManagement.stop("gameSong");
				SoundsManagement.start("menuSong");
				
				backToGameOptionBtn.setVisible(false);
				MainFrame.getScrollPnl().setVisible(false);
				Pve.getPositionGrid().setVisible(false);
				Pve.getAttackGrid().setVisible(false);
				pause = false;
				
				int Xpos = 200;
				for (int i = 0; i<10; i++) {
					Pve.getNavy().getPlayerNavy().get(i).setVisible(false);
					Pve.getNavy().getPlayerNavy().get(i).setLocation(Xpos, 650);
					Pve.getNavy().getComputerNavy().get(i).resetLocation();
					Xpos += 50;
				}
				oldScroll.setVisible(false);

				yesSaveBtn.setVisible(false);
				noSaveBtn.setVisible(false);
				saveLabel.setVisible(false);
				ImagesManagement.getMenuBackground().setVisible(true);
				TextManagement.showTitle();
				MenuButtons.openMenu();
				MenuButtons.getPlayerAvatarLbl().setVisible(false);
				MenuButtons.getSquareLabel().setVisible(false);
				MenuButtons.getComputerAvatarLbl().setVisible(false);
				MenuButtons.getSquareCpuLabel().setVisible(false);
				timerLbl.setVisible(false);
				confirmSetupVisible = true;
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
					Pve.getAttackGrid().setAttackGrid(Pve.getComputerNavy(), Pve.getNavy().getPlayerNavy());
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

		gameOptionBtn.setText(resourceBundle.getString("button.gameOptionBtn"));
		mainMenuBtn.setText(resourceBundle.getString("button.mainMenuBtn"));
		backToGameBtn.setText(resourceBundle.getString("button.backToGameBtn")); 
		yesSaveBtn.setText(resourceBundle.getString("button.yesSaveBtn"));
		noSaveBtn.setText(resourceBundle.getString("button.noSaveBtn"));
		backToGameOptionBtn.setText(resourceBundle.getString("button.backToGameOptionBtn"));
		saveLabel.setText(resourceBundle.getString("button.saveLabel"));
	}
	
}