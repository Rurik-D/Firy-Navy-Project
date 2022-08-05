package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.ArrayList;
import java.util.List;

import Assets.Background;
import Assets.Sounds;

public class StartButtons {
	
	private Font font = new Font("Segoe Script", Font.BOLD, 35);
	
	public boolean obstacle = true;
	public JTextField txtWrite;
	public JButton saveBtn = new JButton("START");
	public JButton confirmBtn = new JButton("CONFIRM");
	public JButton srnameBtn = new JButton("SURNAME");
	public List<JButton> avatarBtns = new ArrayList<>();

	
	public StartButtons( JPanel menu) {
		List<Icon> avatars = new ArrayList<>();
		
		createAvatarBtnList(menu);
		
		txtWrite = new JTextField();
		txtWrite.setColumns(10);
		txtWrite.setOpaque(false);
		txtWrite.setFont(font);
		txtWrite.setBorder(null);
		txtWrite.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		saveBtn.setVisible(false);
		confirmBtn.setVisible(false);
		srnameBtn.setVisible(false);
		txtWrite.setVisible(false);

		
		saveBtn.setBounds(131, 583, 270, 40);
		confirmBtn.setBounds(69, 230, 270, 40);
		srnameBtn.setBounds(69, 190, 270, 40);
		txtWrite.setBounds(80, 190, 270, 40);
		
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
		
		setAvatarBtn(avatarBtns, 0);
		setAvatarBtn(avatarBtns, 1);
		setAvatarBtn(avatarBtns, 2);
		setAvatarBtn(avatarBtns, 3);
		setAvatarBtn(avatarBtns, 4);
		setAvatarBtn(avatarBtns, 5);
			
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();

				String testo = txtWrite.getText();
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

				txtWrite.setVisible(true);
				srnameBtn.setVisible(false);
				confirmBtn.setVisible(true);
				
			}
		});		
		
	}
	
	private void createAvatarBtnList(JPanel menu) {
		for (int i = 0; i<2; i++) {
			for (int j = 0; j<3; j++) {
				JButton box;
				box = new JButton("");
				box.setBounds(112 + 63*j, 288 + 63*i, 60, 60);
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
	}
	
	
	private void setAvatarBtn(List<JButton> avatarBtns, int btnNumb) {
		avatarBtns.get(btnNumb).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sounds.clickMenuBtn();

				if (obstacle == true) {
					confirmBtn.setVisible(false);
					saveBtn.setVisible(true);
					for (int i = 0; i<6; i++) {
						if (i != btnNumb) { avatarBtns.get(i).setVisible(false); }
					}
					obstacle = false;
				}
				else {
					confirmBtn.setVisible(true);
					saveBtn.setVisible(false);
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
