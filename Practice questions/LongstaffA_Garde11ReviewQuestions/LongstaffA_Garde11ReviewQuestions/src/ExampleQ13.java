import java.util.Scanner;

public class ExampleQ13 {
	public static void main(String[] args){
		while(true) {
			
			System.out.println("Input an integer"); 	
			Scanner numscan = new Scanner(System.in);
			
			int numint = numscan.nextInt();
			
			if(Math.sqrt(numint) % 1 == 0 ) {
				System.out.println("your number is a perfect square");
			}else {
				System.out.println("your number is NOT a perfect square");

			}

		}
	}
}
