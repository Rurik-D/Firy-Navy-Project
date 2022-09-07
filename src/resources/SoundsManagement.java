package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Timer;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class SoundsManagement {
	private static ResourceBundle soundBundle =  ResourceBundle.getBundle("utils.file/sounds");
	private static Clip menuSong;
	private static Clip gameSong;
	private static float menuVolume = 0f;
	private static float effectsVolume = 0.5f;
	private static float gameVolume = 0f;
	private static Timer menuSongFadeTimer;
	private static Timer gameSongFadeTimer;
	private static boolean menuFadeRunning = false;
	private static boolean gameFadeRunning = false;
	
	
	/**
	 * 
	 * 
	 */
	public static void clickMenuBtn() {
		Clip click = getClip(new File(soundBundle.getString("sound.button")));
		
	    FloatControl volumeControl = (FloatControl) click.getControl(FloatControl.Type.MASTER_GAIN);        
	    volumeControl.setValue(20f * (float) Math.log10(effectsVolume));
		click.start();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void start(String clip) {
		Clip song = switch(clip) {
			case "menuSong" -> { menuSong = getClip(new File(soundBundle.getString("sound.menu"))); yield menuSong; }
			case "gameSong" -> { gameSong = getClip(new File(soundBundle.getString("sound.game"))); yield gameSong; } // setVolume(0.25f, "gameSong");
			default -> null;
		};
		

		song.start();
		
		shutOffVolume(song);
		switch(clip) {
		case "menuSong": 
			menuFade(1);
			break;
			
		case "gameSong": 
			gameFade(1);

			break;
	}
		song.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void stop(String clip) {
		Clip song = switch(clip) {
			case "menuSong" -> menuSong;
			case "gameSong" -> gameSong;
			default -> null;
		};
		
		switch(clip) {
			case "menuSong": 
				menuFade(-1);
				break;
				
			case "gameSong": 
				gameFade(-1);
				break;
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	public static Clip getClip(File wavFile) {
		try {
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(wavFile));
		    return clip;
		} catch (Exception e1) {
		    System.out.println(e1);
		}
		return null;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static float getVolume(String clip) {
	    FloatControl volumeControl = switch(clip) {
			case "menuSong" -> (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);      
			case "gameSong" -> (FloatControl) gameSong.getControl(FloatControl.Type.MASTER_GAIN); 
			default -> null;
		};
	    return (float) Math.pow(10f, volumeControl.getValue() / 20f);
	};

	
	/**
	 * 
	 * 
	 */
	public static void setVolume(float newVolume, String clip) {
		FloatControl volumeControl;
		
		switch(clip) {
			case "menuSong": 
				menuVolume = newVolume;
				volumeControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
			    volumeControl.setValue(20f * (float) Math.log10(menuVolume));
				break;
				
			case "gameSong": 
				gameVolume = newVolume;
				volumeControl = (FloatControl) gameSong.getControl(FloatControl.Type.MASTER_GAIN);        
				volumeControl.setValue(20f * (float) Math.log10(gameVolume));
				break;
				
			case "effects": 
				effectsVolume = newVolume;
				break;
		}
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void setVolume(String clip) {
		FloatControl volumeControl;
		
		switch(clip) {
			case "menuSong": 
				volumeControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
			    volumeControl.setValue(20f * (float) Math.log10(menuVolume));
				break;
				
			case "gameSong": 
				volumeControl = (FloatControl) gameSong.getControl(FloatControl.Type.MASTER_GAIN);        
				volumeControl.setValue(20f * (float) Math.log10(gameVolume));
				break;
		}
	}
	
	
	/**
	 * @param on_off == 1 or -1
	 * 
	 */
	private static void menuFade(int on_off) {
		// se sto già dissolvendo la canzone, fermati e inverti il processo
		if (menuFadeRunning) { menuSongFadeTimer.stop(); }
		menuFadeRunning = true;

		menuSongFadeTimer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuVolume += 0.05f * on_off;
				menuVolume = (float)Math.round(menuVolume * 100f) / 100f;
				
				if (menuVolume <= 0.00f || menuVolume >= 0.50f) {
					if (on_off == -1) {
						menuSong.close();
					}
					menuFadeRunning = false;
					menuSongFadeTimer.stop();
				}
				setVolume("menuSong");
			}
		});
		menuSongFadeTimer.start();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void gameFade(int on_off) {
		// se sto già dissolvendo la canzone, fermati e inverti il processo
		if (gameFadeRunning) { gameSongFadeTimer.stop(); }
		gameFadeRunning = true;
		gameSongFadeTimer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gameVolume += 0.05f * on_off;
				gameVolume = (float)Math.round(gameVolume * 100f) / 100f;
				System.out.println(gameVolume);
				if (gameVolume <= 0.00f || gameVolume >= 0.25f) {
					if (on_off == -1) {
						gameSong.close();
					}
					gameFadeRunning = false;
					gameSongFadeTimer.stop();
				}
				setVolume("gameSong");
			}
		});
		gameSongFadeTimer.start();
	}
	
	
	/**
	 * 
	 * 
	 */
	public static void shutOffVolume(Clip clip) {
		FloatControl volumeControl;
		volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
		volumeControl.setValue(20f * (float) Math.log10(0f));
		
	}
}
