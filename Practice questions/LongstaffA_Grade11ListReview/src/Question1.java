import java.util.Collections;

public class Question1 {
	  public static void main(String[] args) {
		  String[] myarray = {"0", "1", "2", "3", "4", "5", "6"};
		  
		  
		for(int i = 0; i <= myarray.length/2; i++ ) {
			String j = myarray[i];
			myarray[i] = myarray[myarray.length - i - 1];
			myarray[myarray.length - i - 1] = j;

		}
	  
	  	for (int i = 0; i < myarray.length; i++) {
	  		System.out.println(myarray[i]);
		}
	}
}
