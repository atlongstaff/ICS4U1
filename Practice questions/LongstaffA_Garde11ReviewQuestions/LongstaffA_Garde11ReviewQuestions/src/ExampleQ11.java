import java.util.Scanner;

public class ExampleQ11 {
	public static void main(String[] args){

		while(true) {
			System.out.println("Input an integer"); 	
			Scanner numscan = new Scanner(System.in);
			int numint = numscan.nextInt();	
			
			
			if ((numint >= 1 )&& (numint <= 50)){
				
				for (int i=1; i<=numint; i+=1) {
					if(numint % i == 0) {
						System.out.println(i + " is a factor of " + numint);
						
						System.out.println(i + " has the following factors:");
						
						for(int n=1; n<=i; n++) {
							if(i % n == 0) {
							System.out.println(n);
							}
						}
						
						
						
						
						
					}
				}
				
				
				
				
				
			}else{
				System.out.println("Minimum not between 1 and 50, Input another minimum");
			}
		}
	}
}
