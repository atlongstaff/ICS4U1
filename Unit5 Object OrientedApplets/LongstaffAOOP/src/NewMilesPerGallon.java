/**This program was completed as an ICS4U lab
	*car method
	*demos oop concepts using a car object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/
public class NewMilesPerGallon {

	public static void main( String[] args ) { 
		
		
		//set the original odometer to 0 
		double  odoreading = 0;  // odometer reading double 
		System.out.println("new car odometer reading: 0 \n"); 
		
		newCar newCar = new newCar(odoreading); 
		odoreading = newCar.newodoreading();  // odometer reading double 
		
		
		do {//while loop

	    newCar.fillup();//call fillup 

		
	    System.out.println( "Miles per gallon is " + newCar.calculateMPG() ); 
	    
	    //call boolean objects and print message
	    if (newCar.gasHog() == true) {
	    	System.out.println( "Gas Hog! \n\n" ); 
	    } else if(newCar.economyCar() == true) {
	    	System.out.println( "Economy Car! \n\n"  ); 
	    }	  
	    
	    
	    
	    
	    odoreading = newCar.newodoreading();  // odometer reading double 
		newCar = new newCar(odoreading); 
		

	    newCar.fillup();//call fillup

		
	    System.out.println( "Miles per gallon is " + newCar.calculateMPG() ); 
	  //call boolean objects and print message
	    if (newCar.gasHog() == true) {
	    	System.out.println( "Gas Hog! \n\n" ); 
	    } else if(newCar.economyCar() == true) {
	    	System.out.println( "Economy Car! \n\n"  ); 
	    }	   
	    
	    
		}while(true);
	}

}



