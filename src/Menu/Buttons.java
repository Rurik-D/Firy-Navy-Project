package Menu;

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

public class Buttons {
	
	private JButton startBtn = new JButton("START");
	private JButton optionBtn = new JButton("OPTION");
	private JButton exitBtn = new JButton("EXIT");
	private JButton pveBtn = new JButton("PVE");
	private JButton pvpBtn = new JButton("PVP");
	private JButton backBtn = new JButton("BACK");
	private JButton backToOptBtn = new JButton("BACK");
	private JButton langBtn = new JButton("LANGUAGE");
	private JButton volumeBtn = new JButton("VOLUME");
	private JButton extYesBtn = new JButton("YES");
	private JButton extNoBtn = new JButton("NO");
	private Font font = new Font("Segoe Script", Font.BOLD, 35);
	
	public Buttons(JPanel menu, JPanel exitPanel, JFrame frame) {
		startBtn.setVisible(true);
		optionBtn.setVisible(true);
		exitBtn.setVisible(true);
		pvpBtn.setVisible(false);
		pveBtn.setVisible(false);
		backBtn.setVisible(false);
		backBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		langBtn.setVisible(false);
		volumeBtn.setVisible(false);
		extYesBtn.setVisible(false);
		extNoBtn.setVisible(false);
		
		startBtn.setFont(font);
		startBtn.setBounds(68, 679-80, 270, 40);
		
		optionBtn.setFont(font);
		optionBtn.setBounds(68, 679-40, 270, 40);
		
		exitBtn.setFont(font);
		exitBtn.setBounds(68, 679, 270, 40);
		
		pveBtn.setFont(font);
		pveBtn.setBounds(68, 679-80, 270, 40);
		
		pvpBtn.setFont(font);
		pvpBtn.setBounds(68, 679-40, 270, 40);
		
		backBtn.setFont(font);
		backBtn.setBounds(68, 679, 270, 40);
		
		backToOptBtn.setFont(font);
		backToOptBtn.setBounds(68, 679, 270, 40);

		langBtn.setFont(font);
		langBtn.setBounds(68, 679-40, 270, 40);
		
		volumeBtn.setFont(font);
		volumeBtn.setBounds(68, 679-80, 270, 40);
		
		extYesBtn.setFont(new Font("Segoe Script", Font.BOLD, 25));
		extYesBtn.setBackground(Color.YELLOW);
		extYesBtn.setBounds(41, 127, 93, 63);
		
		extNoBtn.setFont(new Font("Segoe Script", Font.BOLD, 25));
		extNoBtn.setBackground(Color.YELLOW);
		extNoBtn.setBounds(332, 127, 93, 63);
		
		setTrasparent(startBtn);
		setTrasparent(optionBtn);
		setTrasparent(exitBtn);
		setTrasparent(pveBtn);
		setTrasparent(pvpBtn);
		setTrasparent(backBtn);
		setTrasparent(backToOptBtn);
		setTrasparent(volumeBtn);
		setTrasparent(langBtn);
		
		menu.add(startBtn);
		menu.add(optionBtn);
		menu.add(exitBtn);
		menu.add(pveBtn);
		menu.add(pvpBtn);
		menu.add(backBtn);
		menu.add(backToOptBtn);
		menu.add(volumeBtn);
		menu.add(langBtn);
		
		JLabel extLabel = new JLabel("Do You Want To Leave?");
		extLabel.setFont(new Font("Segoe Script", Font.BOLD, 25));
		extLabel.setBounds(100, 0, 2700, 100);
		
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

