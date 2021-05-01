import java.util.Scanner;

public class ExampleQ10 {
	public static void main(String[] args){
		
		while(true) {
			System.out.println("press enter to roll");
			Scanner enter = new Scanner(System.in);
			enter.nextLine();
			int point = (int) (Math.random()*6)+1;
			
			System.out.println("Your point is: " + point);

			int Rollint = 0;
		
		
			while(point != Rollint) {
				System.out.println("press enter to roll again");
				enter.nextLine();
				Rollint = (int) (Math.random()*6)+1;
			
				System.out.println("Your Roll is: " + Rollint);
			}
		
			System.out.println("Congrats, you rolled the pointer ");
			System.out.println("to play again press y, to exit press n ");
		
			if(enter.nextLine().equals("n")) {break;}
		}
	}
}
