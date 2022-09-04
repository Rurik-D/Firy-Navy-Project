package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class GameTimer {
	private static Timer timer;
	private static JLabel timerLbl = new JLabel("");
	private static int k = 0;
	private static String minutes ="0"; 
	private static int minute;

	
	public static JLabel getTimerLbl() {
		return timerLbl;
	}
	
	
	public static void setTimer() {
		timerLbl.setVisible(true);
		timer = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timerLbl.setText( minutes + ":" + String.valueOf(k));
				k++;
				
				if (k == 60) {
					k = 0;
					minute = Integer.parseInt(minutes) + 1;
					minutes = String.valueOf(minute);
				}
			}
		});
		timer.start();
	}
	
	
	public static void startTimer() {
		timer.start();
	}
	
	
	public static void stopTimer() {
		timer.stop();
	}
	
	
	public static void resetTimer() {
		minutes ="0";
		k = 0;
		timerLbl.setText(minutes + ":" + String.valueOf(k));
		timer.stop();
	}
	
	
}
