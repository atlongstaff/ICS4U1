/**This program was completed as an ICS4U lab
	*Fruit tester
	*demos oop concepts using a Fruit object
	*@author Alex Longstaff
	*@Version 2021-05-13
*/
import java.util.Arrays;
public class FlavorfulFruit
{
		  public static void main ( String[] args )
		  {
		    Fruit[] fruitStand = new Fruit[10];
		    
		    fruitStand[0] =  new Fruit( "apple", 3, "plain" );
		    fruitStand[1] =  new Fruit( "pear",  4, "good" );
		    fruitStand[2] =  new Fruit( "strawberry", 1, "great" );
		    fruitStand[3] =  new Fruit( "grape", 1, "great" );
		    fruitStand[4] =  new Fruit( "orange", 5, "yummy" );
		    fruitStand[5] =  new Fruit( "quince", 4, "plain" );
		    fruitStand[6] =  new Fruit( "banana", 3, "yummy" );
		    fruitStand[7] =  new Fruit( "peach", 4, "good" );
		    fruitStand[8] =  new Fruit( "watermellon", 3, "yummy" );
		    fruitStand[9] =  new Fruit( "cantalope", 3, "good" );
		    
		    //fruitStand[0].compareTo(fruitStand[1]);
		    Arrays.sort( fruitStand );
		    
		    for ( int j=0; j<fruitStand.length; j++ )
		    {
		      System.out.println( fruitStand[j] );
		    }
		    
		    
		  } 

}
