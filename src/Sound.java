import java.applet.Applet;
import java.applet.AudioClip;
//import java.net.URL;

public class Sound {
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("game_over.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("Background.wav"));
	
	public static void main(String[] args) throws Exception {
		
		
		//public game() {
			
			//......
			
			//});
			//setFocusable(true);
			Sound.BACK.loop();
		}
		//public gameOver(){
			//Sound.BACK.stop();
			//Sound.GAMEOVER.play();
			//...
		}	
	//}