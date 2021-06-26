/**This program was completed as an ICS4U lab
	*Employee tester
	*demos oop concepts using an employee object
	*@author Alex Longstaff
	*@Version 2021-05-13
*/
import java.util.Arrays;
public class EmployeeList {
	public static void main ( String[] args ){
		   //Create an array of 18 employees
		Employee[] workers = new Employee[18];
	    
		workers[0] =  new Employee( "James", "Smith", 3 );
		workers[1] =  new Employee( "James",  "Smith", 4 );
		workers[2] =  new Employee( "John", "Williams", 1 );
		workers[3] =  new Employee( "Michael", "Brown", 1 );
		workers[4] =  new Employee( "William", "Jones", 5 );
		workers[5] =  new Employee( "Richard", "Garcia", 4 );
		workers[6] =  new Employee( "David", "Garcia", 3 );
		workers[7] =  new Employee( "Joseph", "Davis", 4 );
		workers[8] =  new Employee( "Thomas", "Rodriguez", 3 );
		workers[9] =  new Employee( "Charles", "Rodriguez", 3 );
		workers[10] =  new Employee( "Christopher",  "Rodriguez", 4 );
		workers[11] =  new Employee( "Daniel", "Lopez", 1 );
		workers[12] =  new Employee( "Matthew", "Gonzalez", 1 );
		workers[13] =  new Employee( "Anthony", "Wilson", 5 );
		workers[14] =  new Employee( "Mark", "Anderson", 4 );
		workers[15] =  new Employee( "Donald", "Thomas", 3 );
		workers[16] =  new Employee( "Steven", "Taylor", 4 );
		workers[17] =  new Employee( "Paul", "Moore", 3 );
		
		   //Assign data for the 18 employees 
		 

		    //Sort the array 
		    Arrays.sort( workers);
		    
		    for ( int j=0; j<workers.length; j++ )
		    	
		      System.out.println(workers[j]);     
		  } 

}
