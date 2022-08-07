package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Assets.Background;
import Assets.Sounds;
import Util.FrameProportion;

public class Buttons extends FrameProportion{
	
	private JButton startBtn = new JButton("START");
	private JButton optionBtn = new JButton("OPTION");
	private JButton exitBtn = new JButton("EXIT");
	private JButton pveBtn = new JButton("PVE");
	private JButton pvpBtn = new JButton("PVP");
	private JButton backToMenuBtn = new JButton("BACK");
	private JButton backToOptBtn = new JButton("BACK");
	private JButton backToStartBtn = new JButton("BACK");
	private JButton langBtn = new JButton("LANGUAGE");
	private JButton volumeBtn = new JButton("VOLUME");
	private JButton extYesBtn = new JButton("YES");
	private JButton extNoBtn = new JButton("NO");
	private JButton startGameBtn = new JButton("START");
	private JButton confirmBtn = new JButton("CONFIRM");
	private JButton srnameBtn = new JButton("NICKNAME");
	private JButton moreVolumeBtn = new JButton("+");
	private JButton lessVolumeBtn = new JButton("-");
	private JTextField selectNickname = new JTextField();
	private JLabel volumeLevel = new JLabel("50");
	private JLabel extLabel = new JLabel("Do You Want To Leave?");
	private List<JButton> avatarBtns = new ArrayList<>();
	private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private boolean obstacle = true;
	private int volume;


	public Buttons(JPanel menu, JFrame frame) {


		initialButtonsState();
		setProportion();
		setGraphics();
		addToPanels(menu);
		createAvatarGrid(menu);		// PARTE DI LELLO //
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
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
				Sounds.clickMenuBtn();
				optionState();
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
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
				Sounds.clickMenuBtn();
				pvpBtn.setVisible(false);
				pveBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				srnameBtn.setVisible(true);
				backToStartBtn.setVisible(true);
			}
		});
		
		pvpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				pvpBtn.setVisible(false);
				pveBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				srnameBtn.setVisible(true);
				backToStartBtn.setVisible(true);
				
			}
		});
		
		backToMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				initialButtonsState();
			}
		});
		
		backToOptBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				optionState();
			}
		});
		
		backToStartBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				for (int i = 0; i<6; i++) {
					avatarBtns.get(i).setVisible(false);
				}
				srnameBtn.setVisible(false);
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
				Sounds.clickMenuBtn();
				initialButtonsState();
			}
		});
		
		extYesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		langBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backToMenuBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
		
		volumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
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
				Sounds.clickMenuBtn();
				volume = Integer.parseInt(volumeLevel.getText());
				
				if (volume > 0) {
					volume -= 1;
					Sounds.setVolume((float)volume/100);
					volumeLevel.setText(String.valueOf(volume));
				}
				
			}
		});
		
		moreVolumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				volume = Integer.parseInt(volumeLevel.getText());
				if (volume < 99) {
					volume += 1;
					Sounds.setVolume((float)volume/100);
					volumeLevel.setText(String.valueOf(volume));
				}
				
			}
		});
		
		
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				String testo = selectNickname.getText();
				if (!testo.equals("")) {
					
					for (int i = 0; i<6; i++) {
						avatarBtns.get(i).setVisible(true);
					}
				
				}
			}
		});
		
		srnameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				selectNickname.setVisible(true);
				srnameBtn.setVisible(false);
				confirmBtn.setVisible(true);
				
			}
		});	
		
		startGameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				for (int i = 0; i<6; i++) {
					avatarBtns.get(i).setVisible(false);
				}
				startGameBtn.setVisible(false);
				selectNickname.setVisible(false);
				srnameBtn.setVisible(false);
				confirmBtn.setVisible(false);
				confirmBtn.setVisible(false);
				backToStartBtn.setVisible(false);
				Background.getMenuBackground().setVisible(false);
				Background.hideTitle();
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
		srnameBtn.setVisible(false);
		selectNickname.setVisible(false);
		
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
		srnameBtn.setBounds(pveMenuX, srnameBtnY, pveMenuW, buttonH);
		confirmBtn.setBounds(pveMenuX, confirmBtnY, pveMenuW, buttonH);
		startGameBtn.setBounds(pveMenuX, startGameBtnY, pveMenuW, buttonH);
		selectNickname.setBounds(selectNickX, srnameBtnY, selectNickW, buttonH);
		lessVolumeBtn.setBounds(lessVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
		volumeLevel.setBounds(volumeLevelX, volumeBtnsY, volumeLevelW, buttonH);
		moreVolumeBtn.setBounds(moreVolumeBtnX, volumeBtnsY, lessVolumeBtnW, buttonH);
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
		srnameBtn.setFont(font);
		selectNickname.setFont(font);

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
		setTrasparent(srnameBtn);
		
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
		menu.add(srnameBtn);
		menu.add(selectNickname);
		
		menu.add(extLabel);
		menu.add(extNoBtn);
		menu.add(extYesBtn);
		
	}
	
	private void createAvatarGrid(JPanel menu) {
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
				box.setText("A" + (j+i*3));
				//box.setIcon(avatars.get(j+i*3)); // PARTE DI LELLO (lista di icone)// 
				box.setOpaque(false);
				box.setContentAreaFilled(false);
				box.setVisible(false);
				box.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.print(box.getName() + " ");
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
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					confirmBtn.setVisible(false);
					startGameBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != btnNumb) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
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
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
}

