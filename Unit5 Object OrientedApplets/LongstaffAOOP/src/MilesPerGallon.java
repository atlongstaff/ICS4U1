/**This program was completed as an ICS4U lab
	*Miles per gallon main
	*demos oop concepts using a car object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/

import java.util.Scanner;

public class MilesPerGallon {
	public static void main( String[] args ) { 

		Scanner s = new Scanner(System.in);
		//creates a basic menu
    	System.out.println("Enter first reading:"); 
		double FReading = s.nextDouble();
    	
    	System.out.println("Enter second reading:"); 
		double Sreading = s.nextDouble();
		
		System.out.println("Enter gallons:"); 		
		double gallons = s.nextDouble();
		
		Car car = new Car( FReading, Sreading, gallons ); 
	    System.out.println( "Miles per gallon is " + car.calculateMPG() ); 
	    car.startMile();
		  //call boolean objects and print message

	    if (car.gasHog() == true) {
	    	System.out.println( "Gas Hog!" ); 
	    } else if(car.economyCar() == true) {
	    	System.out.println( "Economy Car!" ); 
	    }	    
	}

}
