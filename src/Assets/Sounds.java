package Assets;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sounds {
	private static Clip menuSong = getClip(new File("sound\\Ludum Dare 32 - Track 2.wav"));
	private static float volume = 0.5f;
	
	
	public static void clickMenuBtn() {
		Clip click = getClip(new File("sound\\swipeSound.wav"));
	    FloatControl gainControl1 = (FloatControl) click.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl1.setValue(20f * (float) Math.log10(volume));
		click.start();
	}
	
	public static void backgroundSong() {
		menuSong.start();
		menuSong.loop(Clip.LOOP_CONTINUOUSLY);
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
	
	public static float getVolume() {
	    FloatControl gainControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}

	public static void setVolume(float newVolume) {
		volume = newVolume;
	    if (volume < 0f || volume > 1f)
	        throw new IllegalArgumentException("Volume not valid: " + volume);
	    FloatControl gainControl = (FloatControl) menuSong.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl.setValue(20f * (float) Math.log10(volume));

	}
}
