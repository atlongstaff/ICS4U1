import java.util.Scanner;

public class ExampleQ12 {
	public static void main(String[] args){

		while(true) {
			System.out.println("Input an integer"); 	
			Scanner numscan = new Scanner(System.in);
			
			int numint = numscan.nextInt();	
			int i = 0;
			
			for (;  numint!=0; numint /= 10, i++) {};
			System.out.println("your number has " + i + " digets");
		}
	}
}