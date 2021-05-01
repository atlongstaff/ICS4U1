import java.util.Scanner;

public class ExampleQ7 {
	public static void main(String[] args){
		System.out.println("Input the minimum"); 	

		while(true) {
			Scanner minscan = new Scanner(System.in);
			int minnum = minscan.nextInt();	
			
			if ((minnum >= 50 )&& (minnum <= 100)){
				for (int i=100; i>=minnum; i-=5) {
					System.out.println(i); 	
				}
			}else {
				System.out.println("number not between 50 and 100");
			}
		}
	}
}