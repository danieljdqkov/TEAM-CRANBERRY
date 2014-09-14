import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	int y = 150;
	int ya = 0;
	private Game game;
	private int racquetLenght;	
	Color color;
	int upKey;
	int downKey;
	String position="";
	
	public Racquet(Game game, int racquetLenght, Color color,
			int upKey, int downKey, String position) {
		this.game= game;
		this.racquetLenght = racquetLenght;
		this.color = color;
		this.upKey = upKey;
		this.downKey = downKey;
		this.position = position;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getLenght() {
		return racquetLenght;
	}
	
	public void setLenght(int racquetLenght) {
		this.racquetLenght = racquetLenght;
	}
	
	public void move() {
		if (this.y + this.ya > 0 && this.y + this.ya < game.getHeight()-this.getLenght())
			this.y = this.y + this.ya;		
	}

	public void paint(Graphics2D g) {
		g.setColor(this.color);
		if (this.position == "left") {
			g.fillRect(10, y, 10, racquetLenght);
		}else if (this.position == "right") {
			g.fillRect(774, y, 10, racquetLenght);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		ya = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == this.upKey)	
			ya = -1;
		if (e.getKeyCode() == this.downKey)
			ya = 1;
	}
	
	public Rectangle getLeftBounds() {
		return new Rectangle(10, y, 10, racquetLenght);
	}
	public Rectangle getRightBounds() {
		return new Rectangle(774, y, 10, racquetLenght);
	}
}