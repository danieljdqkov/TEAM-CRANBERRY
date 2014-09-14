import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
	Racquet racquet = new Racquet(this, 80); // second property is racquet
												// length
	Racquet2 racquet2 = new Racquet2(this, 80);

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				racquet2.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				racquet2.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	private void move() {
		racquet.move();
		racquet2.move();
	}

	// ball
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;

	// ball movement
	private void moveBall() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > getWidth() - 30)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > getHeight() - 30)
			ya = -1;

		x = x + xa;
		y = y + ya;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		racquet.paint(g2d);
		racquet2.paint(g2d);
		g.setColor(Color.orange);
		g.fillOval(x, y, 30, 30); // insert ball

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
			game.moveBall(); // moving the ball
			game.repaint();
			Thread.sleep(10);
		}

	}
}