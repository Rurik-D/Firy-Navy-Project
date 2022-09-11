package resources;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class TextManagement{
	private JTextArea textArea = new JTextArea(100, 100);
	private static Font font = new Font("Segoe Script", Font.BOLD, 21);
	private static Font parameterFont = new Font("Segoe Script", Font.BOLD, 15);
	private String text;
	private String player1Name;
	private String player2Name;
	private String computerName = "computer";

	
	
	/**
	 * 
	 * 
	 */
	public JTextArea getTextArea() {
		return textArea;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static Font getParameterFont() {
		return parameterFont;
	}
	
	
	/**
	 * @param player refears to player type
	 * 		1 -> player 1;
	 * 		2 -> player 2;
	 * 		3 -> computer;
	 * 
	 * @see main.gui.MenuButtons
	 */
	public String getPlayerName(int player) {
		return switch (player) {
		case 1 -> player1Name;
		case 2 -> player2Name;
		case 3 -> computerName;
		default -> "";
		};
	}
	
	
	/**
	 * @param player refears to player type
	 * 		1 -> player 1;
	 * 		2 -> player 2;
	 * 		3 -> computer;
	 * 
	 * @param name is the name to be assigned to the player
	 * 
	 * @see main.gui.MenuButtons
	 */
	public void setPlayerName(int player, String name) {
		switch (player) {
		case 1:
			this.player1Name = name;
			break;
		case 2: 
			this.player2Name = name;
			break;
		};
		
	}
	
	
	/**
	 * 
	 * 
	 */
	public void setTextArea() {
		resetText();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);		
		textArea.setBackground(new Color(209, 191, 138));
		textArea.setFont(font);
		textArea.setEditable(false);
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void resetText() {
		text = "WELCOME TO FIRY NAVY PROJECT!\n\n"
			 + "Let's start by dragging the ships onto the grid.\n"
			 + "Once you are done press \"confirm\" to start the battle!\n"
			 + "(double tap to rotate ships)\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void confirmSetupMessage() {
		text += "\nSETUP CONFIRMED, prepare for war!\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void addText(String textToAdd) {
		text += textToAdd +"\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void notConfirmMessage() {
		text += "\nPlace the ships before pressing confirm.\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void hitMessage(int player, String coordinates) {
		text += getPlayerName(player) + " :  " + coordinates + " , hit!\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void missMessage(int player, String coordinates) {
		text += getPlayerName(player) + " :  " + coordinates + " , miss\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void pauseMessage() {
		text += "Pause\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void resumeMessage() {
		text += "Resume\n";
		textArea.setText(text);
	}
	
	
	/**
	 * 
	 * 
	 */
	public void sunkMessage(int player, String coordinates) {
		text += getPlayerName(player) + " : " + coordinates +  ", hit and sunk!\n";
		textArea.setText(text);
	}
	
}
