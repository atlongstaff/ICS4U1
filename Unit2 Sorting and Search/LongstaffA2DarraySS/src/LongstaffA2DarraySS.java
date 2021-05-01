/**This program was completed as an ICS4U lab
	*2d arrays with Sorts and Searches
	*text based java application that uses methods to manipulate a 2d array
	*@author Alex Longstaff
	*@Version 2021-02-17
*/
import java.util.Random;
import java.util.Scanner;
public class LongstaffA2DarraySS {
public static String[][] glblarray  = new String[6][4];;

public static Scanner Inscanner = new Scanner(System.in); 	
public static String sort; 	

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
    Scanner Rscanner = new Scanner(System.in); 	
    int numstudents = Rscanner.nextInt();
    
    
    
	glblarray = new String[numstudents][4];	//resets array size
    
    
			//calls for new info because array is now empty
}

/**fills the array with random info from a list 
	*@param glblarray global array
*@returns returns the randomized global array glblarray 
*/
static void Randomizearray() {
	for (int row = 0; row < glblarray.length; row++){//for loop to iterate through the rows(students)
		for (int column = 0; column < glblarray[row].length; column++){//for loop to iterate through the columns				
		   Random r = new Random();
		   String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			switch(column) {
			case 0://if the column is 0 r		
			    double randiddb = Math.random() * (2) +1; //generate a random decimal
			    randiddb *= 1000000000; //make that decimal a 10 digit integer
			    int randidint = (int) randiddb;
				glblarray[row][column] = String.valueOf(randidint);//add it to the array
				break;
				
			case 1:
			      String name = "";
			      for (int i = 0; i < 10; i++) {
			          name += alphabet.charAt(r.nextInt(alphabet.length()));
			      }
			      glblarray[row][column] = String.valueOf(name);	//add a name to the array				
				break;
				
			case 2:

			      String Lname = "";
			      for (int i = 0; i < 10; i++) {
			          Lname += alphabet.charAt(r.nextInt(alphabet.length()));
			      }
			      glblarray[row][column] = String.valueOf(Lname);	//add a name to the array				
				break;
				
			case 3:
			    int randomgrd = (int)(Math.random() * (101));//generate a random integer
				glblarray[row][column] = String.valueOf(randomgrd);	//add the integer to the array
				break;
			}
		
			
	   }
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
				System.out.println("grade: " + glblarray[i][j] + "\n");
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








/**Select sort algorithm sets array into ascending order
	*@param glblarray global array
*@returns the global array in ascending order
*/
static void SelectionSort(){		
	System.out.println("what would you like to sort by?");
	System.out.println("Enter 0 to sort by student number.");
	System.out.println("Enter 1 to sort by First Name.");
	System.out.println("Enter 2 to sort by Last Name.");
	System.out.println("Enter 3 to sort by Grade.");
	int selectedcolumn =  Integer.valueOf(Inscanner.nextLine());
	
	if(selectedcolumn <= 3 && selectedcolumn >= 0){
		sort = "Sorted";
	}else {
		System.out.println("An error occured. Make sure your input is an option"); 
		return;
	}
			
	
	
	
	
	
	for (int row = 0; row < glblarray.length-1; row++){//iterates through a row
		int selection = row;//selects the index

		for (int rowL = row+1; rowL < glblarray.length; rowL++){//iterates through a row

			if (glblarray[rowL][selectedcolumn].compareTo(glblarray[selection][selectedcolumn]) < 0) {//checks if iteration is less than selection
					selection = rowL;//creates new selection
			}
		}
		String[] t = glblarray[selection];				//swaps with selection
		glblarray[selection] = glblarray[row];
		glblarray[row] = t;
		

		}	
	}
	





	
/**Select sort algorithm sets array into ascending order
*@param glblarray global array
*@returns the global array in ascending order
*/
static void BinarySearch(){		
	System.out.println("What are you searching for");
    Scanner Bscanner = new Scanner(System.in); 	

	int selectedcolumn =  Integer.valueOf( Bscanner.nextLine());
	System.out.println("Guess:");

	String search = Bscanner.nextLine();

	int EndLength = glblarray.length -1;
	int StartLength = 0;
	int guess = (EndLength - StartLength) / 2; //make a guess(half of bounds)
	String guessValue = glblarray[guess][selectedcolumn];
	
	if(sort == "Sorted") {
		while(StartLength < EndLength) {
			
			
			if(glblarray[guess][selectedcolumn].compareTo(search) == 0) { //if the guess is correct The following code runs.
				
				
				System.out.println("your search is in position: " + guess); //display the guess
				//bounds for the two loops used
				boolean downDone = false;
				boolean upDone = false;
		
				int i = guess -1; //checks if the lower index is the same
				while (!downDone) {
					if (i >= 0 && glblarray[i][selectedcolumn] == guessValue) {//checks if the lower index is the same
						System.out.println("your integer is in position: " + i); //prints the position
						i -= 1; //checks the next one
					}else { //if its not the same
						downDone = true; //stop checking below
						break;
					}
				}
		
		
				i = guess + 1;//checks if the above index is the same
				while (!upDone) {
					if (i <= glblarray.length && glblarray[i][selectedcolumn] == guessValue) {//checks if the higher index is the same
						System.out.println("your integer is in position: " + i);//prints the position
						i += 1;//checks the next one
					}else { //if its not the same
						downDone = true;//stop checking below
						break;
					}
				}
				break;
	
			}else if (glblarray[guess][selectedcolumn].compareTo(search) > 0) { //if the guess is bigger than the integer we are searching for
				EndLength = guess - 1;	//set the guess as the upper bound
				guess = (EndLength - StartLength) / 2; //set the guess to the middle of the bounds
				continue;
			
			}else if (glblarray[guess][selectedcolumn].compareTo(search) < 0){ //if the guess is smaller than the integer we are searching for
				StartLength = guess + 1;//set the guess as the lower bound
				guess = (EndLength + StartLength) / 2; //set the guess to the middle of the bounds
				continue; 
			}

			if (StartLength > EndLength) { //if the bounds move over each other
				System.out.println("no result found"); //then the integer is not in the array
				break;
			}
		}
	}else {
		System.out.println("The array is not sorted for the selected column. Please re-sort and try again later");
	}
 }








public static void main(String[] args) {
	//displays a menu so the user can know how to call each method
	System.out.println("To Enter information, enter: 1"); 
	System.out.println("To randomize the array, enter: 2"); 
	System.out.println("To resize the array, enter: 3"); 
	System.out.println("To display the data in the array, enter: 4"); 
	System.out.println("To display the highest grade, enter: 5"); 
	System.out.println("To display the lowest grade, enter: 6"); 
	System.out.println("To display the class average grade, enter: 7");
	System.out.println("To Sort the array, enter: 8");
	System.out.println("To Binary Search the array, enter: 9");

	while(true) {
	

		try { 			//late addition. Checks if input is valid
			String minput = Inscanner.nextLine(); //checks for input
		if(Integer.valueOf(minput) <= 9 && Integer.valueOf(minput) >= 1){ //determines if input is valid
			//determines which input the user selected, and activates the corresponding method
			int mintinput = Integer.parseInt(minput);
			switch(mintinput) {
			
			case 1:
				Enterinfo();
				System.out.println("done \n");	
				break;
			case 2:
				Randomizearray();
				System.out.println("done \n");	
				break;
			case 3:
				Resizearray();
				System.out.println("done \n");	
				break;
			case 4:
				Displayinfo();
				System.out.println("done \n");	
				break;
			case 5:
				Displaymax();
				System.out.println("done \n");	
				break;
			case 6:
				Displaymin();
				System.out.println("done \n");	
				break;
			case 7:
				Displayaverage();
				System.out.println("done \n");	
				break;
			case 8:
				long start_time_Sort = System.currentTimeMillis();
				SelectionSort();
				long end_time_Sort  = System.currentTimeMillis();
				long difference_Sort  = end_time_Sort -start_time_Sort ;
				System.out.printf("Finished after %d ms \n" , difference_Sort);	
				break;
			case 9:
				long start_time_search = System.currentTimeMillis();
				BinarySearch();
				long end_time_search = System.currentTimeMillis();
				long difference_search = end_time_search-start_time_search;
				System.out.printf("Finished after %d ms \n" , difference_search);	
				break;
			}
		}else { System.out.println("An error occured. Make sure your input is an option");  }
		}catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); }

	}
}
}
