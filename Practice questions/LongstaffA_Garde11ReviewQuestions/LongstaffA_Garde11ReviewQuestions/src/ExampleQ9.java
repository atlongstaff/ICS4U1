public class ExampleQ9 {
	public static void main(String[] args){
		double mortgage = 120000; 
		while(mortgage >=0) {
			mortgage += mortgage*0.0775;
			mortgage -= 24000;
		 	System.out.println("mortgage: " + mortgage);
		}
	}
}

