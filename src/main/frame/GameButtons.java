package main.frame;

import java.awt.Font;

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

public class GameButtons {
	
	
	private ResourceBundle resourceBundle = ResourceBundle.getBundle("utils.file/setLanguage", Locale.forLanguageTag("en"));
	//private Font font = new Font("Segoe Script", Font.BOLD, fontDim);
	private JButton newOptionBtn = new JButton(resourceBundle.getString("button.newOptionBtn"));
	private JButton newBackToMenuBtn = new JButton(resourceBundle.getString("button.newBackToMenuBtn"));
	private JButton newPauseBtn = new JButton(resourceBundle.getString("button.newPauseBtn")); 
	
	public GameButtons(JPanel menu) {
		
		newOptionBtn.setVisible(true);
		newBackToMenuBtn.setVisible(false);
		newPauseBtn.setVisible(false);
		
		newOptionBtn.setBounds(20,20,100,50);
		newBackToMenuBtn.setBounds(20,20,100,50);
		newPauseBtn.setBounds(20,40,100,50);
		
//		newOptionBtn.setFont(font);
//		newBackToMenuBtn.setFont(font);
//		newPauseBtn.setFont(font);
		
		setTrasparent(newOptionBtn);
		setTrasparent(newBackToMenuBtn);
		setTrasparent(newPauseBtn);
		
		menu.add(newBackToMenuBtn);
		menu.add(newOptionBtn);
		menu.add(newPauseBtn);
		
		newOptionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoundsManagement.clickMenuBtn();
				newOptionBtn.setVisible(false);
				newBackToMenuBtn.setVisible(true);
				newPauseBtn.setVisible(true);
			}
		});
	}
	
	
	private void setTrasparent(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	
	

}
