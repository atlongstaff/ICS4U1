import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
public class Question3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question3 window = new Question3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Question3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 743);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ButtonR0C = new JButton("R0-C0");
		ButtonR0C.setBounds(41, 23, 85, 59);
		frame.getContentPane().add(ButtonR0C);
		
		JButton ButtonR0C_1 = new JButton("R0-C0");
		ButtonR0C_1.setBounds(41, 92, 85, 59);
		frame.getContentPane().add(ButtonR0C_1);
		
		JButton ButtonR0C_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1.setBounds(41, 161, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1);
		
		JButton ButtonR0C_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1.setBounds(41, 230, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1);
		
		JButton ButtonR0C_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1.setBounds(41, 299, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1_1.setBounds(41, 368, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1_1_1.setBounds(41, 437, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1_1_1_1.setBounds(41, 506, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1_1_1_1_1.setBounds(41, 575, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1_1_1_1_1 = new JButton("R0-C0");
		ButtonR0C_1_1_1_1_1_1_1_1_1.setBounds(41, 644, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1_1_1_1_1);
		
		JButton ButtonR0C_1_1_1_1_1_1_1_1_2 = new JButton("R0-C1");
		ButtonR0C_1_1_1_1_1_1_1_1_2.setBounds(155, 23, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_1_1_1_1_1_1_1_2);
		
		JButton ButtonR0C_1_2 = new JButton("R0-C0");
		ButtonR0C_1_2.setBounds(155, 92, 85, 59);
		frame.getContentPane().add(ButtonR0C_1_2);
	}
}
