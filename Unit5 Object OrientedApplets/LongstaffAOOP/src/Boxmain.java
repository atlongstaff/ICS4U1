/**This program was completed as an ICS4U lab
	*BoxProgram Main
	*demos oop concepts using a box object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/

import java.util.Scanner;

public class Boxmain {

	public static void main( String[] args ) {
		
		//creates a basic menu
		Scanner s = new Scanner(System.in);
		
    	System.out.println("Input the length:"); 
		double length = s.nextDouble();
    	
    	System.out.println("Input the width:"); 
		double width = s.nextDouble();
		
    	System.out.println("Input the height:"); 
		double height = s.nextDouble();
		
		Box Box = new Box(length,width,height); 
		
		
		//displays info
    	System.out.println("The volume is: " + Box.volume() + " units cubed"); 
    	System.out.println("The surface area is: " + Box.surfacearea() + " units squared"); 
		
	}
}

