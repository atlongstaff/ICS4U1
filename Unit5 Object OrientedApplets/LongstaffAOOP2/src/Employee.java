/**This program was completed as an ICS4U lab
	*Employee method
	*demos oop concepts using an employee object
	*@author Alex Longstaff
	*@Version 2021-05-13
*/
class Employee implements Comparable<Employee>{
	
  private String firstName;
  private String lastName;
  private int birthYear;

  //constructor
  public Employee( String f, String l, int year ){ 
	  firstName = f;
	  lastName = l;
	  birthYear = year;
  }

  //setter
  String getFirstName()  { 
	  return firstName; 
  }
  //setter
  String getLastName()   { 
	  return lastName; 
  }
  //setter
  int    getBirthYear()  { 
	  return birthYear; 
  }
  
  /**returns the string
	*@return the data in order of importance of sorting
  */
  public String toString(){
		  
	    return lastName + "\t" + firstName + "\t" + birthYear ;
	
  }
  
  /**Compares one employee to another
   *@param An Employee
   *@return an integer that determines weather an employee should be sorted above one or another 
 */
  public int compareTo( Employee other ) {
	  return this.toString().compareTo(other.toString());
  }
  
}
