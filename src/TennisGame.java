import javax.swing.JFrame;

public class TennisGame {
	public static void main(String[] args) {
		JFrame gameWindow = new JFrame("CRANBERRY TENNIS");
		gameWindow.setSize(800, 400);  //set size of the field
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setResizable(false); //disable resize
		gameWindow.setLocationRelativeTo(null); //make to appear in the middle of the screen
	}
}