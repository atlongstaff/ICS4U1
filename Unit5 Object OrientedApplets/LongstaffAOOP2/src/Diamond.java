/**This program was completed as an ICS4U lab
	*diamond method
	*demos oop concepts using a diamond object
	*@author Alex Longstaff
	*@Version 2021-05-13
*/
class Diamond implements Comparable<Diamond>
{
  private String stockNumber;
  
  private double karat;       /* size of the diamond */
  private String clarity;  /* clarity grade of the diamond */
  private char color;      /* color grade D-Z */
  private String cut;      /* name of the cut */

  String getStock()   { return stockNumber; }
  double getKarat()   { return karat; }
  String getClarity() { return clarity; }
  char   getColor()   { return color; }
  String getCut()     { return cut; }

  
  //constructor
  public Diamond( String s, double car, String clar, char col, String ct )
  {
    stockNumber = s;  karat = car; clarity = clar; color = col; cut = ct;  
  }
  
  /**returns the string
	*@return the data in order of importance of sorting
  */
  public String toString()
  {
	    return karat + "\t" + clarity + "\t" + color + "\t" + stockNumber + "\t" + cut + "\t";
  }
  
  /**returns the the position of the color in the alphabet divided by 2 so that its comprable to clarity
    *@param the color char used
	*@return The index over 2
  */
  int getColorPosition(char Co) {
	  char[] alpha = {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	  
	  for(int i = 0; i< alpha.length; i ++) {
		  if(Co == alpha[i]) {
			 return i /2; 
		  }
	  }
	return 0;  
  }
  
  /**Compares one diamond to another
   *@param A diamond
   *@return an integer that determines weather a diamond should be calued above one or another 
 */
  public int compareTo( Diamond other ) {
		  int C = 0;
		  int C2 = 0;
		  switch(this.clarity){
		  case "FL":
			  C = 1;
			  break;
		  case "IF":
			  C = 2;
			  break;
		  case "VVS1":
			  C = 3;
			  break;
		  case "VVS2":
			  C = 4;
			  break;
		  case "VS1":
			  C = 5;
			  break;
		  case "VS2":
			  C = 6;
			  break;
		  case "SI1":
			  C = 7;
			  break;
		  case "SI2":
			  C = 8;
			  break;
		  case "I1":
			  C = 9;
			  break;
		  case "I2":
			  C = 10;
			  break;
		  case "I3":
			  C = 11;
			  break;
	  }
		  
	switch(other.clarity){
		  case "FL":
			  C2 = 1;
			  break;
		  case "IF":
			  C2 = 2;
			  break;
		  case "VVS1":
			  C2 = 3;
			  break;
		  case "VVS2":
			  C2 = 4;
			  break;
		  case "VS1":
			  C2 = 5;
			  break;
		  case "VS2":
			  C2 = 6;
			  break;
		  case "SI1":
			  C2 = 7;
			  break;
		  case "SI2":
			  C2 = 8;
			  break;
		  case "I1":
			  C2 = 9;
			  break;
		  case "I2":
			  C2 = 10;
			  break;
		  case "I3":
			  C2 = 11;
			  break;
	  }
	
	//if karats are equal
	if (this.getKarat() == (other.getKarat())){
		//check to see if the magnitude in the difference of color is less than the magnitude of the difference of clartiy
		//this allows to determine which of the two are being sorted by.
		if(Math.abs(C2 - C)  > Math.abs(this.getColorPosition(this.getColor()) - other.getColorPosition(other.getColor()))) {
			return C-C2; //if clarity is more important sort by it.
		} else{
			//else then color is more important so sort by it.
			return this.getColorPosition(this.getColor()) - other.getColorPosition(other.getColor());
		}
		
	}else { //if karats are not equal sort by them
		return (int) ((other.getKarat() - this.getKarat()) * 100); //multiply by 100 to avoid rounding problems
	}
  }
}

