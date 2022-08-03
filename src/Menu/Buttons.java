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

public class Buttons {
	
	private JPanel menu;
	private JPanel exitPanel;
	private JButton startBtn = new JButton("START");
	private JButton optionBtn = new JButton("OPTION");
	private JButton exitBtn = new JButton("EXIT");
	private JButton backBtn = new JButton("BACK");
	private JButton backToOptBtn = new JButton("BACK");
	private JButton langBtn = new JButton("LANGUAGE");
	private JButton volumeBtn = new JButton("VOLUME");
	private JButton extYesBtn = new JButton("YES");
	private JButton extNoBtn = new JButton("NO");
	
	public Buttons(JPanel menu, JPanel exitPanel, JFrame frame) {
		startBtn.setVisible(true);
		optionBtn.setVisible(true);
		exitBtn.setVisible(true);
		backBtn.setVisible(false);
		backToOptBtn.setVisible(false);
		langBtn.setVisible(false);
		volumeBtn.setVisible(false);
		extYesBtn.setVisible(false);
		extNoBtn.setVisible(false);
		
		exitPanel.setLayout(null);
		exitPanel.setVisible(false);
		
		exitPanel.setBackground(Color.ORANGE);
		exitPanel.setBounds(1536/2-250, 864/2-100, 500, 200);
		
		
		startBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		startBtn.setBounds(68, 679-60, 218, 21);
		
		optionBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		optionBtn.setBounds(68, 679-30, 218, 21);

		langBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		langBtn.setBounds(68, 679-30, 218, 21);
		
		volumeBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		volumeBtn.setBounds(68, 679-60, 218, 21);

		exitBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		exitBtn.setBounds(68, 679, 218, 21);
		
		backBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		backBtn.setBounds(68, 679, 218, 21);
		
		backToOptBtn.setFont(new Font("Segoe Script", Font.BOLD, 15));
		backToOptBtn.setBounds(68, 679, 218, 21);

		extYesBtn.setBackground(Color.YELLOW);
		extYesBtn.setLocation(41, 127);
		
		extNoBtn.setBackground(Color.YELLOW);
		extNoBtn.setLocation(332, 127);
		
		extNoBtn.setSize(93, 63);
		extYesBtn.setSize(93, 63);
		
		
		menu.add(startBtn);
		menu.add(exitBtn);
		menu.add(optionBtn);
		menu.add(backBtn);
		menu.add(backToOptBtn);
		menu.add(volumeBtn);
		menu.add(langBtn);
		
		JLabel extLabel = new JLabel("Do You Wanna Leave?");
		extLabel.setFont(new Font("Georgia Pro Cond Black", Font.BOLD, 15));
		extLabel.setLocation(144, 0);
		extLabel.setSize(178, 100);
		
		exitPanel.add(extLabel);
		exitPanel.add(extNoBtn);
		exitPanel.add(extYesBtn);
		
		
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		optionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				exitPanel.setVisible(true);
				optionBtn.setVisible(false);
				startBtn.setVisible(false);
				exitBtn.setVisible(false);
				extNoBtn.setVisible(true);
				extYesBtn.setVisible(true);
			}
		});
		
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backBtn.setVisible(false);
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				optionBtn.setVisible(true);
				startBtn.setVisible(true);
				exitBtn.setVisible(true);
			}
		});
		
		backToOptBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				backToOptBtn.setVisible(false);
				langBtn.setVisible(true);
				volumeBtn.setVisible(true);
				backBtn.setVisible(true);
			}
		});
		
		extNoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitPanel.setVisible(false);
				optionBtn.setVisible(true);
				startBtn.setVisible(true);
				exitBtn.setVisible(true);
			}
		});
		
		extYesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		langBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
		
		volumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				langBtn.setVisible(false);
				volumeBtn.setVisible(false);
				backBtn.setVisible(false);
				backToOptBtn.setVisible(true);
			}
		});
		
		
}}
