import java.util.Scanner;

public class ExampleQ4 {
	public static void main(String[] args){
		Scanner scannumclasses = new Scanner(System.in);	
		System.out.println("How many classes do you have?"); 	
		int numclasses = scannumclasses.nextInt();		
		int sum = 0;
		
		
		for (int i=1; i<=numclasses; i++) {
			System.out.println("input your grade"); 
			Scanner grade = new Scanner(System.in);	
			int numgrade = grade.nextInt();		
			
			sum += numgrade;
		}
		int average = sum/numclasses;
		System.out.println("your average is " + average);
	}
}
