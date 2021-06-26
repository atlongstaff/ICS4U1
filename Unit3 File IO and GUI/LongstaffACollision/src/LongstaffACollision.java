import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


///////////////////////////////////////////////////////// class DrawingPanel

class LongstaffACollision extends JPanel implements KeyListener {
	//===================================================== field variables
	static JFrame window = new JFrame ("Keyboard Conttrols"); // KeyDemoGUI();
	String display = ""; // Initial string to display
	static int x = 50; // Initial coordinates of drawing object
	static int y = 50;
	static int x2 = 10; // Initial coordinates of second drawing object
	static int y2 = 10;
	
	
	
	static int reachedtarget1 =0;
	static int reachedtarget2 =0;
	
	
	static Font biggerFont = new Font("sansserif", Font.PLAIN, 24);
	static int speed = 2; // number of pixels to move
	
	static Timer timer;
	
	static Image i1;
	static Image i2;

	
	
//========================================================= constructor
	public LongstaffACollision() {
		this.setBackground(Color.white);
		this.setFont(biggerFont);
		this.setPreferredSize(new Dimension(600, 300));
		this.addKeyListener(this); // This class has its own key listeners.
		this.setFocusable(true); // Allow panel to get focus
	}//endconstructor

	
	
//======================================================= paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String i1PATH = "i1.jpg";
		String i2PATH = "i2.jpg";
		i1 = Toolkit.getDefaultToolkit().getImage(i1PATH);
		i2 = Toolkit.getDefaultToolkit().getImage(i2PATH);
		
		
		//g.drawString(display, x, y);
		
		Rectangle r1 = new Rectangle(x, y, 30, 40);
		Rectangle r2 = new Rectangle(x2, y2, 30, 40);
		Rectangle target = new Rectangle(560, 260, 40, 40);
		
		g.setColor(Color.green);
		g.fillRect(target.x, target.y, target.width, target.height);
		
		
		//draw first rectangle
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		g.drawImage(i1,r1.x, r1.y, r1.width, r1.height, window);
		
		
		//draw second rectangle
		g.fillRect(r2.x , r2.y, r2.width, r2.height);
		g.drawImage(i2, r2.x, r2.y, r1.width, r1.height, window);
	
		//Collision detection
		if (r1.intersects(r2)==true){
			System.out.println("Collision");
	
		}
		if (r1.intersects(target)==true){
			if (reachedtarget1 == 0) {
				JOptionPane.showMessageDialog(null, "Target Reached", "", JOptionPane.DEFAULT_OPTION);
				reachedtarget1 =1;
			}
		} 
		
		if (r2.intersects(target)==true){
			if (reachedtarget2 == 0) {
				JOptionPane.showMessageDialog(null, "Target Reached", "", JOptionPane.DEFAULT_OPTION);
				reachedtarget2 =1;
			}
		}
	
		ReminderBeep(1);
	}//endmethod paintComponent

	

	//==================================================== keyTyped listener
	public void keyTyped(KeyEvent kevt) {
		char c = kevt.getKeyChar();
		
		if (c == '\b') { // if this is a backspace
			if (display.length() > 0) { // remove last character
				
				display = display.substring(0, display.length()-1);
			
			}
			
		} else {
			
			display += c;
	
		}
		this.repaint();
	
	}//endmethod keyTyped

	
	
	
	//================================================== keyPressed listener
	public void keyPressed(KeyEvent e) {
		if (e.isShiftDown()) {
			speed = 10;
		} else {
			speed = 2;
		}
	
		//-- Process arrow "virtual" keys
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT : x -= speed; x = Math.max(x, 0); break;
			case KeyEvent.VK_RIGHT: x += speed; x = Math.min(x, 590); break;
			case KeyEvent.VK_UP : y -= speed; y = Math.max(y, 0); break;
			case KeyEvent.VK_DOWN : y += speed; y = Math.min(y, 270); break;
	
		}
		//-- Process wasd "virtual" keys
	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_D : x2 += speed; x2 = Math.min(x2, 590); break;
			case KeyEvent.VK_A : x2 -= speed; x2 = Math.max(x2, 0); break;
			case KeyEvent.VK_W : y2 -= speed; y2 = Math.max(y2, 0); break;
			case KeyEvent.VK_S : y2 += speed; y2 = Math.min(y2, 270); break;
		}
	
	
		speed = 2; // Restore speed to its default value
	
		this.repaint(); // Display the changes.
								
	}//endmethod keyPressed




	
	//------------------------------------------------- keyReleased listener
	public void keyReleased(KeyEvent ke) {} // Ignore.
	public static void main(String[] args) {
	
		window.getContentPane().setLayout(new BorderLayout());
		JLabel instructions = new JLabel("<html><ul><li>Type text.</li>"
		+ "<li>Use arrow keys to move text.</li>"
		+ "<li>Press shift arrows to move faster.</li></html>");
		window.getContentPane().add(instructions, BorderLayout.NORTH);
		
	
		LongstaffACollision drawing = new LongstaffACollision();
		window.getContentPane().add(drawing, BorderLayout.CENTER);
		window.setVisible(true);
		window.pack();
	
	}

	public void ReminderBeep(int seconds) {
		timer = new Timer();
		timer.schedule(new RemindTask(), seconds);
	}
	
	class RemindTask extends TimerTask {
		public void run() {	
			repaint();
		}
	}


}//endclass MovingTextPanel