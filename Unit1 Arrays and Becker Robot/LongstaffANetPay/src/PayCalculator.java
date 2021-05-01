/**This program was completed as an ICS4U lab
 	*A program to compute net pay with object oriented programming
	*@author Alex Longstaff
	*@Version 2021-03-12
*/
import java.util.*;

//main class
public class PayCalculator {
	//set my variables
	public static Scanner Inscanner = new Scanner(System.in); 	
	//main class
	public static void main(String[] args) {
		//set my variables
		double HRate;
		double HWorked;
		double TRate;
	
		//create an object
		Pay p = new Pay();
	
		//prompt and set double
		System.out.printf("How much do you make an hour?");
		HRate = Inscanner.nextDouble();
		
		//prompt and set double
		System.out.printf("How many hours have you worked?");
		HWorked = Inscanner.nextDouble();
	
		//prompt and set double
		System.out.printf("What is your tax rate?");
		TRate = Inscanner.nextDouble();
	
		//Call the object to set double NetPay
		Double NetPay  = p.computeNetPay(HRate, HWorked, TRate);
		System.out.println("Your Net Pay is " + NetPay); //display results

	}
}
