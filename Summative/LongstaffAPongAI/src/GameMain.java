/**This program was completed as an ICS4U Summitive assesment
	*Main game file.
	*demos artificial intelligence concepts through the video game pong
	*@author Alex Longstaff
	*@Version 2021-06-17
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GameMain extends JPanel {

	Ball ball = new Ball(this);
	Racketone Racketone = new Racketone(this);
	Rackettwo Rackettwo = new Rackettwo(this);
	JFrame frame = new JFrame("Mini Tennis");
	static Boolean Started = false;
	
	static int gamespeed = 5;
	/*operates a key listener
	 *@returns framerate increasing or decreasing based off of key press
	*/
	public GameMain() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				//gamespeed must be > 0 and <10 because it has not been tested for over 10, and less than 0 freezes the program
				if (e.getKeyCode() == KeyEvent.VK_UP && gamespeed-1 >0)
					gamespeed -=1;
				if (e.getKeyCode() == KeyEvent.VK_DOWN && gamespeed +1 < 10)
					gamespeed += 1;
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setFocusable(true);

	}
	/**Calls the move methods in all other files
	 * no paramaters. Just calls other methods
	*/
	private void move() {
		ball.move();
		Racketone.move();
		Rackettwo.move();
	}
	/**Calls the paint methods in all other files
	 * @param graphics g
	*/
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		Racketone.paint(g2d);
		Rackettwo.paint(g2d);
	}
	
	/**Calls the gameover methods in all other files
	 *no paramaters just calls other methods
	*/
	public void gameOver() {
		Racketone.gameover();
		Rackettwo.gameover();
	}
	
	/**get method to return the boolean value that determines if the game has started
	 *@returns Boolean Started to determine if game has started
	*/
	public boolean getStart() {
		return Started;
	}
	
	public static void main(String[] args)  throws InterruptedException {
		
		//defines frame and game
		JFrame frame = new JFrame("Pong");
		GameMain game = new GameMain();
		frame.setSize(800, 450);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(game);

		//creates a menu jframe
		JFrame Menu = new JFrame("Menu");
		Menu.getContentPane();
		Menu.setSize(450, 650);
		Menu.setVisible(true);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.getContentPane().setLayout(null);

		//creates the top label for the title
		JLabel toplbl = new JLabel("Open Pong AI");
		toplbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		toplbl.setBounds(110, 10,200, 50);
		Menu.getContentPane().add(toplbl);
		
		//creates a mid label that outlines what the project is
		JLabel midlbl = new JLabel("<html>Open Pong AI is an artificial intelligence demo based off of the pong game. It uses neural networks combined with a randomized training system to overcome the local maxima climbing problem, and train the network to play the pong game.</html>", SwingConstants.CENTER);
		midlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		midlbl.setBounds(10, 80 ,400, 150);
		Menu.getContentPane().add(midlbl);

		//creates a bottom label that outlines how it works
		JLabel howtolbl = new JLabel("<html>To use the demo click the button below. It takes 75 sessions to start training the network. A game ends when a ball goes into a goal, and a session ends when ten games are completed. A new network is generated at the end of every session. This may take a while but you can speed it up with the arrow keys. </html>", SwingConstants.CENTER);
		howtolbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		howtolbl.setBounds(10, 250 ,400, 150);
		Menu.getContentPane().add(howtolbl);

		//creates a button that activates a game.
		JButton btnNewButton = new JButton("Begin Training Network");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sets the game to visible
				frame.setVisible(true);
				Menu.setVisible(false);
				Started = true; //sets variable to true
				System.out.println("started" + Started);
			
				//clears networkfiles by writing there content to empty ""
				PrintWriter writer1;
				PrintWriter writer2;
				try {//try to write
					writer2 = new PrintWriter("networkfile2.txt");
					writer2.print("");
					writer2.close();
					writer1 = new PrintWriter("networkfile1.txt");
					writer1.print("");
					writer1.close();
				} catch (FileNotFoundException e1) {//error handeling
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(110, 450, 200, 100);
		Menu.getContentPane().add(btnNewButton);
		//repaint so that all the labels and buttons are added
		Menu.repaint();


		while (true) {
			//calls game.move, the function that runs all the other moves.
			game.move();
			//repaint the game
			game.repaint();
			//determines whats effectively framerate
			Thread.sleep(gamespeed);
		}		
	}
}