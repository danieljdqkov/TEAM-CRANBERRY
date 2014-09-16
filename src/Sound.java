
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	public static void Play(String sound) {		
		 try {
	         // Open an audio input stream.
			 File soundFile = new File("lib/sounds/background.wav");
			 if (sound.equals("GOAL")) {
	    		 soundFile = new File("lib/sounds/goal.wav");
			}else if (sound.equals("GAMEOVER")) {
				 soundFile = new File("lib/sounds/game_over.wav");
			}
			 
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         // Get a sound clip resource.
	         
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         if (sound.equals("BACKGROUND")) {
	        	 clip.loop(Clip.LOOP_CONTINUOUSLY);
	         }else{
	        	 clip.start();
	         }
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
			
		}
	}	
