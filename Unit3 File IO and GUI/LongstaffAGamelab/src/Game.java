
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	racquet racquet = new racquet(this);
	attacking attacking = new attacking(this);

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawString("Troll Health: " + this.ball.getHealth(),92,125);

		g.drawString("Each time the ball bounces",65,150);
		g.drawString("the racquet and ball get faster  ",60,170);
		g.drawString("Kill the troll. ",100,200);
		g.drawString("Your Score: " + this.ball.getSpeed(),92,220);

		ball.paint(g2d);
		racquet.paint(g2d);
		attacking.paint(g2d);
	}
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over, your score was: "+ this.ball.getSpeed() + " He had: "+ this.ball.getHealth() + "Hp", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public void gameWin() {
		JOptionPane.showMessageDialog(this, "You Won!! "+ this.ball.getSpeed(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}