/**This program was completed as an ICS4U lab
	*car method
	*demos oop concepts using a car object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/

import java.util.Scanner;

class newCar { 
    // instance variables double
   double  Miles;  // Stating odometer reading double 
   double  startMiles;  // Stating odometer reading double 
   double  gallons;       // Gallons of gas used between the readings 
   double  newodoreadings;
   
   // constructor 
    newCar( double M) {
    	startMiles = M ; 
    }
    
    
    /**Simulates filling a car
     * calculates miles traveled based on inputs
    *@returns void
    */
	public void fillup() {
		System.out.println("Filling station Visit!"); 

		Scanner s = new Scanner(System.in);

		System.out.println("Enter current odometer reading:"); 

		newodoreadings = s.nextDouble();  // odometer reading double 

		Miles = newodoreadings - startMiles;
		
		System.out.println("Enter Gallons:"); 

		gallons = s.nextDouble();  // odometer reading double 		
    }
	
    /**checks odometer reading
    *@returns newodoreadings
    */
	double newodoreading() {
		return newodoreadings;
	}
	
    /**calculates miles per gallon
    *@returns miles per gallon
    */
   double calculateMPG() { 
       return (Miles)/gallons ; 
    }

   	/** checks if car is a gas hog
    *@returns boolean value
    */
    boolean gasHog() {
    	if (calculateMPG() < 15.0) {
    		return true;
    	}else {
    		return false;
    	}	
    }
  
   	/** checks if car is a econmic
    *@returns boolean value
    */
    boolean economyCar() {
    	if (calculateMPG() > 30.0) {
    		return true;
    	}else {
    		return false;
    	}
    }


    
 
}