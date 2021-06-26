/**This program was completed as an ICS4U lab
	*Fruit method
	*demos oop concepts using a Fruit object
	*@author Alex Longstaff
	*@Version 2021-05-13
*/
import java.util.Arrays;

public class Fruit implements Comparable<Fruit>{
  // Variable
  private String name;
  private int weight;
  private String taste;  // can be plain, good, yummy, great

  //Constructors
  public Fruit( String nm, int wei, String tst ){
	  name = nm;
	  weight = wei;
	  taste = tst;
  }  
  
  /**returns the string
	*@return the data in order of importance of sorting
  */
  public String toString(){
    return taste + "\t" + name + "\t" + weight + " oz.";
  }
  
  /**Compares one fruit to another
   *@param A fruit
   *@return an integer that determines weather a fruit should be sorted above one or another 
 */
  public int compareTo(Fruit other)  
  {
	  int t = 0;
	  int t2 = 0;

	  switch(this.taste){
		  case "plain":
			  t = 1;
			  break;
		  case "good":
			  t = 2;
			  break;
		  case "yummy":
			  t = 3;
			  break;
		  case "great":
			  t = 4;
			  break;
	  }
	  switch(other.taste){
	  	  case "plain":
	  		  t2 = 1;
	  		  break;
	  	  case "good":
	  		  t2 = 2;
	  		  break;
	  	  case "yummy":
	  		  t2 = 3;
	  		  break;
	  	  case "great":
	  		  t2 = 4;
	  		  break;
	  }

	  if( t < t2) {
		  return -1;
	  }else if(t > t2) {
		  return 1;
	  }else {
		  return 0;
	  }
  }  
}
