import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet2 {
	int y = 150;
	int ya = 0;
	private Game game;
	private int racquetLenght;	
	
	public Racquet2(Game game, int racquetLenght) {
		this.game= game;
		this.racquetLenght = racquetLenght;		
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
		g.setColor(Color.RED);
		g.fillRect(770, y, 10, racquetLenght);
	}

	public void keyReleased(KeyEvent e) {
		ya = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_O )
			ya = -1;
		if (e.getKeyCode() == KeyEvent.VK_L)
			ya = 1;
	}
}