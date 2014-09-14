import java.awt.Color;
import java.awt.Graphics2D;
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
		if (y + ya > 0 && y + ya < game.getHeight()-this.getLenght())
			y = y + ya;		
		
		if (y + ya <= 0) {
			y = game.getHeight() - this.getLenght();
		}
		
		if (y + ya >= game.getHeight()-this.getLenght()) {
			y = 0;
		}
	}

	public void paint(Graphics2D g) {
		g.setColor(this.color);
		if (this.position == "left") {
			g.fillRect(5, y, 10, racquetLenght);
		}else if (this.position == "right") {
			g.fillRect(770, y, 10, racquetLenght);
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
}