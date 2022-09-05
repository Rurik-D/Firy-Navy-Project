package resources;

import java.io.File;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


/**
 * 
 * @author Emanuele D'Agostino
 * @author Leonardo Lavezzari
 */
public class SoundsManagement {
	private static ResourceBundle soundBundle =  ResourceBundle.getBundle("utils.file/sounds");
	private static Clip menuSong;
	private static Clip gameSong;
	private static float menuVolume = 0.5f;
	private static float effectsVolume = 0.5f;
	private static float gameVolume = 0.5f;

	
	
	public static void clickMenuBtn() {
		Clip click = getClip(new File(soundBundle.getString("sound.button")));
	    FloatControl gainControl1 = (FloatControl) click.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl1.setValue(20f * (float) Math.log10(effectsVolume));
		click.start();
	}
	
	public static void start(String clip) {
		Clip song = switch(clip) {
			case "menuSong" -> { menuSong = getClip(new File(soundBundle.getString("sound.menu"))); yield menuSong; }
			case "gameSong" -> { gameSong = getClip(new File(soundBundle.getString("sound.game"))); yield gameSong; } // setVolume(0.25f, "gameSong");
			default -> null;
		};
		
		song.start();
		song.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void stop(String clip) {
		Clip song = switch(clip) {
			case "menuSong" -> menuSong;
			case "gameSong" -> gameSong;
			default -> null;
		};
		
		song.close();
	}
	
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
	
	public static float getVolume(String clip) {
	    FloatControl gainControl = switch(clip) {
			case "menuSong" -> (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);      
			case "gameSong" -> (FloatControl) gameSong.getControl(FloatControl.Type.MASTER_GAIN); 
			default -> null;
		};
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	};

	public static void setVolume(float newVolume, String clip) {
		FloatControl gainControl;
		
		switch(clip) {
			case "menuSong": 
				menuVolume = newVolume;
			    gainControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
			    gainControl.setValue(20f * (float) Math.log10(menuVolume));
				break;
				
			case "gameSong": 
				gameVolume = newVolume;
				gainControl = (FloatControl) gameSong.getControl(FloatControl.Type.MASTER_GAIN);        
			    gainControl.setValue(20f * (float) Math.log10(gameVolume));
				break;
				
			case "effects": 
				effectsVolume = newVolume;
				break;
		}
	


	}
}
