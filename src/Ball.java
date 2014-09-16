import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	public static int DIAMETER = 30;
	public static int x = 0;
	public static int y = 0;
	public static int xa = 1;
	public static int ya = 1;
	Color color;
	public static int hitCounter = 0;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		if (Ball.x + Ball.xa < 0) {
			game.Scores("BLACK");
			
		}
		if (Ball.x + Ball.xa > game.getWidth() - DIAMETER) {
			game.Scores("RED");
			
		}
		if (Ball.y + Ball.ya < 0) {
			Ball.ya = 1;
		}
		if (Ball.y + Ball.ya > game.getHeight() - DIAMETER) {
			Ball.ya = -1;
		}
		if (leftCollision()) {
			Sound.Play("COLLISION");
			Ball.xa = 1;
			Ball.hitCounter++;
			if(Ball.DIAMETER > 6){
				increaseDiff(Ball.hitCounter);
				}
		}							
		if (rightCollision()) {
			Sound.Play("COLLISION");
			Ball.xa = -1;
			Ball.hitCounter++;
			if(Ball.DIAMETER > 6){
			increaseDiff(Ball.hitCounter);
			}
		}		
		Ball.x = Ball.x + Ball.xa;
		Ball.y = Ball.y + Ball.ya;
	}
	
	private void increaseDiff(int hits) {
		if (hits > 0) {
				if (hits % 3 == 0){
				Sound.Play("DIFF");
				game.racquet.racquetLenght -= 12;
				game.racquet2.racquetLenght -= 12;
				Ball.DIAMETER -= 3;
				
					if (hits%6==0) {
					Game.gameSpeed -= 1;
					}	
				}
				
			}
		
	}

	private boolean leftCollision() {
		return game.racquet.getLeftBounds().intersects(getBounds());
	}

	private boolean rightCollision() {
		return game.racquet2.getRightBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}