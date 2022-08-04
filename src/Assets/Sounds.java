package Assets;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
	public static void clickMenuBtn() {
		try {
		    File wavFile = new File("sound\\swipeSound.wav");
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(wavFile));
		    clip.start();
		} catch (Exception e1) {
		    System.out.println(e1);
		}
	}
	
	public static void backgroundSong() {
		try {
		    File wavFile = new File("sound\\Ludum Dare 32 - Track 2.wav");
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(wavFile));
		    clip.start();
		    clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e1) {
		    System.out.println(e1);
		}
	}
}
