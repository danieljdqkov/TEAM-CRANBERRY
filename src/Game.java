import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static Game game = new Game();
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this, 120, Color.RED, KeyEvent.VK_Q,
			KeyEvent.VK_A, "left"); // second property is racquet
									// length
	Racquet racquet2 = new Racquet(this, 120, Color.BLACK, KeyEvent.VK_O,
			KeyEvent.VK_L, "right");
	
	public static int gameSpeed = 5;
	/////////////
	public static int blackPoints = 0;
	public static int redPoints = 0;

	public Game() {
		addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
			}

			// @Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				racquet2.keyReleased(e);
			}

			// @Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				racquet2.keyPressed(e);
			}
		});
		setFocusable(true);

	}

	private void move() {		
		ball.move();
		racquet.move();
		racquet2.move();
	}

	// @Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		racquet2.paint(g2d);
	}

	

	public static void main(String[] args) throws InterruptedException {
		JFrame gameWindow = new JFrame("CRANBERRY TENNIS");
		
		gameWindow.add(game);
		
		gameWindow.setSize(800, 400); // set size of the field
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false); // disable resize
		gameWindow.setLocationRelativeTo(null); // make to appear in the middle
												// of the screen

		playGame(game, gameSpeed);
		
	}

	public static void playGame(Game game, int gameSpeed) {
		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(gameSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
	public void blackScores() {
		if ((Game.blackPoints > Game.redPoints)&&(Game.blackPoints - Game.redPoints == 2)) {
			JOptionPane.showMessageDialog(this, "BLACK PLAYER WINS", "Game Over",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(ABORT);
		}
		JOptionPane.showMessageDialog(this, "Black Player Scored a point!!!", "Goaaaaaaaal!!!",
				JOptionPane.INFORMATION_MESSAGE);
		Game.blackPoints ++;
		System.out.println(Game.blackPoints);
		Ball.x = 0;
		Ball.y = 0;
		Ball.xa = 1;
		Ball.ya = 1;
		playGame(game, gameSpeed);
		
		
	}
public void redScores() {
		if ((Game.redPoints > Game.blackPoints)&&(Game.redPoints - Game.blackPoints  == 2)) {
			JOptionPane.showMessageDialog(this, "RED PLAYER WINS !!!", "Game Over",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(ABORT);
		}
		JOptionPane.showMessageDialog(this, "Red Player Scored a point!!!", "Goaaaaaaaal!!!",
				JOptionPane.INFORMATION_MESSAGE);
		Game.redPoints++;
		System.out.println(Game.redPoints);
		Ball.x = 0;
		Ball.y = 0;
		Ball.xa = 1;
		Ball.ya = 1;
		playGame(game, gameSpeed);
		
	}
}