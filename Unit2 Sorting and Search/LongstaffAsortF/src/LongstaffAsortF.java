	/**This program was completed as an ICS4U lab
 	*@author Alex Longstaff
 	*@Version 2021-02-11
*/
import java.util.Scanner;
public class LongstaffAsortF {
	// declare a global array to be used in all methods
	public static int glblarray[] = new int[200]; //sets list at 200(relatively arbitrary) and a scanner
	public static Scanner Inscanner = new Scanner(System.in); 	

	static void RandomizeArray() {
		for (int i = 0; i < glblarray.length; i++) {//iterates through the list
		    int randint = (int)(Math.random() * (101));//generates random int
			glblarray[i] = randint;//sets index as int 
		}
	}

	/**Bubble sort algorithm sets array into ascending order
 	*@param glblarray global array
	*@returns the global array in ascending order
	*/
	static void BubbleSort_Ascending(){
		for (int i = 0; i < glblarray.length - 1; i++) {//iterates through the list
			for (int j = 0; j  < (glblarray.length-i)-1; j++ ) {//iterates through possible groups
				if (glblarray[j] > glblarray[j+1]) {//if a swap should occur
					int t1 = glblarray[j];//swap
					int t2 = glblarray[j+1];
					glblarray[j+1] = t1;
					glblarray[j] =t2;
						
				}
			}
		}
	}

	
	
	/**Bubble sort algorithm sets array into descending order
 	*@param glblarray global array
	*@returns the global array in descending order
	*/
	static void BubbleSort_Descending (){
		for (int i = 0; i < glblarray.length - 1; i++) {//iterates through the list
			for (int j = 0; j  < (glblarray.length-i)-1; j++ ) {//iterates through possible groups
				if (glblarray[j] < glblarray[j+1]) {//if a swap should occur
					int t1 = glblarray[j];//swap
					int t2 = glblarray[j+1];
					glblarray[j+1] = t1;
					glblarray[j] =t2;	
				}
			}
		}
	}

	
	
	/**Select sort algorithm sets array into ascending order
 	*@param glblarray global array
	*@returns the global array in ascending order
	*/
	static void SelectSort_Ascending(){		
		for (int i = 0; i < glblarray.length ; i++) {//iterates through the list
			int max = i;//selects the index
			for (int j = i+1; j  < glblarray.length; j++ ) {//iterates through the list
				if (glblarray[j] < glblarray[max]) {//checks if iteration is less than selection
					max = j;//creates new selection
				}
			}
			int t = glblarray[max];//swaps with selection
			glblarray[max] = glblarray[i];
			glblarray[i] =t;
		}
	}	
	
	
	
	/**Select sort algorithm sets array into descending order
 	*@param glblarray global array
	*@returns the global array in descending order
	*/	
	static void SelectSort_Descending (){
		for (int i = 0; i < glblarray.length ; i++) {//iterates through the list
			int max = i;//selects the index
			for (int j = i+1; j  < glblarray.length; j++ ) {//iterates through the list
				if (glblarray[j] > glblarray[max]) {//checks if iteration is less than selection
					max = j;//creates new selection
				}
			}
			int t = glblarray[max];//swaps with selection
			glblarray[max] = glblarray[i];
			glblarray[i] =t;
		}
	}	
		
	
	
	/**Comb sort algorithm sets array into ascending order
 	*@param glblarray global array
	*@returns the global array in ascending order
	*/	
	static void CombSort_Ascending(){		
		int max = glblarray.length;
		int group = max -1;
		boolean done = true;
		while(group >  1 || done == true) {//while the group is >1 so it can acc swap
			group -=1;//reduce group size
			done = false;

			for (int i = 0; i  < max - group; i++ ) {//lets group iterate through the array
				if (glblarray[i] > glblarray[i + group]) { //if a swap should occur
					int t = glblarray[i];//swaps with group
					glblarray[i] = glblarray[i+group];
					glblarray[i+group] = t;
					done = true;
				}
			}
		}
	}	
		
	
	
	/**Comb sort algorithm sets array into descending order
 	*@param glblarray global array
	*@returns the global array in descending order
	*/	
	static void CombSort_Descending(){		
		int max = glblarray.length;
		int group = max -1;
		boolean done = true;
		while(group >  1 || done == true) {//while the group is >1 so it can acc swap
			group -=1;//reduce group size
			done = false;

			for (int i = 0; i  < max - group; i++ ) {//lets group iterate through the array
				if (glblarray[i] < glblarray[i + group]) { //if a swap should occur
					int t = glblarray[i];//swaps with group
					glblarray[i] = glblarray[i+group];
					glblarray[i+group] = t;
					done = true;
				}
			}
		}
	}	
		
	
	/**A menu for running each sorting algorithm separately
 	*@param glblarray global array
	*@returns the global array in The selected order 
	*/	
	static void Sort(){		
		Scanner Sscanner = new Scanner(System.in);
		//displays a menu so the user can know how to call each method
		System.out.println("NOTE: You may want to randomise the array after sortting the array"); 
		System.out.println("To Bubble Sort Ascending, enter: 1"); 
		System.out.println("To Bubble Sort Descending, enter: 2"); 
		System.out.println("To Select Sort Ascending, enter: 3");
		System.out.println("To Select Sort Descending, enter: 4"); 
		System.out.println("To Select Sort Ascending, enter: 5"); 
		System.out.println("To Select Sort Descending, enter: 6"); 	
		try { 			//Checks if input is valid
			
		int Sinput = Sscanner.nextInt(); //checks for input
		
		if(Sinput < 7 && Sinput > 0){ //determines if input is valid
		
	
		switch(Sinput) { //this switch runs each program and times each one
		case 1://if its the 1st row time the bubble sort
			BubbleSort_Ascending();//runs the function
	        break;
		case 2://if its the 1st row time the bubble sort
			BubbleSort_Descending();//runs the function
	        break;
		case 3://if its the 1st row time the bubble sort
			SelectSort_Ascending();//runs the function
	        break;
		case 4://if its the 1st row time the bubble sort
			SelectSort_Descending();//runs the function
	        break;
		case 5://if its the 1st row time the bubble sort
			CombSort_Ascending();//runs the function
	        break;
		case 6://if its the 1st row time the bubble sort
			CombSort_Descending();//runs the function
	        break;
		}
		System.out.println("The array is sorted: "); 
		DisplayArray();
		}else {System.out.println("An error occured. Make sure your input is an option"); }
		}catch(Exception e) {System.out.println("2An error occured. Make sure you are only inputing integers"); }
			
	}	
	
	
	
