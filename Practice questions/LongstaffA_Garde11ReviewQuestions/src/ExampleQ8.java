
public class ExampleQ8 {
	public static void main(String[] args){
		double balance = 1000; 
		double interest;
		for (int i=1; i<=10; i++) {
			interest = balance * 0.06;
		 	balance += interest;
		 	System.out.println("year: " + i + " interest: " + interest + " balance: " + balance);
	}
}
}
