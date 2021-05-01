import java.util.Scanner;
public class ExampleQ3 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);	
		int wordcount = 0;	
		while(true) {
			String Sinput = input.nextLine();
			if(Sinput.equals("end")){
				System.out.println(wordcount + " words total");
			}else {
				wordcount ++; 
			}
	}
}
}
