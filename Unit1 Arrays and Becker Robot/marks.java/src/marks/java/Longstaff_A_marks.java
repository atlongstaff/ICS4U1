package marks.java;
import java.util.Scanner;

/**This program was completed as an ICS4U exam
	*2d arrays with Sorts and Searches
	*text based java application that uses methods to manipulate a 2d array
	*@author Alex Longstaff
	*@Version 2021-03-23
*/
import java.util.Scanner;

public class Longstaff_A_marks {


	public static Scanner Inscanner = new Scanner(System.in); 	
	public static Boolean sorted = false;

		
	
	
	// write a method that will determine the amount of passing students
	// APP 4 COM 2
	private static void passing(String[][] marks) {
		int passing = 0;
			for(int row=0; row<marks.length; row++) {
				int grade = Integer.parseInt(marks[row][1]);
				if (grade >= 50) {
					passing ++;
				}
			}
		System.out.println(passing + " students are passing");
		
		}
	
	
	// write a method to use any sorting algorithm to sort the array in alphabet order
	// APP 5 COM 3
	static void BubbleSort_Ascending(String[][] marks){
		for (int i = 0; i < marks.length - 1; i++) {
			for (int j = 0; j  < (marks.length-i)-1; j++ ) {
				int grade1 = Integer.parseInt(marks[j][1]);
				int grade2 = Integer.parseInt(marks[j+1][1]);

				if (grade1 > grade2) {
					String[] t1 = marks[j];
					String[] t2 = marks[j+1];
					marks[j+1] = t1;
					marks[j] = t2;			
				}
			}
		}
		sorted = true;
	}

	// write a method that will allow user to search for a specific mark using binary search
	// APP 5 COM 3
	
	static void BinarySearch(String[][] marks){		

		System.out.println("what number would you like to find?:");
		int search = Integer.valueOf(Inscanner.nextLine());

		int EndLength = marks.length -1;
		int StartLength = 0;
		int guess = (EndLength - StartLength) / 2; 
		int guessValue = Integer.valueOf(marks[guess][1]);
		
		if(sorted == true) {
			while(StartLength < EndLength) {
				guessValue = Integer.valueOf(marks[guess][1]);
				if(guessValue == search) { 
					System.out.println("your integer is in position: " + guess); 
					
					boolean downDone = false;
					boolean upDone = false;
			
					int i = guess -1; 
					while (!downDone) {
						if (i >= 0 && Integer.valueOf(marks[i][1]) == guessValue) {
							System.out.println("your integer is in position: " + i); 
							i -= 1; 
						}else { 
							downDone = true; 
							break;
						}
					}
			
					i = guess + 1;
					while (!upDone) {
						if (i <= marks.length && Integer.valueOf(marks[i][1]) == guessValue) {
							System.out.println("your integer is in position: " + i);
							i += 1;
						}else { 
							downDone = true;
							break;
						}
					}
					break;
				}else if (guessValue > search) { 

					EndLength = guess - 1;	
					guess = (EndLength - StartLength) / 2; 

				
				}else if (guessValue < search){ 
			
					StartLength = guess + 1;
					guess = (EndLength + StartLength) / 2; 
				}

				if (StartLength > EndLength) { 
					System.out.println("no result found"); 
					break;
				}
			}
		}else {
			System.out.println("The array is not sorted");
		}
	 }
	
	
	
	private static void display(String[][] marks) {
		for(int row=0; row<marks.length; row++) {
			for (int col=0; col<marks[row].length;col++) {
				System.out.print(marks[row][col]+"\t\t");
			}
			System.out.println("");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		String[][] marks = { { "Michael", "12" }, { "Chris", "22" }, { "Jessica", "55" }, { "Matthew", "77" }, { "Ashley", "33" }, { "Jenn", "55" }, { "Joshua", "23" }, { "Amanda", "46" }, { "Daniel", "76" }, { "David", "87" }, { "James", "88" }, { "Robert", "86" }, { "John", "15" }, { "Joseph", "17" },{ "Andrew", "95" }, { "Ryan", "94" }, { "Brandon", "93" }, { "Jason", "95" }, { "Justin", "99" },{ "Sarah", "94" }, { "William", "94" }, { "Jon", "74" }, { "Stephan", "73" }, { "Brian", "37" },{ "Nicole", "77" }, { "Nick", "73" }, { "Anthony", "79" }, { "Heather", "83" }, { "Eric", "88" },{ "Eliza", "85" }, { "Adam", "85" }, { "Megan", "89" }, { "Melissa", "84" }, { "Kevin", "84" },{ "Steven", "38" }, { "Thomas", "44" }, { "Timothy", "89" }, { "Kristin", "66" }, { "Kyle", "68" },{ "Rachel", "69" }, { "Laura", "64" }, { "Lauren", "63" }, { "Amber", "74" }, { "Britany", "88" },{ "Daniel", "99" }, { "Richard", "78" }, { "Kimbrly", "49" }, { "Jeffrey", "94" }, { "Amy", "55" },{ "Crystal", "67" }, { "Micelle", "77" }, { "Tiffany", "79" }, { "Jeremy", "87" },{ "Benji", "98" }, { "Mark", "77" }, { "Emily", "89" }, { "Aaron", "97" }, { "Charles", "56" },{ "Rebecca", "66" }, { "Jacob", "67" }, { "Stephen", "68" }, { "Patrick", "69" }, { "Sean", "76" },{ "Erin", "45" }, { "Zachary", "67" }, { "Jamie", "67" }, { "Kelly", "66" }, { "Sam", "63" },{ "Nathan", "59" }, { "Sara", "67" }, { "Dustin", "98" }, { "Paul", "77" }, { "Angela", "75" },{ "Tyler", "68" }, { "Scott", "98" }, { "Kathy", "88" }, { "Andrea", "45" }, { "Gregory", "56" },{ "Erica", "67" }, { "Mary", "68" }, { "Travis", "45" }, { "Lisa", "68" }, { "Kenneth", "87" },{ "Bryan", "78" }, { "Lindsey", "88" }, { "Kristen", "76" }, { "Jose", "66" }, { "Alexa", "86" },{ "Jesse", "98" }, { "Katie", "97" }, { "Lindsay", "96" }, { "Shannon", "95" }, { "Vanessa", "94" },{ "Cortney", "93" }, { "Tina", "47" }, { "Alicia", "67" }, { "Cody", "75" }, { "Allison", "77" },{ "Bradley", "68" }, { "Samuel", "95" } };
		System.out.println("method: passing");
		passing(marks);
		System.out.println("method: display");
		display(marks);
		System.out.println("method: sort");
		BubbleSort_Ascending(marks);
		System.out.println("method: display");
		display(marks);
		System.out.println("method: search");
		BinarySearch(marks);
	}

}