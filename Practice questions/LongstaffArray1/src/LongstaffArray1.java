/**This program was completed as an ICS4U lab
 	*@author Alex Longstaff
 	*@Version 2021-02-11
*/
import java.util.Scanner;
public class LongstaffArray1 {
	// declare a global array to be used in all methods
	public static int glblarray[] = new int[10];

	
	
	/**Initializes a public array by setting each component to -1
	 	@param glblarray global array
 		*@returns public variable glblarray and confirmation
 	*/
	static void InitializedArray() {
		for (int i = 0; i < glblarray.length; i++) { // for loop ends at length-1 because index starts at 0 (this is used on all methods)
			glblarray[i] = -1;							 // sets index to -1
		}
		System.out.println("array is initialized");
	}

	
	
	
	/**allows user to enter integers into the global array
	 	*@param glblarray global array
	 	*@param user input to be added to the array
		*@returns global array glblarray and confirmation
	*/
	static void EnterFromKeyboard() {
		Scanner kscanner = new Scanner(System.in); // creates a scanner for user input

		System.out.println("input a number to add it to the array");

		for (int i = 0; i < glblarray.length; i++) { // iterates through a for loop
			
			try {
				int kinput = kscanner.nextInt();
				glblarray[i] = kinput; // sets index to input		
			}catch(Exception e){
				System.out.println("An error occured. Make sure you are only inputing integers");
			} //error handling
		}
		System.out.println("you have filled the array.");
	}

	
	
	
	/**displays the array
		*@param glblarray global array
		*@returns prints the global array glblarray
	*/
	static void DisplayArray() {
		for (int i = 0; i < glblarray.length; i++) {
			System.out.print(glblarray[i] + ",");
		} // iterates through a for loop and displays the index corresponding to that iteration
		System.out.print("\n"); // creates a new line for the next method
	}

	
	

	/** method that displays the sum of the entire global array
	 	*@param glblarray global array
	 	*@returns prints the sum of the components in the global array
	*/
	static void Sum() {
		int sum = 0; // declares a variable
		for (int i = 0; i < glblarray.length; i++) {
			sum += glblarray[i];
		} // iterates through the loop adding the index to the sum

		System.out.println("the sum of the contents of the array is: " + sum); // outputs sum
	}

	
	
	

	/**mehod that displays the average of the entire global array
	 	*@param glblarray global array
 		*@returns prints the sum of the components in the global array divided by the total length of the array
 	*/
	static void Average() {
		int sum = 0; // declares a variable

		for (int i = 0; i < glblarray.length ; i++) {
			sum += glblarray[i];
		} // iterates through the loop adding the index to the sum

		System.out.println("the average of the contents of the array is: " + sum / glblarray.length); // displays the sum divided by the array length to get the average
	}
	
	
	
	
	


	/**method that displays the value of an entered position in the global array
	 	*@param user input to be searched for
	 	*@param glblarray global array
		*@returns prints the index of the param
	*/
	static void Search() {
		Scanner sscanner = new Scanner(System.in); // declares a scanner for user input

		System.out.println("input a number to determine if its within the array:");
		int sinput = sscanner.nextInt();

		for (int i = 0; i < glblarray.length; i++) { // iterates through a for loop
			try {
				if (glblarray[i] == sinput) { // if your input is equal to the index
					System.out.println("the number entered is found in the position: " + i); // outputs position in the array (iteration of the loop)
				}else if(i == glblarray.length -1) {
					System.out.println("search is finished"); 
				}
			}catch(Exception e){
				System.out.println("An error occured. Make sure you are only inputing integers");
				break;
			} //error handling
		}
		
	}

	public static void main(String[] args) {
		Scanner mscanner = new Scanner(System.in);
		
		//displays a menu so the user can know how to call each method
		System.out.println("To Initialize array, enter: 1"); 
		System.out.println("To fill the array with inputs, enter: 2"); 
		System.out.println("To display the array, enter: 3"); 
		System.out.println("To add the contents of the array together, enter: 4"); 
		System.out.println("To calculate the average of the contents of the array, enter: 5"); 
		System.out.println("To search for a specific index in the array, enter: 6"); 
		
		while(true) {
			
			try { 			//late addition. Checks if input is valid
				
			int minput = mscanner.nextInt(); //checks for input
			
			if(minput < 7 && minput > 0){ //determines if input is valid
				
				
				//determines which input the user selected, and activates the corresponding method

				if (minput == 1) {
					InitializedArray();
				}
				if(minput == 2) {
					EnterFromKeyboard();
				}
				if(minput == 3) {
					DisplayArray();
				}
				if(minput == 4) {
					Sum();
				}
				if(minput == 5) {
					Average();
				}
				if(minput == 6) {
					Search();
				}
			}else {
				System.out.println("An error occured. Make sure your input is an option"); 
			}
			
			}catch(Exception e) {     //late addition. Checks if input is valid
				System.out.println("An error occured. Make sure you are only inputing integers"); 
			}
		}
		
	
	}
}
