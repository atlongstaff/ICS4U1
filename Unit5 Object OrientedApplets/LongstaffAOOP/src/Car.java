/**This program was completed as an ICS4U lab
	*car method
	*demos oop concepts using a car object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/

class Car { 
    // instance variables double
   double  startMiles;  // Stating odometer reading double 
   double  endMiles;   // Ending odometer reading double 
   double  gallons;       // Gallons of gas used between the readings 
    
   // constructor 
    Car( double first, double last, double gals ) {
        startMiles = first ; 
        endMiles = last ; 
        gallons = gals ; 
    }
    
    
    /**calculates miles per gallon
     *@returns miles per gallon
    */
   double calculateMPG() { 
       return (endMiles - startMiles)/gallons ; 
    }

  	/** records thae starting distance on odometer
   *@returns double startMiles
   */
    double startMile(){
       return startMiles;
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
    
   	/** checks if car is a economic
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