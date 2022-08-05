package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assets.Sounds;

public class Buttons extends MenuProportion{
	
	private JButton startBtn = new JButton("START");
	private JButton optionBtn = new JButton("OPTION");
	private JButton exitBtn = new JButton("EXIT");
	private JButton pveBtn = new JButton("PVE");
	private JButton pvpBtn = new JButton("PVP");
	private JButton backBtn = new JButton("BACK");
	private JButton backToOptBtn = new JButton("BACK");
	private JButton backToPveBtn = new JButton("BACK");
	private JButton langBtn = new JButton("LANGUAGE");
	private JButton volumeBtn = new JButton("VOLUME");
	private JButton extYesBtn = new JButton("YES");
	private JButton extNoBtn = new JButton("NO");
	private JLabel extLabel = new JLabel("Do You Want To Leave?");
	
	public Buttons(JPanel menu, JPanel exitPanel, JFrame frame) {
		StartButtons startPveBtn = new StartButtons(menu);
		int panelWidth = exitPanel.getWidth();
		int panelHeight = exitPanel.getHeight();
				
		System.out.println(panelWidth);
		System.out.println(panelHeight);
		System.out.println(fontDim);
		System.out.println(exitPnlFontDim);
		
		Font font = new Font("Segoe Script", Font.BOLD, fontDim);
		Font extPnlFont = new Font("Segoe Script", Font.BOLD, exitPnlFontDim);
		
		
		startBtn.setVisible(true);
		optionBtn.setVisible(true);
		exitBtn.setVisible(true);
		pvpBtn.setVisible(false);
		pveBtn.setVisible(false);
		backBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		langBtn.setVisible(false);
		volumeBtn.setVisible(false);
		extYesBtn.setVisible(false);
		extNoBtn.setVisible(false);
		backToPveBtn.setVisible(false);
		
		startBtn.setFont(font);
		startBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		
		optionBtn.setFont(font);
		optionBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		
		exitBtn.setFont(font);
		exitBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		
		pveBtn.setFont(font);
		pveBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		
		pvpBtn.setFont(font);
		pvpBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		
		backBtn.setFont(font);
		backBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		
		backToOptBtn.setFont(font);
		backToOptBtn.setBounds(buttonX, buttonY, buttonW, buttonH);

		backToPveBtn.setFont(font);
		backToPveBtn.setBounds(buttonX, buttonY, buttonW, buttonH);
		
		langBtn.setFont(font);
		langBtn.setBounds(buttonX, buttonY - buttonH, buttonW, buttonH);
		
		volumeBtn.setFont(font);
		volumeBtn.setBounds(buttonX, buttonY - buttonH * 2, buttonW, buttonH);
		
		extYesBtn.setFont(extPnlFont);
		extYesBtn.setBackground(Color.YELLOW);
		extYesBtn.setBounds(yesBtnX, yesBtnY, yesBtnW, yesBtnH);
		
		extNoBtn.setFont(extPnlFont);
		extNoBtn.setBackground(Color.YELLOW);
		extNoBtn.setBounds(noBtnX, yesBtnY, yesBtnW, yesBtnH);
		
		extLabel.setFont(extPnlFont);
		extLabel.setBounds(extLabelX, extLabelY, extLabelW, extLabelH);
		
		setTrasparent(startBtn);
		setTrasparent(optionBtn);
		setTrasparent(exitBtn);
		setTrasparent(pveBtn);
		setTrasparent(pvpBtn);
		setTrasparent(backBtn);
		setTrasparent(backToOptBtn);
		setTrasparent(volumeBtn);
		setTrasparent(langBtn);
		setTrasparent(backToPveBtn);
		
		menu.add(startBtn);
		menu.add(optionBtn);
		menu.add(exitBtn);
		menu.add(pveBtn);
		menu.add(pvpBtn);
		menu.add(backBtn);
		menu.add(backToOptBtn);
		menu.add(backToPveBtn);
		menu.add(volumeBtn);
		menu.add(langBtn);
		
		exitPanel.add(extLabel);
		exitPanel.add(extNoBtn);
		exitPanel.add(extYesBtn);
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				startBtn.setVisible(false);
				optionBtn.setVisible(false);
				exitBtn.setVisible(false);
				pveBtn.setVisible(true);
				pvpBtn.setVisible(true);
				backBtn.setVisible(true);
			}
		});
		
		optionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				backBtn.setVisible(true);
				langBtn.setVisible(true);
				volumeBtn.setVisible(true);
				optionBtn.setVisible(false);
				startBtn.setVisible(false);
				exitBtn.setVisible(false);				
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				exitPanel.setVisible(true);
				optionBtn.setVisible(false);
				startBtn.setVisible(false);
				exitBtn.setVisible(false);
				extNoBtn.setVisible(true);
				extYesBtn.setVisible(true);
			}
		});
		
		pveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				startPveBtn.srnameBtn.setVisible(true);
				backToPveBtn.setVisible(true);
				pvpBtn.setVisible(false);
				pveBtn.setVisible(false);
				backBtn.setVisible(false);
			}
		});
		
		pvpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				
			}
		});
		
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				backBtn.setVisible(false);
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				pveBtn.setVisible(false);
				pvpBtn.setVisible(false);
				optionBtn.setVisible(true);
				startBtn.setVisible(true);
				exitBtn.setVisible(true);
			}
		});
		
		backToOptBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				backToOptBtn.setVisible(false);
				langBtn.setVisible(true);
				volumeBtn.setVisible(true);
				backBtn.setVisible(true);
			}
		});
		
		backToPveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				startPveBtn.srnameBtn.setVisible(false);
				for (int i = 0; i<6; i++) {
					startPveBtn.avatarBtns.get(i).setVisible(false);
				}
				startPveBtn.confirmBtn.setVisible(false);
				startPveBtn.saveBtn.setVisible(false);
				startPveBtn.txtWrite.setVisible(false);
				startPveBtn.obstacle = true;
				startPveBtn.txtWrite.setText("");
				backToPveBtn.setVisible(false);
				
				pveBtn.setVisible(true);
				pvpBtn.setVisible(true);
				backBtn.setVisible(true);
				
			}
		});
		extNoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();
				exitPanel.setVisible(false);
				optionBtn.setVisible(true);
				startBtn.setVisible(true);
				exitBtn.setVisible(true);
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
				backBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
		
		volumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
	}
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
}

