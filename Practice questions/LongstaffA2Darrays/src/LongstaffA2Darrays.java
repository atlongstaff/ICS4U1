/**This program was completed as an ICS4U lab
 	*2d arrays
 	*text based java application that uses methods to manipulate a 2d array
 	*@author Alex Longstaff
 	*@Version 2021-02-17
*/
import java.util.Scanner;
public class LongstaffA2Darrays {
	public static String[][] glblarray  = new String[6][4];;

	public static Scanner Inscanner = new Scanner(System.in); 	
	
	/**allows user to enter strings into the global array
 	*@param glblarray global array
 	*@param user input to be added to the array
	*@returns global array glblarray, confirmation, and prompts to data
	*/
	static void Enterinfo() {
		for (int row = 0; row < glblarray.length; row++){//for loop to iterate through the rows(students)
			for (int column = 0; column < glblarray[row].length; column++){//for loop to iterate through the columns
		        System.out.println("filling out info for student: " + (row + 1)); //outputs the row so the user knows which substance to select
		       
				switch(column) {

		        
				case 0:		//if the column is 0 ie your inputing the student number		
					while(glblarray[row][column] == null  || glblarray[row][column] == "") {	//to make sure that there has actually been an input
						System.out.println("Input student id");
						String Numinput = Inscanner.nextLine();

						if (Numinput != "") {//ensures theres no empty input, which occurs when resize occurs

						//converts to integer in order to check if its valid
						try {Long.parseLong(Numinput); }catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); }//check if its valid
						
						if(Numinput.length() == 10){ //checks to make sure the user input is 10 digits long

							glblarray[row][column] =  Numinput;
						}else{System.out.println("Student number not 10 digits long");}
						
						}
					}
										
		
					
				case 1://if the column is 1 ie your inputing the students name
					while(glblarray[row][column] == null  || glblarray[row][column] == "") {	//to make sure that there has actually been an input

						System.out.println("Input students first name");
																	//no error handling needed because there's no limits to what a name can be... Can be anylength, have symbols, even numbers....
						String Nameinput = Inscanner.nextLine();
						glblarray[row][column] =  Nameinput; 

					}
					
					
					
				case 2: //if the column is 2 ie your inputing the students last name
					while(glblarray[row][column] == null || glblarray[row][column] == "") {//to make sure that there has actually been an input

						System.out.println("Input students last name");
																	//no error handling needed because there's no limits to what a name can be... Can be anylength, have symbols, even numbers....
						String Nameinput = Inscanner.nextLine();
						glblarray[row][column] =  Nameinput;

					}
					
					
					
				case 3:		//if the column is 3 ie your inputing the students grade
					while(glblarray[row][column] == null || glblarray[row][column] == "") {//to make sure that there has actually been an input

						System.out.println("Input students grade");
						String Gradeinput = Inscanner.nextLine();
					
						try {
							int Intinput = Integer.parseInt(Gradeinput); //converts string to integer
							
							if(Intinput >= 0 && Intinput <= 100){  		 //ensures integer is between 0 and 100
								glblarray[row][column] =  Gradeinput;
						
							}else{System.out.println("Grade not within range");}
						}catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); } //an error will occur because a letter wont convert to int
					}
				}
	
				
		   }
		}
	}
	
	/**allows user to change the number of rows in the global array, then calls for new information
 	*@param glblarray global array
 	*@param user input to change the size of the array
	*@returns global array glblarray, prompt to enter information
	*/
	static void Resizearray() {
        System.out.println("please enter the number of students in your class: "); //prompts info
        int numstudents = Inscanner.nextInt();
		glblarray = new String[numstudents][4];	//resets array size
        System.out.println("please enter the information for your new class size: ");
        
        
		Enterinfo();		//calls for new info because array is now empty
	}
	
	/**fills the array with random info from a list 
 	*@param glblarray global array
	*@returns returns the randomized global array glblarray 
	*/
	static void Randomizearray() {
		for (int row = 0; row < glblarray.length; row++){//for loop to iterate through the rows(students)
			for (int column = 0; column < glblarray[row].length; column++){//for loop to iterate through the columns				
			     
				switch(column) {
				case 0://if the column is 0 r		
				    double randiddb = Math.random() * (2) +1; //generate a random decimal
				    randiddb *= 1000000000; //make that decimal a 10 digit integer
				    int randidint = (int) randiddb;
					glblarray[row][column] = String.valueOf(randidint);//add it to the array
					break;
					
				case 1:
				      int randomnm = (int)(Math.random() * (6));//generate a random integer
				      String[] names = {"Alex", "John", "rick", "jimmy", "dwight", "michael"}; //generate a list of names
				      glblarray[row][column] = String.valueOf(names[randomnm]);	//add a name to the array				
					break;
					
				case 2:
				      int randomlnm = (int)(Math.random() * (6));//generate a random integer
				      String[] lastnames = {"longstaff", "cena", "astley", "woo", "schrute", "scott"};//generate a list of names
				      glblarray[row][column] = String.valueOf(lastnames[randomlnm]);	//add a name to the array							
					break;
					
				case 3:
				    int randomgrd = (int)(Math.random() * (101));//generate a random integer
					glblarray[row][column] = String.valueOf(randomgrd);	//add the integer to the array
					break;
				}
			
				
		   }
			System.out.println();		
		}
	}

	/**Prints the entire table in a simple way 
 	*@param glblarray global array
	*@returns prints the global array glblarray to console in an organized way 
	*/
	static void Displayinfo() {
		for (int i = 0; i < glblarray.length; i++){
			for (int j = 0; j < glblarray[i].length; j++){
				switch(j) {
				case 0:
					System.out.println("Student number: " + glblarray[i][j]);
					break;
				case 1:
					System.out.println("First name: " + glblarray[i][j]);
					break;
				case 2:
					System.out.println("Last name: " + glblarray[i][j]);
					break;
				case 3:
					System.out.println("grade: :" + glblarray[i][j] + "\n");
					break;
				}
		   }
		}
	}	
	
	/**prints the maximum value of the last column of the array
 	*@param glblarray global array
	*@returns the highest integer of the last column of the global array 
	*/
	static void Displaymax() {
		int max = 0;
		for (int i = 0; i < glblarray.length; i++){ //iterates through rows
			for (int j = 0; j < glblarray[i].length; j++) {//iterates through columns
				if (j == glblarray[i].length -1) { //checks if at last column
					int mark = Integer.parseInt(glblarray[i][j]);
					if(max <= mark) {max = mark;}//checks if the current mark is greater than the previous set mark					
				}	
		   }
		}
		System.out.println("the highest mark is: " + max );	
	}	
	
	/**prints the minimum value of the last column of the array
 	*@param glblarray global array
	*@returns prints the lowest integer of the last column of the global array 
	*/
	static void Displaymin() {
		int min = 100;
		for (int i = 0; i < glblarray.length; i++) {//iterates through rows
			for (int j = 0; j < glblarray[i].length; j++) {//iterates through columns
				if (j == glblarray[i].length -1) {//checks if at last column
					int mark = Integer.parseInt(glblarray[i][j]);
					if(mark <= min) {min = mark;}				//checks if the current mark is less than the previous set mark					
				}		
			}	
		}
		System.out.println("the lowest mark is:" + min);	
	}	
	
	/**prints the average value of the last column of the array
 	*@param glblarray global array
	*@returns prints the sum of the integers divided by the number of rows of the last column of the global array 
	*/
	static void Displayaverage() {
		int sum = 0;
		for (int i = 0; i < glblarray.length; i++){//iterates through a row
			for (int j = 0; j < glblarray[i].length; j++) {//iterates through a column
				if (j == glblarray[i].length -1) {
					sum += Integer.parseInt(glblarray[i][j]); //adds the current mark to the sum
				}	
		   }
		}
		System.out.printf("the average mark is: %d", sum / glblarray.length);	
		System.out.println();	
	}
	
	
	public static void main(String[] args) {
		while(true) {
			//displays a menu so the user can know how to call each method
			System.out.println("To Enter information, enter: 1"); 
			System.out.println("To randomize the array, enter: 2"); 
			System.out.println("To resize the array, enter: 3"); 
			System.out.println("To display the data in the array, enter: 4"); 
			System.out.println("To display the highest grade, enter: 5"); 
			System.out.println("To display the lowest grade, enter: 6"); 
			System.out.println("To display the class average grade, enter: 7");
				

			try { 			//late addition. Checks if input is valid
				String minput = Inscanner.nextLine(); //checks for input
			if(Integer.parseInt(minput) <= 7 && Integer.parseInt(minput) >= 1){ //determines if input is valid
				//determines which input the user selected, and activates the corresponding method
				int mintinput = Integer.parseInt(minput);
				switch(mintinput) {
				
				case 1:
					Enterinfo();
					System.out.println("done \n\n\n");	
					break;
				case 2:
					Randomizearray();
					System.out.println("done \n\n\n");	
					break;
				case 3:
					Resizearray();
					System.out.println("done \n\n\n");	
					break;
				case 4:
					Displayinfo();
					System.out.println("done \n\n\n");	
					break;
				case 5:
					Displaymax();
					System.out.println("done \n\n\n");	
					break;
				case 6:
					Displaymin();
					System.out.println("done \n\n\n");	
					break;
				case 7:
					Displayaverage();
					System.out.println("done \n\n\n");	
					break;
				}
			}else { System.out.println("An error occured. Make sure your input is an option");  }
			}catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); }

		}
	}
}
