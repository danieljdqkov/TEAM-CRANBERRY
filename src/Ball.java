import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Ball {
	public static int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	Color color;
	int pointscounter = 0;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		if (this.x + this.xa < 0) {
			game.gameOver();
		}
		if (this.x + this.xa > game.getWidth() - DIAMETER) {
			System.out.println(game.ball.pointscounter);
			game.gameOver();
		}
		if (this.y + this.ya < 0) {
			this.ya = 1;
		}
		if (this.y + this.ya > game.getHeight() - DIAMETER) {
			this.ya = -1;
		}
		if (leftCollision()) {
			this.xa = 1;
			pointscounter++;
		}
		if (rightCollision()) {
			this.xa = -1;
			pointscounter++;
		}
		this.x = this.x + this.xa;
		this.y = this.y + this.ya;

	}

	private boolean leftCollision() {
		return game.racquet.getLeftBounds().intersects(getBounds());
	}

	private boolean rightCollision() {
		return game.racquet2.getRightBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.setColor(color.ORANGE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}