/**This program was completed as an ICS4U lab
 	*sorting algorithms demo
 	*text based java application that uses methods to sort a 1d array
 	*@author Alex Longstaff
 	*@Version 2021-02-28
**/

import java.util.Scanner;  // Import the Scanner class
public class LongstaffASort {
	public static int glblarray[] = new int[200]; //sets list at 200(relatively arbitrary) and a scanner
	public static Scanner Inscanner = new Scanner(System.in); 	

	/**fills the array with random ints 0-100
 	*@param glblarray global array
	*@returns returns the randomized global array glblarray 
	*/
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
	
	/**Displays a table of times and sorts for 3 sized arrays
 	*@param glblarray global array
	*@returns prints a table of times and sorts for 3 sized arrays
	*/		
	static void DisplayTimes() {
		long TStart;
		long TEnd;

		int[][] timedata = new int[6][3];//creates a 2d array to store the times
		
		for (int i = 0; i < 6; i++) {//iterates through rows
			for (int j = 0; j < 3; j++) {//iterates through columns
				switch(j) {
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
				
				switch(i) {
				case 0://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis(); //sets first time
					BubbleSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (int) (TEnd - TStart);//adds the time to the 2d array
			        System.out.print("Bubble sort Ascending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t");//displays the time and length 
			        break;
				case 1://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					BubbleSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (int) (TEnd - TStart);
			        System.out.print("Bubble sort Descending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t")  ;//displays the time and length
			        break;
				case 2://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					SelectSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (int) (TEnd - TStart);
			        System.out.print("Select sort Ascending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t")  ;//displays the time and length
			        break;
				case 3://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					SelectSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (int) (TEnd - TStart);
			        System.out.print("Select sort Descending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t")  ;//displays the time and length
			        break;
				case 4://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					CombSort_Ascending();//runs the function
					TEnd = System.currentTimeMillis();	//sets second time
					timedata[i][j] = (int) (TEnd - TStart);
			        System.out.print("Comb sort Ascending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t")  ;//displays the time and length
			        break;
				case 5://if its the 1st row time the bubble sort
					TStart = System.currentTimeMillis();//sets first time
					CombSort_Descending();//runs the function
					TEnd = System.currentTimeMillis();//sets second time
					timedata[i][j] = (int) (TEnd - TStart);
			        System.out.print("Comb sort Descending, array size: " + glblarray.length + " takes " + timedata[i][j]  + " miliseconds \t")  ;//displays the time and length
			        break;
				}
			}	
			System.out.println();
		}		
	} 
	
		
		
	public static void main(String[] args) {	
		long TStart;
		long TEnd;
		
		//displays a menu so the user can know how to call each method
		System.out.println("To set the array, enter: 1"); 
		System.out.println("To Bubble Sort Ascending, enter: 2"); 
		System.out.println("To Bubble Sort Descending, enter: 3"); 
		System.out.println("To Select Sort Ascending, enter: 4");
		System.out.println("To Select Sort Descending, enter: 5"); 
		System.out.println("To Select Sort Ascending, enter: 6"); 
		System.out.println("To Select Sort Descending, enter: 7"); 	
		System.out.println("To Display the times of each sort, enter: 8"); 
		while(true) {
			int minput = Inscanner.nextInt();
			try { 			// Checks if input is valid
			if(minput <= 8 && minput >= 1){ //determines if input is valid
				//determines which input the user selected, and activates the corresponding method
				switch(minput) {
				case 1://if input is 1 
					System.out.println("How long do you want the array to be? "); 
					int Rinput = Inscanner.nextInt(); //gets input
					glblarray = new int[Rinput];//reset the array
					RandomizeArray();//runs the randomize function
					System.out.println("done \n");	
					break;
				case 2://if input is 2
					TStart = System.currentTimeMillis();//starts timer
					BubbleSort_Ascending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");
					break;
				case 3://if input is 3
					TStart = System.currentTimeMillis();//starts timer
					BubbleSort_Descending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");
					break;
				case 4://if input is 4
					TStart = System.currentTimeMillis();//starts timer
					SelectSort_Ascending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");	
					break;
				case 5://if input is 5
					TStart = System.currentTimeMillis();//starts timer
					SelectSort_Descending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");	
					break;
				case 6://if input is 6
					TStart = System.currentTimeMillis();//starts timer
					CombSort_Ascending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");	
					break;	
				case 7://if input is 7
					TStart = System.currentTimeMillis();//starts timer
					CombSort_Descending();//runs the randomize function
					TEnd = System.currentTimeMillis();//ends timer
					System.out.println("The selected sort took " + (TEnd - TStart ) + " Mili-seconds for an array length " + glblarray.length );//displays array length and time
					System.out.println("done \n");	
					break;
				case 8://if input is 8
					DisplayTimes();//runs the randomize function
					break;
				}
				
				DisplayArray();
				RandomizeArray();//randomizes the array before the user calls the next one
			}else { System.out.println("An error occured. Make sure your input is an option");  }
			}catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); }
		}
	}
}