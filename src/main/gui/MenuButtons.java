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
import javax.swing.Timer;

import java.util.Locale;
import java.util.ResourceBundle;

import resources.*;
import utils.*;
import main.core.Main;
import main.core.Pve;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class MenuButtons extends FrameProportion{
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag("en"));
	private static ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/images");
	private static JButton startBtn = new JButton(resourceBundle.getString("button.startBtn"));
	private static JButton optionBtn = new JButton(resourceBundle.getString("button.optionBtn"));
	private static JButton exitBtn = new JButton(resourceBundle.getString("button.exitBtn"));
	private JButton pveBtn = new JButton(resourceBundle.getString("button.pveBtn"));
	private JButton pvpBtn = new JButton(resourceBundle.getString("button.pvpBtn"));
	private JButton backToMenuBtn = new JButton(resourceBundle.getString("button.backToMenuBtn"));
	private JButton backToOptBtn = new JButton(resourceBundle.getString("button.backToOptBtn"));
	private JButton backToStartBtn = new JButton(resourceBundle.getString("button.backToStartBtn"));
	private JButton langBtn = new JButton(resourceBundle.getString("button.langBtn"));
	private JButton volumeBtn = new JButton(resourceBundle.getString("button.volumeBtn"));
	private JButton extYesBtn = new JButton(resourceBundle.getString("button.extYesBtn"));
	private JButton extNoBtn = new JButton(resourceBundle.getString("button.extNoBtn"));
	private JButton startGameBtn = new JButton(resourceBundle.getString("button.startGameBtn"));
	private JButton confirmBtn = new JButton(resourceBundle.getString("button.confirmBtn"));
	private JButton nicknameBtn = new JButton(resourceBundle.getString("button.nicknameBtn"));
	private JButton itaBtn = new JButton(resourceBundle.getString("button.itaBtn"));
	private JButton engBtn = new JButton(resourceBundle.getString("button.engBtn"));
	private JButton moreVolumeBtn = new JButton("+");
	private JButton lessVolumeBtn = new JButton("-");
	private JLabel extLabel = new JLabel(resourceBundle.getString("label.extLabel"));
	private JLabel volumeLevel = new JLabel("50");
	private JLabel oldScroll = ImagesManagement.getOldScroll();
	private JTextField selectNickname = new JTextField();
	
	private List<JButton> avatarBtns = new ArrayList<>();
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private boolean obstacle = true;
	private int volume;
	private static List<ImageIcon> avatarList = new ArrayList<>();
	private static int chooseBtn;
	private static JButton squareBtn = new JButton("");
	private static JButton squareCpuBtn = new JButton("");
	private static JLabel squareLabel = new JLabel();
	private static JLabel squareCpuLabel = new JLabel(resourceBundle.getString("label.squareCpuLabel"));
	private static TextManagement textManage = MainFrame.getTextManage();
	
	
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
				pveBtn.setVisible(true);
				pvpBtn.setVisible(true);
				backToMenuBtn.setVisible(true);
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
		
		pveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				MainFrame.getTextManage().setPlayerName(2, "Computer");
				pvpBtn.setVisible(false);
				pveBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				nicknameBtn.setVisible(true);
				backToStartBtn.setVisible(true);
			}
		});
		
		pvpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				pvpBtn.setVisible(false);
				pveBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				nicknameBtn.setVisible(true);
				backToStartBtn.setVisible(true);
				
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
		
		backToStartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				for (int i = 0; i<6; i++) {
					avatarBtns.get(i).setVisible(false);
				}
				nicknameBtn.setVisible(false);
				confirmBtn.setVisible(false);
				startGameBtn.setVisible(false);
				selectNickname.setVisible(false);
				obstacle = true;
				selectNickname.setText("");
				backToStartBtn.setVisible(false);
				
				pveBtn.setVisible(true);
				pvpBtn.setVisible(true);
				backToMenuBtn.setVisible(true);
				
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
				String text = selectNickname.getText();

				if (text.length() > 0) {
					MainFrame.getTextManage().setPlayerName(1, text);
					selectNickname.setEditable(false);
				}
				if (!text.equals("")) {
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
				backToStartBtn.setVisible(false);
				
				ImagesManagement.getMenuBackground().setVisible(false);
				ImagesManagement.hideTitle();
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

				squareLabel.setVisible(true);
				String testo = selectNickname.getText();
				squareLabel.setText(testo);
				
				squareCpuLabel.setVisible(true);
				squareCpuBtn.setIcon(avatarList.get(6)); 
				buttonsSetUp(squareCpuBtn);

				squareBtn.setIcon(avatarList.get(chooseBtn)); 
				buttonsSetUp(squareBtn);
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
		pvpBtn.setVisible(false);
		pveBtn.setVisible(false);
		backToMenuBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		backToStartBtn.setVisible(false);
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
		squareBtn.setVisible(false);
		squareLabel.setVisible(false);
		squareCpuBtn.setVisible(false);
		squareCpuLabel.setVisible(false);
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
		pveBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		pvpBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		backToMenuBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		backToOptBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		backToStartBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		langBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		volumeBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		extYesBtn.setBounds(yesBtnX, yesBtnY, yesBtnW, buttonH);
		extNoBtn.setBounds(noBtnX, yesBtnY, yesBtnW, buttonH);
		extLabel.setBounds(extLabelX, extLabelY, extLabelW, buttonH);
		nicknameBtn.setBounds(pveMenuX, nicknameBtnY, pveMenuW, buttonH);
		confirmBtn.setBounds(pveMenuX, confirmBtnY, pveMenuW, buttonH);
		startGameBtn.setBounds(pveMenuX, startGameBtnY, pveMenuW, buttonH);
		selectNickname.setBounds(selectNickX, nicknameBtnY, selectNickW, buttonH);
		lessVolumeBtn.setBounds(lessVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
		volumeLevel.setBounds(volumeLevelX, volumeBtnsY, volumeLevelW, buttonH);
		moreVolumeBtn.setBounds(moreVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
		itaBtn.setBounds(buttonX, 590, buttonW, buttonH);
		engBtn.setBounds(buttonX, 630, buttonW, buttonH);
		squareBtn.setBounds(0, 0, avatarSide, avatarSide);
		squareLabel.setBounds(avatarSide,10, extLabelW, buttonH);
		squareCpuBtn.setBounds(Main.WIDTH - avatarSide, 0, avatarSide, avatarSide);
		squareCpuLabel.setBounds(Main.WIDTH - avatarSide-extLabelW/2 + 50, 10, extLabelW, buttonH);
	}

	
	/**
	 * 
	 * 
	 */
	private void setFont() {
		startBtn.setFont(font);		
		optionBtn.setFont(font);
		exitBtn.setFont(font);
		pveBtn.setFont(font);
		pvpBtn.setFont(font);
		backToMenuBtn.setFont(font);
		backToOptBtn.setFont(font);
		backToStartBtn.setFont(font);
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
		squareLabel.setFont(font);
		squareCpuLabel.setFont(font);
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
		setTrasparent(pveBtn);
		setTrasparent(pvpBtn);
		setTrasparent(backToMenuBtn);
		setTrasparent(backToOptBtn);
		setTrasparent(volumeBtn);
		setTrasparent(moreVolumeBtn);
		setTrasparent(lessVolumeBtn);
		setTrasparent(langBtn);
		setTrasparent(backToStartBtn);
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
		mainPanel.add(pveBtn);
		mainPanel.add(pvpBtn);
		mainPanel.add(backToMenuBtn);
		mainPanel.add(backToOptBtn);
		mainPanel.add(backToStartBtn);
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
		mainPanel.add(squareBtn);
		mainPanel.add(squareLabel);
		mainPanel.add(squareCpuBtn);
		mainPanel.add(squareCpuLabel);
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
		setAvatarBtn(avatarBtns, 0);
		setAvatarBtn(avatarBtns, 1);
		setAvatarBtn(avatarBtns, 2);
		setAvatarBtn(avatarBtns, 3);
		setAvatarBtn(avatarBtns, 4);
		setAvatarBtn(avatarBtns, 5);
		
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
					chooseBtn = btnNumb;
					
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
	public void setLanguageLocalBtns(String kLang) {
		resourceBundle  = ResourceBundle.getBundle("utils.file/lang", Locale.forLanguageTag(kLang)) ;
		startBtn.setText(resourceBundle.getString("button.startBtn"));
		optionBtn.setText(resourceBundle.getString("button.optionBtn"));
		exitBtn.setText(resourceBundle.getString("button.exitBtn"));
		pveBtn.setText(resourceBundle.getString("button.pveBtn"));
		pvpBtn.setText(resourceBundle.getString("button.pvpBtn"));
		backToMenuBtn.setText(resourceBundle.getString("button.backToMenuBtn"));
		backToOptBtn.setText(resourceBundle.getString("button.backToOptBtn"));
		backToStartBtn.setText(resourceBundle.getString("button.backToStartBtn"));
		langBtn.setText(resourceBundle.getString("button.langBtn"));
		volumeBtn.setText(resourceBundle.getString("button.volumeBtn"));
		extYesBtn.setText(resourceBundle.getString("button.extYesBtn"));
		extNoBtn.setText(resourceBundle.getString("button.extNoBtn"));
		startGameBtn.setText(resourceBundle.getString("button.startGameBtn"));
		confirmBtn.setText(resourceBundle.getString("button.confirmBtn"));
		nicknameBtn.setText(resourceBundle.getString("button.nicknameBtn"));
		engBtn.setText(resourceBundle.getString("button.engBtn"));
		itaBtn.setText(resourceBundle.getString("button.itaBtn"));
		extLabel.setText(resourceBundle.getString("label.extLabel"));
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JButton getSquareBtn() {
		return squareBtn;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JLabel getSquareLabel() {
		return squareLabel;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JButton getSquareCpuBtn() {
		return squareCpuBtn;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static JLabel getSquareCpuLabel() {
		return squareCpuLabel;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void buttonsSetUp(JButton btn) {
		btn.setFont(new Font("Arial", Font.BOLD, 12));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorder(null);
		btn.setVisible(true);
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