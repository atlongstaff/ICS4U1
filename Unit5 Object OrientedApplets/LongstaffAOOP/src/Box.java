/**This program was completed as an ICS4U lab
	*Box method
	*demos oop concepts using a box object
	*@author Alex Longstaff
	*@Version 2021-05-06
*/

public class Box {
	double wid;
	double hei;
	double len;
	//constructor
	Box ( double width, double height, double length ){
		 wid = width;
		 hei = height;
		 len = length;
	}
	
	/**calculates volume of box
     *@returns volume
    */
	double volume(){
		return wid * hei * len;
	}
	
	
	/**calculates surface area of box
     *@returns surface area
    */
	double surfacearea(){
		return 2 *(wid * len + hei * len + wid * hei);
	
	}
}