import java.util.Scanner;

public class LongstaffASearch {
	//sets list at 200(relatively arbitrary) and a scanner
	public static int glblarray[] = new int[200]; 
	public static Scanner Inscanner = new Scanner(System.in); 	
	public static boolean sorted = false;
	
	/**Prints An error
 	*@param bounds bounds variable used to determine which error message to display. Its not boolean so I can expand it in the future
	*@returns The given error message
	*/		
	static void Texterror(int bounds) {
		switch(bounds) {
		case 0:
			System.out.println("An error occured. Make sure you are within the requested bounds");
			break;
		case 1:
			System.out.println("An error occured. Please reset the program \n and make sure you are only inputing integers");
			break;
		}
		
	}
	
	/**Randomizes the array
 	*@param glblarray global array
	*@returns sets every index in the array to a random integer between 0 and 100
	*/		
	static void RandomizeArray() {
		for (int i = 0; i < glblarray.length; i++) {//iterates through the list
		    int randint = (int)(Math.random() * (101));//generates random int
			glblarray[i] = randint;//sets index as int 
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
		System.out.println("input a number to add it to the array");
		for (int i = 0; i < glblarray.length; i++) { // iterates through a for loop
			
			try {
				int kinput = Inscanner.nextInt();
				glblarray[i] = kinput; // sets index to input
			}catch(Exception e){Texterror(1);} //error handling
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
					sorted = true;
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
			sorted = true;
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
					sorted = true;
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
	static void SortMenu(){		
		//displays a menu so the user can know how to call each method
		System.out.println("NOTE: You may want to randomise the array after sortting the array"); 
		System.out.println("To Bubble Sort Ascending, enter: 1"); 
		System.out.println("To Bubble Sort Descending, enter: 2"); 
		System.out.println("To Select Sort Ascending, enter: 3");
		System.out.println("To Select Sort Descending, enter: 4"); 
		System.out.println("To Comb Sort Ascending, enter: 5"); 
		System.out.println("To Comb Sort Descending, enter: 6"); 	
		try { 			//Checks if input is valid
			
		int Sinput = Inscanner.nextInt(); //checks for input
		
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
		}else {Texterror(0);}
		}catch(Exception e) {Texterror(1);}
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**A Binary search algorithm that finds the index of a given input
 	*@param glblarray global array 
 	*@param search is the inputed value that i am searching for
	*@returns prints the indexes that the search is found in, and the time it takes to run the algo
	*/	
	static void BinarySearch(int search) {
		//defining important variables
		int EndLength = glblarray.length -1;
		int StartLength = 0;
		int guess = (EndLength - StartLength) / 2; //make a guess(half of bounds)
		
		while(StartLength < EndLength) {//if the start is bigger than the end the search found no results. So the while loop works
			
			
			
			
			if(glblarray[guess]== search) { //if the guess is correct The following code runs.
				System.out.println("your integer is in position: " + guess); //display the guess
				//bounds for the two loops used
				boolean downDone = false;
				boolean upDone = false;
				
				int i = guess -1; //checks if the lower index is the same
				while (!downDone) {
					if (i >= 0 && glblarray[i] == glblarray[guess]) {//checks if the lower index is the same
						System.out.println("your integer is in position: " + i); //prints the position
						i -= 1; //checks the next one
					}else { //if its not the same
						downDone = true; //stop checking below
						break;
					}
				}
				
				
				i = guess + 1;//checks if the above index is the same
				while (!upDone) {
					if (i <= glblarray.length && glblarray[i ] == glblarray[guess]) {//checks if the higher index is the same
						System.out.println("your integer is in position: " + i);//prints the position
						i += 1;//checks the next one
					}else { //if its not the same
						downDone = true;//stop checking below
						break;
					}
				}
				break;
				
				
				
				
				
				
			}else if (glblarray[guess] > search) { //if the guess is bigger than the integer we are searching for
				EndLength = guess - 1;	//set the guess as the upper bound
				guess = (EndLength - StartLength) / 2; //set the guess to the middle of the bounds

				
				
				
			}else if (glblarray[guess] < search){ //if the guess is smaller than the integer we are searching for
				StartLength = guess + 1;//set the guess as the lower bound
				guess = (EndLength + StartLength) / 2; //set the guess to the middle of the bounds

			}

			if (StartLength > EndLength) { //if the bounds move over each other
				System.out.println("no result found"); //then the integer is not in the array
				break;
			}
		}
	}
	
	/**A Linear search algorithm that finds the index of a given input
 	*@param glblarray global array 
 	*@param search is the inputed value that i am searching for
 	*@param LSInput decides if the search is ascending or descending
	*@returns prints the indexes that the search is found in, and the time it takes to run the algo
	*/	
	static void LinearSearch(int search, int LSInput) {
		switch(LSInput) { //checks if the user wants it to be ascending or descending
		case 1:
			for (int i = 0; i < glblarray.length; i++) { //iterates through list
				if (glblarray[i] == search) {//checks if they are equal
					System.out.println("your integer is in position: " + i); 
					
				}else if(i == glblarray.length -1) {System.out.println("search is finished"); } //prints done
			}	
			break;
		case 2:
			for (int i = glblarray.length-1; i >= 0; i--) { //iterates through list
				if (glblarray[i] == search) {//checks if they are equal
					System.out.println("your integer is in position: " + i); 
				}else if(i == 0) {System.out.println("search is finished"); } //prints done
			}
			break;
		}

	}
	
	/**A menu for selecting which search algo you want
 	*@param glblarray global array
	*@returns prints the indexes that the search is found in, and the time it takes to run the algo
	*/		
	static void SearchMenu() {
		System.out.println("To prform a binary search, enter: 1"); 
		System.out.println("To prform a linear search, enter: 2"); 
		try { 			//Checks if input is valid	
			int Seinput = Inscanner.nextInt(); //checks for input
		
			double TStart = 0;
			double TEnd = 0;
			if(Seinput < 3 && Seinput > 0){ //determines if input is valid 
				
				System.out.println("Enter the integer you would like to search for:");	
				int search = Inscanner.nextInt();
				switch(Seinput){ //checks which algo they would like to use
					case 1:
						if(sorted == true) {
							TStart = System.currentTimeMillis();//sets first time
							BinarySearch(search);
							TEnd = System.currentTimeMillis();//sets last time
							break;
						}else {
							System.out.println("You have not sorted the array yet. To run a binary sort please sort the array in ascending order");
							break;
						}
					case 2:
						System.out.println("Enter 1 for a ascending search or 2 for a desending search");	
						int LSInput = Inscanner.nextInt();
						if(LSInput < 3 && LSInput > 0) { //checks if input is within bounds
							TStart = System.currentTimeMillis();//sets first time
							LinearSearch(search, LSInput);
							TEnd = System.currentTimeMillis();//sets last time
						}else {
							Texterror(0); //runs error
						}
						break;	
				}
				double Time = TEnd - TStart;
				System.out.printf("The Search took %s ms %n", Time );	
				
			}else {Texterror(0);}//runs error
		}catch(Exception e) { Texterror(1); }//runs error

	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public static void main(String[] args) {
		
		//displays a menu so the user can know how to call each method
		System.out.println("To Initialize array, enter: 1"); 
		System.out.println("To fill the array with inputs, enter: 2"); 
		System.out.println("To randomize the array, enter: 3"); 
		System.out.println("To display the array, enter: 4"); 
		System.out.println("To add the contents of the array together, enter: 5"); 
		System.out.println("To calculate the average of the contents of the array, enter: 6"); 
		System.out.println("To Sort using a specific algorithm, enter: 7"); 
		System.out.println("To Get time data for each sort enter: 8"); 
		System.out.println("To search for a specific index in the array, enter: 9"); 

		while(true) {
			try { 					//Checks if input is valid
			int minput = Inscanner.nextInt(); //checks for input
			int arrlen;
			if(minput < 10 && minput > 0){ //determines if input is valid 
				//determines which input the user selected, and activates the corresponding method
			switch(minput){
				case 1:
					System.out.println("How Long would you like the array to be?");
					arrlen = Inscanner.nextInt();
					glblarray = new int[arrlen];
					
					InitializedArray();break;
				case 2:
					System.out.println("How Long would you like the array to be?");
					arrlen = Inscanner.nextInt();
					glblarray = new int[arrlen];

					EnterFromKeyboard();break;	
				case 3:
					System.out.println("How Long would you like the array to be?");
					arrlen = Inscanner.nextInt();
					glblarray = new int[arrlen];

					RandomizeArray();
					System.out.println("array is randomized");
					break;
				case 4:
					DisplayArray();break;
				case 5:
					Sum();break;
				case 6:
					Average();break;
				case 7:
					SortMenu();break;
				case 8:
					DisplayTimes();break;
				case 9:
					SearchMenu();break;
				}
			}else {Texterror(0);}
			}catch(Exception e) { Texterror(1); break;}
		}
	}
}
