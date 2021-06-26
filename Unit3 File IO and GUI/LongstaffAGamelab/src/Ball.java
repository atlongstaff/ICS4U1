
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	int Speed = 1;
	int Health = 60;
	private Game game;
	private Game2 game2;
	
	public Ball(Game game) {
		this.game= game;
	}
	public Ball(Game2 game2) {
		this.game2= game2;
	}
	
	void move() {
		if (x + xa < 0)
			xa = Speed;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -Speed;
		if (y + ya < 0)
			ya = Speed;
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		
		if (collision()){
			ya = -Speed;
			y = game.racquet.getTopY() - DIAMETER;
			Speed +=1;
		}
		
		if (atcollision()){
			ya = -Speed;
			xa = Speed;
			Health-=1;
		}
		if(Health <=0) {
			game.gameWin();

		}
		x = x + xa;
		y = y + ya;
	}
	
	public int getSpeed() {
		return Speed;
	}
	public int getHealth() {
		return Health;
	}
	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	private boolean atcollision() {
		return game.attacking.getBounds().intersects(getBounds());
	}


	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}