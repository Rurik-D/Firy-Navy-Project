package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class GameTimer {
	private static Timer timer;
	private static JLabel timerLbl = new JLabel("");
	private static int seconds = 0;
	private static int tenSeconds = 0; 
	private static int minutes = 0; 
	private static int tenMinutes = 0; 

	
	/**
	 * 
	 * 
	 */
	public static JLabel getTimerLbl() {
		return timerLbl;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void setTimer() {
		timerLbl.setVisible(true);
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (seconds == 10) {
					seconds = 0;
					tenSeconds += 1;
				}
				
				if (tenSeconds == 6) {
					tenSeconds = 0;
					minutes += 1;
					
					if (minutes == 10) {
						minutes = 0;
						tenMinutes += 1;
					}
				}
				
				timerLbl.setText( tenMinutes + "" + minutes + ":" + tenSeconds + "" + seconds);
				seconds++;
			}
		});
		timer.start();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void startTimer() {
		timer.start();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void stopTimer() {
		timer.stop();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void resetTimer() {
		seconds = 0;
		tenSeconds = 0;
		minutes = 0;
		tenMinutes = 0;
		timerLbl.setText( tenMinutes + "" + minutes + ":" + tenSeconds + "" + seconds );
		timer.stop();
	}
	
}
