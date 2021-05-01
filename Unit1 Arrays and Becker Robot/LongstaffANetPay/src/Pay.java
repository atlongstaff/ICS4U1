/**This program was completed as an ICS4U lab
 	*A program to compute net pay with object oriented programming
	*@author Alex Longstaff
	*@Version 2021-03-12
*/
//main class
public class Pay {
	/**Calculate the double net pay
 	*@param HRate (hourly rate)
 	*@param HWorked (Hours worked)
 	*@param TRate (Tax rate in %)
	*@returns the global array in ascending order
	*/
	public double computeNetPay(double HRate, double HWorked, double TRate) {
		//find total pay
		double NetPay  = HRate*HWorked;
		//subtract the taxes
		NetPay  *= 1-(TRate/100);
		//return
		return NetPay;
	}
}
