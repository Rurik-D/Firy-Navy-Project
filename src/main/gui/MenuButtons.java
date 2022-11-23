package main.gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Locale;
import java.util.ResourceBundle;

import resources.*;
import utils.*;
import main.core.Pve;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class MenuButtons implements FrameProportion{
	
	private static ResourceBundle languageBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private static ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private static JButton startBtn = new JButton(languageBundle.getString("button.start"));
	private static JButton optionBtn = new JButton(languageBundle.getString("button.option"));
	private static JButton exitBtn = new JButton(languageBundle.getString("button.exit"));
	private JButton backToMenuBtn = new JButton(languageBundle.getString("button.back"));
	private JButton backToOptBtn = new JButton(languageBundle.getString("button.back"));
	private JButton langBtn = new JButton(languageBundle.getString("button.lang"));
	private JButton volumeBtn = new JButton(languageBundle.getString("button.volume"));
	private JButton extYesBtn = new JButton(languageBundle.getString("button.yes"));
	private JButton extNoBtn = new JButton(languageBundle.getString("button.no"));
	private JButton startGameBtn = new JButton(languageBundle.getString("button.startGame"));
	private JButton confirmBtn = new JButton(languageBundle.getString("button.confirm"));
	private JButton nicknameBtn = new JButton(languageBundle.getString("button.nickname"));
	private JButton itaBtn = new JButton(languageBundle.getString("button.ita"));
	private JButton engBtn = new JButton(languageBundle.getString("button.eng"));
	private JButton moreVolumeBtn = new JButton("+");
	private JButton lessVolumeBtn = new JButton("-");
	private JLabel extLabel = new JLabel(languageBundle.getString("label.extLabel"));
	private JLabel volumeLevel = new JLabel("50");
	private JLabel oldScroll = ImagesManagement.getOldScroll();
	private JTextField selectNickname = new JTextField();
	private static TextManagement textManage = MainFrame.getTextManage();

	private List<JButton> avatarBtns = new ArrayList<>();
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private boolean obstacle = true;
	private int volume;
	private static List<ImageIcon> avatarList = new ArrayList<>();
	private static int chosenAvatar;
	private static JLabel playerAvatarLbl = new JLabel();
	private static JLabel computerAvatarLbl = new JLabel();
	private static JLabel playerNameLbl = new JLabel();
	private static JLabel computerNameLbl = new JLabel(textManage.getPlayerName(3));
	
	
	/**
	 * 
	 * 
	 */
	public MenuButtons(JPanel mainPanel) {
		initialButtonsState();
		setProportion();
		setGraphics();
		addToPanels(mainPanel);
		createAvatarGrid(mainPanel);
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				startBtn.setVisible(false);
				optionBtn.setVisible(false);
				exitBtn.setVisible(false);
				backToMenuBtn.setVisible(true);
				nicknameBtn.setVisible(true);
			}
		});
		
		optionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				optionState();
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				startBtn.setVisible(false);
				optionBtn.setVisible(false);
				exitBtn.setVisible(false);
				extLabel.setVisible(true);
				extNoBtn.setVisible(true);
				extYesBtn.setVisible(true);
			}
		});
		
		backToMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				initialButtonsState();
			}
		});
		
		backToOptBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				optionState();
				
			}
		});
		
		extNoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				initialButtonsState();
			}
		});
		
		extYesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				MainFrame.closeFrame();
			}
		});
		
		langBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				itaBtn.setVisible(true);
				engBtn.setVisible(true);
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
		
		volumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				backToOptBtn.setVisible(true);
				moreVolumeBtn.setVisible(true);
				lessVolumeBtn.setVisible(true);
				volumeLevel.setVisible(true);
			}
		});
		
		lessVolumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				volume = Integer.parseInt(volumeLevel.getText());
				
				if (volume > 0) {
					volume -= 1;
					SoundsManagement.setVolume((float)volume/100, "menuSong");
					volumeLevel.setText(String.valueOf(volume));
				}
				
			}
		});
		
		moreVolumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				volume = Integer.parseInt(volumeLevel.getText());
				if (volume < 99) {
					volume += 1;
					SoundsManagement.setVolume((float)volume/100, "menuSong");
					volumeLevel.setText(String.valueOf(volume));
				}
				
			}
		});
		
		
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				String playerName = selectNickname.getText();

				if (playerName.length() > 0) {
					MainFrame.getTextManage().setPlayerName(1, playerName);
					selectNickname.setEditable(false);
				}
				if (!playerName.equals("")) {
					for (int i = 0; i<6; i++) {
						avatarBtns.get(i).setVisible(true);
					}
				}
				
			}
		});
		
		nicknameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				selectNickname.setEditable(true);
				selectNickname.setVisible(true);
				nicknameBtn.setVisible(false);
				confirmBtn.setVisible(true);
				
			}
		});	
		
		startGameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				SoundsManagement.stop("menuSong");
				SoundsManagement.start("gameSong");
				
				for (int i = 0; i<6; i++) {
					avatarBtns.get(i).setVisible(false);
				}
				
				startGameBtn.setVisible(false);
				selectNickname.setVisible(false);
				nicknameBtn.setVisible(false);
				confirmBtn.setVisible(false);
				confirmBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				
				TextManagement.hideTitle();
				ImagesManagement.getMenuBackground().setVisible(false);
				GameButtons.getGameOptionBtn().setVisible(true);
				GameButtons.getConfirmSetupBtn().setVisible(true);
				textManage.resetText();
				
				Pve.getPositionGrid().setVisible(true);
				Pve.getAttackGrid().setVisible(true);
				for (int i = 0; i<10; i++) {
					Pve.getNavy().getPlayerNavy().get(i).setVisible(true);
				}
				
				oldScroll.setVisible(true);
				MainFrame.getScrollPnl().setVisible(true);

				playerNameLbl.setVisible(true);
				playerNameLbl.setText(selectNickname.getText());
				
				computerNameLbl.setVisible(true);
				computerAvatarLbl.setIcon(avatarList.get(6)); 
				computerAvatarLbl.setVisible(true);

				playerAvatarLbl.setIcon(avatarList.get(chosenAvatar)); 
				playerAvatarLbl.setVisible(true);
				selectNickname.setText(null);
				GameTimer.setTimer();
			}
		});	
		
		itaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				
				optionState();
				setLanguageLocalBtns("it");
				GameButtons.setGameBtnsLanguage("it");
			}
		});
		
		engBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				
				optionState();
				setLanguageLocalBtns("en");
				GameButtons.setGameBtnsLanguage("en");
			}
		});
	}
	
	
	/**
	 * 
	 * 
	 */
	private void initialButtonsState() {
		startBtn.setVisible(true);
		optionBtn.setVisible(true);
		exitBtn.setVisible(true);
		backToMenuBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		langBtn.setVisible(false);
		volumeBtn.setVisible(false);
		moreVolumeBtn.setVisible(false);
		lessVolumeBtn.setVisible(false);
		volumeLevel.setVisible(false);
		extYesBtn.setVisible(false);
		extNoBtn.setVisible(false);
		extLabel.setVisible(false);
		startGameBtn.setVisible(false);
		confirmBtn.setVisible(false);
		nicknameBtn.setVisible(false);
		selectNickname.setVisible(false);
		itaBtn.setVisible(false);
		engBtn.setVisible(false);
		playerAvatarLbl.setVisible(false);
		playerNameLbl.setVisible(false);
		computerAvatarLbl.setVisible(false);
		computerNameLbl.setVisible(false);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void optionState() {
		startBtn.setVisible(false);
		optionBtn.setVisible(false);
		exitBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		volumeLevel.setVisible(false);
		moreVolumeBtn.setVisible(false);
		lessVolumeBtn.setVisible(false);
		backToMenuBtn.setVisible(true);
		langBtn.setVisible(true);
		volumeBtn.setVisible(true);
		engBtn.setVisible(false);
		itaBtn.setVisible(false);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setProportion() {
		startBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		optionBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		exitBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		backToMenuBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		backToOptBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		langBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		volumeBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		extYesBtn.setBounds(yesBtnX, yesBtnY, yesBtnW, buttonH);
		extNoBtn.setBounds(noBtnX, yesBtnY, yesBtnW, buttonH);
		extLabel.setBounds(extLabelX, extLabelY, extLabelW, buttonH);
		nicknameBtn.setBounds(pveMenuX, nicknameBtnY, pveMenuW, buttonH);
		confirmBtn.setBounds(pveMenuX, confirmBtnY, confirmBtnW, buttonH);
		startGameBtn.setBounds(pveMenuX, startGameBtnY, pveMenuW, buttonH);
		selectNickname.setBounds(selectNickX, nicknameBtnY, selectNickW, buttonH);
		lessVolumeBtn.setBounds(lessVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
		volumeLevel.setBounds(volumeLevelX, volumeBtnsY, volumeLevelW, buttonH);
		moreVolumeBtn.setBounds(moreVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
		itaBtn.setBounds(buttonX, itaBtnY, buttonW, buttonH);
		engBtn.setBounds(buttonX, engBtnY, buttonW, buttonH);
		playerAvatarLbl.setBounds(0, 0, avatarSide, avatarSide);
		playerNameLbl.setBounds(avatarSide, inGameNameY, extLabelW, buttonH);
		computerAvatarLbl.setBounds(MainFrame.WIDTH - avatarSide, 0, avatarSide, avatarSide);
		computerNameLbl.setBounds(MainFrame.WIDTH - avatarSide - extLabelW/2 + 50, inGameNameY, extLabelW, buttonH);
	}

	
	/**
	 * 
	 * 
	 */
	private void setFont() {
		startBtn.setFont(font);		
		optionBtn.setFont(font);
		exitBtn.setFont(font);
		backToMenuBtn.setFont(font);
		backToOptBtn.setFont(font);
		langBtn.setFont(font);
		volumeBtn.setFont(font);
		volumeLevel.setFont(font);
		moreVolumeBtn.setFont(font);
		lessVolumeBtn.setFont(font);
		extYesBtn.setFont(font);
		extNoBtn.setFont(font);
		extLabel.setFont(font);
		startGameBtn.setFont(font);
		confirmBtn.setFont(font);
		nicknameBtn.setFont(font);
		selectNickname.setFont(font);
		itaBtn.setFont(font);
		engBtn.setFont(font);
		playerNameLbl.setFont(font);
		computerNameLbl.setFont(font);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setGraphics() {
		setFont();
		selectNickname.setOpaque(false);
		selectNickname.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		volumeLevel.setOpaque(false);
		setTrasparent(startBtn);
		setTrasparent(optionBtn);
		setTrasparent(exitBtn);
		setTrasparent(extYesBtn);
		setTrasparent(extNoBtn);
		setTrasparent(backToMenuBtn);
		setTrasparent(backToOptBtn);
		setTrasparent(volumeBtn);
		setTrasparent(moreVolumeBtn);
		setTrasparent(lessVolumeBtn);
		setTrasparent(langBtn);
		setTrasparent(startGameBtn);
		setTrasparent(confirmBtn);
		setTrasparent(nicknameBtn);
		setTrasparent(engBtn);
		setTrasparent(itaBtn);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void addToPanels(JPanel mainPanel) {
		mainPanel.add(startBtn);
		mainPanel.add(optionBtn);
		mainPanel.add(exitBtn);
		mainPanel.add(backToMenuBtn);
		mainPanel.add(backToOptBtn);
		mainPanel.add(volumeBtn);
		mainPanel.add(moreVolumeBtn);
		mainPanel.add(lessVolumeBtn);
		mainPanel.add(volumeLevel);
		mainPanel.add(langBtn);
		mainPanel.add(startGameBtn);
		mainPanel.add(confirmBtn);
		mainPanel.add(nicknameBtn);
		mainPanel.add(selectNickname);
		mainPanel.add(itaBtn);
		mainPanel.add(engBtn);
		mainPanel.add(extLabel);
		mainPanel.add(extNoBtn);
		mainPanel.add(extYesBtn);
		mainPanel.add(playerAvatarLbl);
		mainPanel.add(playerNameLbl);
		mainPanel.add(computerAvatarLbl);
		mainPanel.add(computerNameLbl);
	}
	
	
	/**
	 * 
	 * 
	 */
	private void createAvatarGrid(JPanel mainPanel) {
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.blueShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.orangeShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.whiteShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.greyShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.armyShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.warShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.submarine"), avatarList);

		createAvatarBtnList(mainPanel);
		
		for(int i = 0; i < 6; i++) {
			setAvatarBtn(avatarBtns, i);
		}
		
	}
	
	
	/**
	 * 
	 * 
	 */
	private void createAvatarBtnList(JPanel mainPanel) {
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<3; j++) {
				JButton square;
				square = new JButton("");
				square.setBounds(avatarX + avatarSpacing*j, avatarY + avatarSpacing*i, avatarSide, avatarSide);
				square.setFont(new Font("Arial", Font.BOLD, 12));
				square.setIcon(avatarList.get(j+i*3)); 
				square.setOpaque(false);
				square.setContentAreaFilled(false);
				square.setBorder(null);
				square.setVisible(false);
				square.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SoundsManagement.clickMenuBtn();
					}
				});
				avatarBtns.add(square);
				mainPanel.add(square);
			}
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	private void setAvatarBtn(List<JButton> avatarBtns, int btnNumb) {
		avatarBtns.get(btnNumb).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				
				if (obstacle == true) {
					confirmBtn.setVisible(false);
					startGameBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != btnNumb) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
					chosenAvatar = btnNumb;
					
				}
				else {
					confirmBtn.setVisible(true);
					startGameBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != btnNumb) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
					
				}
			}
		});
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
	private void setLanguageLocalBtns(String kLang) {
		languageBundle  = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag(kLang)) ;
		startBtn.setText(languageBundle.getString("button.start"));
		optionBtn.setText(languageBundle.getString("button.option"));
		exitBtn.setText(languageBundle.getString("button.exit"));
		backToMenuBtn.setText(languageBundle.getString("button.back"));
		backToOptBtn.setText(languageBundle.getString("button.back"));
		langBtn.setText(languageBundle.getString("button.lang"));
		volumeBtn.setText(languageBundle.getString("button.volume"));
		extYesBtn.setText(languageBundle.getString("button.yes"));
		extNoBtn.setText(languageBundle.getString("button.no"));
		startGameBtn.setText(languageBundle.getString("button.startGame"));
		confirmBtn.setText(languageBundle.getString("button.confirm"));
		nicknameBtn.setText(languageBundle.getString("button.nickname"));
		engBtn.setText(languageBundle.getString("button.eng"));
		itaBtn.setText(languageBundle.getString("button.ita"));
		extLabel.setText(languageBundle.getString("label.extLabel"));
	}
	
	
	/**
	 * 
	 *  @see main.gui.GameButtons
	 */
	public static JLabel getPlayerAvatarLbl() {
		return playerAvatarLbl;
	}
	
	
	/**
	 * 
	 *  @see main.gui.GameButtons
	 */
	public static JLabel getSquareLabel() {
		return playerNameLbl;
	}
	
	
	/**
	 * 
	 *  @see main.gui.GameButtons
	 */
	public static JLabel getComputerAvatarLbl() {
		return computerAvatarLbl;
	}
	
	
	/**
	 * 
	 *  @see main.gui.GameButtons
	 */
	public static JLabel getSquareCpuLabel() {
		return computerNameLbl;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void openMenu() {
		startBtn.setVisible(true);
		optionBtn.setVisible(true);
		exitBtn.setVisible(true);
	}
}