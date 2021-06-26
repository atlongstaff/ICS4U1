/**This program was completed as an ICS4U lab
	*GUI scheduler
	*demos GUI Consepts by creating a scheduling app
	*@author Alex Longstaff
	*@Version 2021-05-13
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LongstaffAToDoGUI {
	//define various fields
	private JFrame frmMain;
	private final JPanel TOP = new JPanel();
	private JTextField DatetxtFld;
	private JTextField TimeTxtFld;
	private JTextField actionTxtFld;
	private JTextField phonenumtxtfld;
	private JTextField PersonRelatedtxtfld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongstaffAToDoGUI window = new LongstaffAToDoGUI();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end main

	/**
	 * Create the application.
	 */
	public LongstaffAToDoGUI() {
		initialize();
	}//end initalize

	/**
	 * Initialize the contents of the frame.
	 * Main body of code.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		
		//start Main frame, and Frame at the top.
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.setBounds(100, 100, 608, 582);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		TOP.setBackground(Color.RED);
		TOP.setBounds(35, 22, 547, 64);
		frmMain.getContentPane().add(TOP);
		TOP.setLayout(null);
		
		//label the top frame to do list
		JLabel toplbl = new JLabel("To-Do List");
		toplbl.setFont(new Font("Tahoma", Font.PLAIN, 52));
		toplbl.setBounds(171, 11, 247, 42);

		TOP.add(toplbl);
		
		
		//create Middle main body frame
		JPanel MIDDLE = new JPanel();
		MIDDLE.setBackground(Color.GREEN);
		MIDDLE.setLayout(null);
		MIDDLE.setBounds(35, 97, 547, 314);
		frmMain.getContentPane().add(MIDDLE);

		//create Text Field for date
		DatetxtFld = new JTextField();
		DatetxtFld.setBounds(154, 63, 86, 20);
		MIDDLE.add(DatetxtFld);
		DatetxtFld.setColumns(10);
		
		//create Text Field for time
		TimeTxtFld = new JTextField();
		TimeTxtFld.setColumns(10);
		TimeTxtFld.setBounds(286, 63, 86, 20);
		MIDDLE.add(TimeTxtFld);
		
		//create Text Field for the task
		actionTxtFld = new JTextField();
		actionTxtFld.setBounds(119, 109, 291, 99);
		MIDDLE.add(actionTxtFld);
		actionTxtFld.setColumns(10);
		
		//create check box for follow up
		JCheckBox Followupchcbx = new JCheckBox("Follow up required");
		Followupchcbx.setBackground(Color.GREEN);
		Followupchcbx.setBounds(286, 284, 122, 23);
		MIDDLE.add(Followupchcbx);
		
		//create combo box for priority
		JComboBox prioritycombobx = new JComboBox();
		prioritycombobx.setMaximumRowCount(3);
		prioritycombobx.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		prioritycombobx.setBounds(154, 284, 96, 22);
		MIDDLE.add(prioritycombobx);
		
		//create Text Field for phone number
		phonenumtxtfld = new JTextField();
		phonenumtxtfld.setColumns(10);
		phonenumtxtfld.setBounds(286, 240, 86, 20);
		MIDDLE.add(phonenumtxtfld);
		
		//create Text Field for name of person related to task
		PersonRelatedtxtfld = new JTextField();
		PersonRelatedtxtfld.setColumns(10);
		PersonRelatedtxtfld.setBounds(154, 240, 86, 20);
		MIDDLE.add(PersonRelatedtxtfld);
		
		
		/**
		 * Labels for each of the above input fields or boxes. 
		 */
		JLabel actionlbl = new JLabel("Input Your Task:");
		actionlbl.setBounds(119, 94, 154, 14);
		MIDDLE.add(actionlbl);
		JLabel lblInputTheDate = new JLabel("Input The Date:");
		lblInputTheDate.setBounds(154, 50, 86, 14);
		MIDDLE.add(lblInputTheDate);
		JLabel lblInputTheTime = new JLabel("Input The Time:");
		lblInputTheTime.setBounds(286, 50, 86, 14);
		MIDDLE.add(lblInputTheTime);
		JLabel lblInputAnyoneRelated = new JLabel("Input anyone related to the event:");
		lblInputAnyoneRelated.setBounds(51, 219, 189, 14);
		MIDDLE.add(lblInputAnyoneRelated);
		JLabel lblInputAnyoneTheir = new JLabel("Input their phone number");
		lblInputAnyoneTheir.setBounds(286, 219, 169, 14);
		MIDDLE.add(lblInputAnyoneTheir);
		JLabel lblRankThisEvent = new JLabel("Rank this event by priority");
		lblRankThisEvent.setBounds(91, 271, 189, 14);
		MIDDLE.add(lblRankThisEvent);
		
		
		
		
		
		
		
		
		
		
		
		
		//create a bottom frame for various buttons. 
		JPanel BOTTOM = new JPanel();
		BOTTOM.setBackground(Color.BLUE);
		BOTTOM.setLayout(null);
		BOTTOM.setBounds(35, 433, 547, 88);
		frmMain.getContentPane().add(BOTTOM);
		
		
		/**Activates a option pane, to make sure the user wants to exit
		 * @param ActionEvent e
		 * @returns exiting the program.
		 */
		JButton exitbtn = new JButton("EXIT");
		exitbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitbtn.setBackground(Color.RED);
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if  (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "Exit!",  JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					System.exit(0);
				}//end if
			}//end method
		});
		exitbtn.setBounds(10, 11, 89, 66);
		BOTTOM.add(exitbtn);
		
		
		/**Sets all boxes and fields to empty.
		 * @param ActionEvent e
		 * @returns set text methods with empty paramaters
		 */
		JButton Newbtn = new JButton("New Item");
		Newbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PersonRelatedtxtfld.setText("");
					TimeTxtFld.setText("");
					DatetxtFld.setText("");
					actionTxtFld.setText("");
					phonenumtxtfld.setText("");
					prioritycombobx.setSelectedItem("");
					Followupchcbx.setSelected(false);
			}//end method
		});
		Newbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Newbtn.setBackground(Color.RED);
		Newbtn.setBounds(109, 11, 127, 66);
		BOTTOM.add(Newbtn);
		
		
		/**Sets Text in itemsData.txt to empty
		 * @param ActionEvent e
		 * @returns empty itemsData.txt file
		 */
		JButton Delete = new JButton("Delete Item");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter output = null;
				try { 
				    File file = new File("itemsData.txt"); 
				     output = new BufferedWriter(new FileWriter(file));     
				           output.write(""); //clears data
				           output.newLine(); //sets new line
				} //end try=
				catch ( IOException e1 ) { 
				    e1.printStackTrace(); 
				} //end catch
				finally { 
				    	if ( output != null ) { 
				       	try { 
				output.close(); 
				}//end try
				catch ( IOException e1 ) { 
				e1.printStackTrace(); 
				} //end catch
				}//end if 
				}//end finally

			}
		});
		Delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Delete.setBackground(Color.RED);
		Delete.setBounds(392, 11, 136, 66);
		BOTTOM.add(Delete);
		
		
		/**Sets Text in itemsData.txt to the entered values in each box /Field
		 * @param ActionEvent e
		 * @returns Filled itemsData.txt file
		 */
		JButton Savebtn = new JButton("Save Item");
		Savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter output = null;
				try { 
				    File file = new File("itemsData.txt"); 
				     output = new BufferedWriter(new FileWriter(file, true)); 
				     		//writes data
				           output.write(TimeTxtFld.getText()+ ":" + DatetxtFld.getText()+ ":" + actionTxtFld.getText()+ ":" + phonenumtxtfld.getText()+ ":" + PersonRelatedtxtfld.getText()+ ":" + prioritycombobx.getSelectedItem().toString()+ " Followup:" + Followupchcbx.isSelected()); 
				           output.newLine();//starts new line
				} //end try
				catch ( IOException e1 ) { 
				    e1.printStackTrace(); 
				} //end catch
				finally { 
					if ( output != null ) { 
						try { 
							output.close(); 
						}//end try
						catch ( IOException e1 ) { 
							e1.printStackTrace(); 
						} //end catch
					}//end if 
				}//end finally
			}//end method
		});
		Savebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Savebtn.setBackground(Color.RED);
		Savebtn.setBounds(246, 11, 136, 66);
		BOTTOM.add(Savebtn);
	}
}
