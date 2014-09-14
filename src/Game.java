import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JPanel{
	    Ball ball = new Ball(this);
	    Racquet racquet = new Racquet(this, 80, Color.RED, KeyEvent.VK_Q,
				KeyEvent.VK_A, "left"); // second property is racquet
													// length
		Racquet racquet2 = new Racquet(this, 80, Color.BLACK, KeyEvent.VK_O,
				KeyEvent.VK_L, "right");
		
		public Game() {
			addKeyListener(new KeyListener() {
				
				public void keyTyped(KeyEvent e) {
				}

			//	@Override
				public void keyReleased(KeyEvent e) {
					racquet.keyReleased(e);
					racquet2.keyReleased(e);
				}

			//	@Override
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

		//@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			ball.paint(g2d);
			racquet.paint(g2d);
			racquet2.paint(g2d);
		}
		
		public void gameOver() {
			JOptionPane.showMessageDialog(this, "Game Over","Game Over" , JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
		}

	public static void main(String[] args) throws InterruptedException {
		JFrame gameWindow = new JFrame("CRANBERRY TENNIS");
		Game game = new Game();
		gameWindow.add(game);

		gameWindow.setSize(800, 400); // set size of the field
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false); // disable resize
		gameWindow.setLocationRelativeTo(null); // make to appear in the middle
												// of the screen

		while (true) {
			game.move();			
			game.repaint();
			Thread.sleep(5);
		}

	}
}