	/**Displays a table of times and sorts for 3 sized arrays
 	*@param glblarray global array
	*@returns prints a table of times and sorts for 3 sized arrays
	*/		
	static void DisplayTimes() {
		long TStart;
		long TEnd;

		Double[][] timedata = new Double[6][3];//creates a 2d array to store the times
		for (int i = 0; i < 6; i++) {//iterates through rows
			for (int j = 0; j < 3; j++) {//iterates through columns
				
				
				switch(j) {//this switch checks each column, so it can reset then randomize the array each time. 
				case 0://if its the first column make the list 200
					glblarray = new int[200];
					RandomizeArray();
					break;
				case 1://if its the second column make the list 1000
					glblarray = new int[1000];
					RandomizeArray();
					break;
				case 2://if its the third column make the list 10000
					glblarray = new int[10000];
					RandomizeArray();	
					break;
				}
				
				switch(i) { //this switch runs each program and times each one
				case 0://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis(); //sets first time
					BubbleSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				case 1://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					BubbleSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				case 2://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					SelectSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				case 3://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					SelectSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				case 4://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					CombSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				case 5://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					CombSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();//sets second time
					timedata[i][j] = (double) (TEnd - TStart);
			        break;
				}	
			}			
		}	
		
		
		System.out.println("Each program took:");
		for(int i=0; i<timedata.length; i++) { //iterates through rows
			switch(i) { //this switch labels each row
			case 0:
				System.out.print("BubbleSort_Ascending \t");break;
			case 1:
				System.out.print("BubbleSort_Descending \t");break;
			case 2:
				System.out.print("SelectSort_Ascending \t");break;
			case 3:
				System.out.print("SelectSort_Descending \t");break;
			case 4:
				System.out.print("CombSort_Ascending \t");break;
			case 5:
				System.out.print("CombSort_Descending \t");break;
			}
			
	       for(int j=0; j<timedata[i].length; j++) { //iterates through columns
	           System.out.print(timedata[i][j] + "ms  ");
	       }
           System.out.println();
		}
		
		
		
		
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**Prints the entire array in a simple way 
 	*@param glblarray global array
	*@returns prints the global array glblarray to console in a long simple list
	*/		
	static void DisplayArray() {
		System.out.println("\n the array is: ");

		for (int i = 0; i < glblarray.length; i++) {//iterates through the array
			System.out.print(glblarray[i] + ",");//prints the index
			
		} // iterates through a for loop and displays the index corresponding to that iteration
		System.out.print("\n"); // creates a new line for the next method
	}
	
	
	
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

	
	
	/**method that displays the average of the entire global array
	 	*@param glblarray global array
 		*@returns prints the sum of the components in the global array divided by the total length of the array
 	*/
	static void Average() {
		int sum = 0; // declares a variable

		for (int i = 0; i < glblarray.length ; i++) {
			sum += glblarray[i];
		} // iterates through the loop adding the index to the sum
		int avg = sum / glblarray.length;
		System.out.println("the average of the contents of the array is: " + avg ); // displays the sum divided by the array length to get the average
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
		System.out.println("To randomize the array, enter: 3"); 
		System.out.println("To display the array, enter: 4"); 
		System.out.println("To add the contents of the array together, enter: 5"); 
		System.out.println("To calculate the average of the contents of the array, enter: 6"); 
		System.out.println("To search for a specific index in the array, enter: 7"); 
		System.out.println("To Sort using a specific algorithm, enter: 8"); 
		System.out.println("To Get time data for each sort enter: 9"); 
		while(true) {
			try { 			//Checks if input is valid	
			int minput = mscanner.nextInt(); //checks for input
	
			if(minput < 10 && minput > 0){ //determines if input is valid 
				//determines which input the user selected, and activates the corresponding method
			switch(minput){
				case 1:
					InitializedArray();break;
				case 2:
					EnterFromKeyboard();break;	
				case 3:
					RandomizeArray();break;
				case 4:
					DisplayArray();break;
				case 5:
					Sum();break;
				case 6:
					Average();break;
				case 7:
					Search();break;
				case 8:
					Sort();break;
				case 9:
					DisplayTimes();break;
				}
			}else {System.out.println("An error occured. Make sure your input is an option");}
			}catch(Exception e) { System.out.println("An error occured. Make sure you are only inputing integers"); }
		}
		
	
	}
}