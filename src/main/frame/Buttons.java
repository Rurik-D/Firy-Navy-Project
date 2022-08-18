package main.frame;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import resources.*;
import utils.FrameProportion;
import utils.UtilsProperties;

import java.util.Locale;
import java.util.ResourceBundle;

public class Buttons extends FrameProportion{
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/setLanguage", Locale.forLanguageTag("en"));
	private ResourceBundle imagesBundle = ResourceBundle.getBundle("utils.file/setImagesManagement", Locale.forLanguageTag("img"));
	//imagesBundle.getString("image.warShip")
	private JButton startBtn = new JButton(resourceBundle.getString("button.startBtn"));
	private JButton optionBtn = new JButton(resourceBundle.getString("button.optionBtn"));
	private JButton exitBtn = new JButton(resourceBundle.getString("button.exitBtn"));
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
	private JLabel extLabel = new JLabel(resourceBundle.getString("label.extLabel"));
	private JButton moreVolumeBtn = new JButton("+");
	private JButton lessVolumeBtn = new JButton("-");
	private JTextField selectNickname = new JTextField();
	private JLabel volumeLevel = new JLabel("50");
	
	private List<JButton> avatarBtns = new ArrayList<>();
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private boolean obstacle = true;
	private int volume;
//	private static Image image;
//	private static JButton profile;
	private static List<ImageIcon> avatarList = new ArrayList();
	private JButton chooseBtn = new JButton();
	
	
	public Buttons(JPanel menu, JFrame frame) {


		initialButtonsState();
		setProportion();
		setGraphics();
		addToPanels(menu);
		createAvatarGrid(menu);		// PARTE DI LELLO //
		
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
				//exitPanel.setVisible(true);
				extLabel.setVisible(true);
				extNoBtn.setVisible(true);
				extYesBtn.setVisible(true);
			}
		});
		
		pveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
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
				frame.setVisible(false);
				frame.dispose();
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
					SoundsManagement.setVolume((float)volume/100);
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
					SoundsManagement.setVolume((float)volume/100);
					volumeLevel.setText(String.valueOf(volume));
				}
				
			}
		});
		
		
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				String testo = selectNickname.getText();
				if (testo.length() > 0) {
					selectNickname.setEditable(false);
				}
				if (!testo.equals("")) {
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
			}
		});	
		
		itaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				
				optionState();
				setLanguageLocalBtns("it");
			}
		});
		
		engBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoundsManagement.clickMenuBtn();
				
				optionState();
				setLanguageLocalBtns("en");
			}
		});
		
	}

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
		
	}
	
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
	}

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

	}
	
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
	
	
	
	private void addToPanels(JPanel menu) {
		menu.add(startBtn);
		menu.add(optionBtn);
		menu.add(exitBtn);
		menu.add(pveBtn);
		menu.add(pvpBtn);
		menu.add(backToMenuBtn);
		menu.add(backToOptBtn);
		menu.add(backToStartBtn);
		menu.add(volumeBtn);
		menu.add(moreVolumeBtn);
		menu.add(lessVolumeBtn);
		menu.add(volumeLevel);
		menu.add(langBtn);
		menu.add(startGameBtn);
		menu.add(confirmBtn);
		menu.add(nicknameBtn);
		menu.add(selectNickname);
		menu.add(itaBtn);
		menu.add(engBtn);
		menu.add(extLabel);
		menu.add(extNoBtn);
		menu.add(extYesBtn);
		
	}
	
	private void createAvatarGrid(JPanel menu) {
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.blueShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.orangeShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.whiteShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.greyShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.armyShip"),avatarList);
		ImagesManagement.createAvatarPicture(imagesBundle.getString("image.warShip"),avatarList);


		
		createAvatarBtnList(menu);		// PARTE DI LELLO (lista di icone)//
		setAvatarBtn(avatarBtns, 0);
		setAvatarBtn(avatarBtns, 1);
		setAvatarBtn(avatarBtns, 2);
		setAvatarBtn(avatarBtns, 3);
		setAvatarBtn(avatarBtns, 4);
		setAvatarBtn(avatarBtns, 5);
		
	}
	
	private void createAvatarBtnList(JPanel menu) {
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<3; j++) {
				JButton box;
				box = new JButton("");
				//box.setBounds(112 + 63*j, 288 + 63*i, 60, 60);	// valori relativi a 1536 * 864
				box.setBounds(avatarX + avatarSpacing*j, avatarY + avatarSpacing*i, avatarSide, avatarSide);
				box.setFont(new Font("Arial", Font.BOLD, 12));
				//box.setText("A" + (j+i*3));
				box.setIcon(avatarList.get(j+i*3));//(avatars.get(j+i*3)); // PARTE DI LELLO (lista di icone)// 
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setBorder(null);
				box.setVisible(false);
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SoundsManagement.clickMenuBtn();
					}
				});
				avatarBtns.add(box);
				menu.add(box);
			}
		}
	}
	
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
					chooseBtn = avatarBtns.get(btnNumb);
				}
				else {
					confirmBtn.setVisible(true);
					startGameBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != btnNumb) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
					chooseBtn = new JButton();
				}
			}
		});
	}
	
//	private void createAvatarPicture(String file_img) {
//		BufferedImage img = null;
//		try {
//		    img = ImageIO.read(new File(file_img));
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}
//		image = img.getScaledInstance(avatarSide, avatarSide,Image.SCALE_SMOOTH);
//		ImageIcon imageIcon = new ImageIcon(image);
//		
////		profile = new JButton(imageIcon);
////		profile.setBounds(0, 0, Menu.WIDTH, Menu.HEIGHT);
//		avatarList.add(imageIcon);
//		
//	}
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}

	public void setLanguageLocalBtns(String kLang) {
		resourceBundle  = ResourceBundle.getBundle("utils.file/setLanguage", Locale.forLanguageTag(kLang)) ;
		
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

}

