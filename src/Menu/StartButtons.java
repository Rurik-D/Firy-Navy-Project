package Menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Assets.Sounds;

public class StartButtons {
	
	//private JFrame frame;
	//private JButton pveBtn = new JButton();
	private Font font = new Font("Segoe Script", Font.BOLD, 15);
	
	public boolean obstacle = true;
	public JTextField txtWrite;
	public JButton saveBtn = new JButton("START");
	public JButton avatarBtn1 = new JButton("A1");
	public JButton avatarBtn2 = new JButton("A2");
	public JButton avatarBtn3 = new JButton("A3");
	public JButton avatarBtn4 = new JButton("A4");
	public JButton avatarBtn5 = new JButton("A5");
	public JButton avatarBtn6 = new JButton("A6");
	public JButton confirmBtn = new JButton("CONFIRM");
	public JButton srnameBtn = new JButton("SURNAME");

	
	
	public StartButtons( JPanel menu) {
		
		
		txtWrite = new JTextField();
		txtWrite.setColumns(10);

		
		saveBtn.setVisible(false);
		avatarBtn1.setVisible(false);
		avatarBtn2.setVisible(false);
		avatarBtn3.setVisible(false);
		avatarBtn4.setVisible(false);
		avatarBtn5.setVisible(false);	
		avatarBtn6.setVisible(false);
		confirmBtn.setVisible(false);
		srnameBtn.setVisible(false);
		txtWrite.setVisible(false);

		
		saveBtn.setBounds(131, 583, 96, 21);
		avatarBtn1.setBounds(68, 288, 62, 47);
		avatarBtn2.setBounds(147, 288, 62, 47);
		avatarBtn3.setBounds(224, 288, 62, 47);
		avatarBtn4.setBounds(68, 366, 62, 47);
		avatarBtn5.setBounds(147, 366, 62, 47);
		avatarBtn6.setBounds(224, 366, 62, 47);
		confirmBtn.setBounds(69, 190, 218, 21);
		srnameBtn.setBounds(69, 190, 218, 21);
		txtWrite.setBounds(131, 221, 96, 19);
		
	
		saveBtn.setFont(font);
		confirmBtn.setFont(font);
		srnameBtn.setFont(font);

		menu.add(saveBtn);
		menu.add(avatarBtn1);
		menu.add(avatarBtn2);
		menu.add(avatarBtn3);
		menu.add(avatarBtn4);
		menu.add(avatarBtn5);
		menu.add(avatarBtn6);
		menu.add(confirmBtn);
		menu.add(srnameBtn);
		menu.add(txtWrite);
		
		setTrasparent(saveBtn);
		setTrasparent(confirmBtn);
		setTrasparent(srnameBtn);
		
		
		avatarBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(false);
					avatarBtn3.setVisible(false);
					avatarBtn4.setVisible(false);
					avatarBtn5.setVisible(false);
					avatarBtn6.setVisible(false);

					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					avatarBtn2.setVisible(true);
					avatarBtn3.setVisible(true);
					avatarBtn4.setVisible(true);
					avatarBtn5.setVisible(true);
					avatarBtn6.setVisible(true);
					obstacle = true;
				}
			}
		});
		
		
		
		avatarBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn1.setVisible(false);
					avatarBtn3.setVisible(false);
					avatarBtn4.setVisible(false);
					avatarBtn5.setVisible(false);
					avatarBtn6.setVisible(false);
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					avatarBtn1.setVisible(true);
					avatarBtn3.setVisible(true);
					avatarBtn4.setVisible(true);
					avatarBtn5.setVisible(true);
					avatarBtn6.setVisible(true);
					obstacle = true;
				}
			}
		});

		avatarBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(false);
					avatarBtn1.setVisible(false);
					avatarBtn4.setVisible(false);
					avatarBtn5.setVisible(false);
					avatarBtn6.setVisible(false);
					obstacle = false;
				}
				else {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(true);
					avatarBtn1.setVisible(true);
					avatarBtn4.setVisible(true);
					avatarBtn5.setVisible(true);
					avatarBtn6.setVisible(true);
					obstacle = true;
				}
			}
		});
	
		avatarBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(false);
					avatarBtn3.setVisible(false);
					avatarBtn1.setVisible(false);
					avatarBtn5.setVisible(false);
					avatarBtn6.setVisible(false);
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					avatarBtn2.setVisible(true);
					avatarBtn3.setVisible(true);
					avatarBtn1.setVisible(true);
					avatarBtn5.setVisible(true);
					avatarBtn6.setVisible(true);
					obstacle = true;
				}
			}
		});
	
		avatarBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(false);
					avatarBtn3.setVisible(false);
					avatarBtn4.setVisible(false);
					avatarBtn1.setVisible(false);
					avatarBtn6.setVisible(false);
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					avatarBtn2.setVisible(true);
					avatarBtn3.setVisible(true);
					avatarBtn4.setVisible(true);
					avatarBtn1.setVisible(true);
					avatarBtn6.setVisible(true);
					obstacle = true;
				}
			}
		});
	
		avatarBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					avatarBtn2.setVisible(false);
					avatarBtn3.setVisible(false);
					avatarBtn4.setVisible(false);
					avatarBtn5.setVisible(false);
					avatarBtn1.setVisible(false);
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					avatarBtn2.setVisible(true);
					avatarBtn3.setVisible(true);
					avatarBtn4.setVisible(true);
					avatarBtn5.setVisible(true);
					avatarBtn1.setVisible(true);
					obstacle = true;
				}
			}
		});
			
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				String testo = txtWrite.getText();
				if (!testo.equals("")) {
					
				avatarBtn1.setVisible(true);
				avatarBtn2.setVisible(true);
				avatarBtn3.setVisible(true);
				avatarBtn4.setVisible(true);
				avatarBtn5.setVisible(true);
				avatarBtn6.setVisible(true);
				
				}
			}
		});
		
	
		srnameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				txtWrite.setVisible(true);
				srnameBtn.setVisible(false);
				confirmBtn.setVisible(true);
				
			}
		});		
		
	
	}
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
}
