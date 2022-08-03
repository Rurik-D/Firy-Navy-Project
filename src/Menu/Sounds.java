package Menu;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {
	static void clickMenuBtn() {
		try {
		    File wavFile = new File("sound\\swipeSound.wav");
		    Clip clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(wavFile));
		    clip.start();
		} catch (Exception e1) {
		    System.out.println(e1);
		}
	}
}
