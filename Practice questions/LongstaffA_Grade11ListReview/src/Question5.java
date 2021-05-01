import java.util.Scanner;
import java.util.Arrays;


public class Question2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);	
		
		String[] inlist = {""};
		
		while(true) {
			String Sinput = input.nextLine();

			inlist = Arrays.copyOf(inlist, inlist.length + 1);
			inlist[inlist.length - 1] = Sinput;
		    
		    System.out.println(Arrays.toString(inlist));
		}
	}
}