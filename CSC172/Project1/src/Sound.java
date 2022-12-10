import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav.wav"));
	public static final AudioClip YAYYY = Applet.newAudioClip(Sound.class.getResource("yay.wav"));
	
	//add files to source
	
	//to play, be like Sound.YAYYY.play();

}
