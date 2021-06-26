import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class attacking {
	private static final int Y = 50;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 60;
	int x = 100;

	private Game game;

	public attacking(Game game) {
		this.game = game;
	}

	
	public void paint(Graphics2D g) {
		Image i1 = Toolkit.getDefaultToolkit().getImage("image.jpg");

		g.drawImage(i1,x, Y, WIDTH, HEIGHT, game);

	}

	

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y;
	}
}