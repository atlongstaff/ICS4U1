public class LongstaffASortingAssignment {
	public static int glblarray[] = new int[200];
	
	
	static void RandomizeArray() {
		for (int i = 0; i < glblarray.length; i++) {
		    int randint = (int)(Math.random() * (100) + 1);
			glblarray[i] = randint;//add it to the array

		}
	}
	static void BubbleSort_Ascending(){
		for (int i = 0; i < glblarray.length - 1; i++) {
			for (int j = 0; j  < (glblarray.length-i)-1; j++ ) {
				if (glblarray[j] >= glblarray[j+1]) {
					int t1 = glblarray[j];
					int t2 = glblarray[j+1];
					glblarray[j+1] = t1;
					glblarray[j] =t2;
					
				}
			}
		}
	}
	
	static void BubbleSort_Descending (){
		for (int i = 0; i < glblarray.length - 1; i++) {
			for (int j = 0; j  < (glblarray.length-i)-1; j++ ) {
				if (glblarray[j] <= glblarray[j+1]) {
					int t1 = glblarray[j];
					int t2 = glblarray[j+1];
					glblarray[j+1] = t1;
					glblarray[j] =t2;
					
				}
			}
		}
	}
	
	static void SelectSort_Ascending(){		
		for (int i = 0; i < glblarray.length ; i++) {
			int max = i;
			for (int j = i+1; j  < glblarray.length; j++ ) {
				if (glblarray[j] >= glblarray[max]) {
					max = j;
				}
			}
			int t = glblarray[max];
			glblarray[max] = glblarray[i];
			glblarray[i] =t;
		}
	}	
	
	static void SelectSort_Descending (){
		for (int i = 0; i < glblarray.length ; i++) {
			int min = i;
			for (int j = i+1; j  < glblarray.length; j++ ) {
				if (glblarray[j] <= glblarray[min]) {
					min = j;
				}
			}
			int t = glblarray[min];
			glblarray[min] = glblarray[i];
			glblarray[i] =t;
		}
	}
	
	static void CombSort_Ascending(){
		System.out.print("working");

		int group = glblarray.length - 1;
		System.out.print("working");

		while(group > 1) {
			System.out.print("working");

		
		for (int i = 0; i + group < glblarray.length - 1; i++) {
				group-=1;
				System.out.print(glblarray[i] + ",");

				if (glblarray[i] >= glblarray[i +group]) {
					int t1 = glblarray[i];
					int t2 = glblarray[i+group];
					glblarray[i+1] = t1;
					glblarray[i] =t2;
					
				
				}
			}
		}
	}
	static void CombSort_Descending(){		
		for (int i = 0; i < glblarray.length ; i++) {
			int max = i;
			for (int j = i+1; j  < glblarray.length; j++ ) {
				if (glblarray[j] >= glblarray[max]) {
					
					max = j;
				}
			}
			int t = glblarray[max];
			glblarray[max] = glblarray[i];
			glblarray[i] =t;
		}
	}	
	
	
	
	static void DisplayArray() {
		for (int i = 0; i < glblarray.length; i++) {
			System.out.print(glblarray[i] + ",");
			
		} // iterates through a for loop and displays the index corresponding to that iteration
		System.out.print("\n"); // creates a new line for the next method
	}
	
	
	
	public static void main(String[] args) {
		
		RandomizeArray();
		
		BubbleSort_Ascending();
		
		CombSort_Ascending();
		
		DisplayArray();
	}
}
