package Menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import Assets.Background;
import Assets.Sounds;

public class StartButtons {
	
	//private JFrame frame;
	//private JButton pveBtn = new JButton();
	private Font font = new Font("Segoe Script", Font.BOLD, 35);
	
	public boolean obstacle = true;
	public JTextField txtWrite;
	public JButton saveBtn = new JButton("START");
	public JButton confirmBtn = new JButton("CONFIRM");
	public JButton srnameBtn = new JButton("SURNAME");
	public List<JButton> avatarBtns = new ArrayList<>();

	
	public StartButtons( JPanel menu) {
		List<Icon> avatars = new ArrayList<>();
		
		
		txtWrite = new JTextField();
		txtWrite.setColumns(10);

		
		saveBtn.setVisible(false);
		confirmBtn.setVisible(false);
		srnameBtn.setVisible(false);
		txtWrite.setVisible(false);

		
		saveBtn.setBounds(131, 583, 270, 40);
		confirmBtn.setBounds(69, 190, 270, 40);
		srnameBtn.setBounds(69, 190, 270, 40);
		txtWrite.setBounds(131, 221, 270, 40);
		
		saveBtn.setFont(font);
		confirmBtn.setFont(font);
		srnameBtn.setFont(font);

		menu.add(saveBtn);
		menu.add(confirmBtn);
		menu.add(srnameBtn);
		menu.add(txtWrite);
		
		setTrasparent(saveBtn);
		setTrasparent(confirmBtn);
		setTrasparent(srnameBtn);
		
		
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<3; j++) {
				JButton box;
				box = new JButton("");
				box.setBounds(68 + 60*j, 288 + 50*i, 60, 50);
				box.setFont(new Font("Arial", Font.BOLD, 12));
				box.setText("A" + (j+i*3));
				//box.setIcon(avatars.get(j+i*3));  //da implementare, in questo modo si dovrebbe essere scorrevole
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
		
		
		
		avatarBtns.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 0) { avatarBtns.get(i).setVisible(false); }
					}

					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != 0) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});
		
		
		
		avatarBtns.get(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 1) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != 1) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});

		avatarBtns.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 2) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 2) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});
	
		avatarBtns.get(3).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 3) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != 3) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});
	
		avatarBtns.get(4).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 4) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != 4) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});
	
		avatarBtns.get(5).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != 5) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					saveBtn.setVisible(false);
					for (int i = 0; i<6; i++) {
						if (i != 5) { avatarBtns.get(i).setVisible(true); }
					}
					obstacle = true;
				}
			}
		});
			
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sounds.clickMenuBtn();

				String testo = txtWrite.getText();
				if (!testo.equals("")) {
					
					for (int i = 0; i<6; i++) {
						avatarBtns.get(i).setVisible(true);
					}
				
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
