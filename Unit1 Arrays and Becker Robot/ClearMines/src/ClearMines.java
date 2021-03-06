import becker.robots.*; //Robot library
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors

import java.util.Scanner;  // Import the Scanner class
import java.io.FileWriter;   // Import the FileWriter class

class ClearMines {
	public static int[][] MineArray = new int[0][3];//create an array to store mine data
	public static String[][] newMineArray = new String[0][3];//create an array to store mine data
	public static boolean run = true;

	public static int minenum = 0; //counter for number of mines 
	public static int mineplacecounter = 0; //counter for number of mines 

	
	public static void main(String[] args) {
		
		City newmarket = new City();//Create a city were the robot lives
	
		buildWalls(newmarket);//Call build walls method
		buildThings(newmarket);//Put the mines
		
		Robot karel = new Robot(newmarket, 3, 1, Direction.EAST); //create an object type Robot called karel

		int startstreet = karel.getStreet();
		
		
		double TStart = System.currentTimeMillis();									//sets first time
		clearMines(karel, startstreet);												//run the clears mine funciton
		double TEnd = System.currentTimeMillis();									//sets end time
		System.out.println("It took " + (TEnd - TStart) +"ms to clear the city");	//display time
			
		displayMineArray();
	} 

	
	/**Move the Robot forward for a set amount
	*@param karel -the robot
 	*@param numMove -the integer
	*@returns the robot moving
	*/
	public static void moveStreet(Robot karel, int numMove) 
	{
		for(int i = 0; i < numMove; i++) //move number of times passed into method
		{
			karel.move();
		}
	}
	
	
	
	/**Clear the street you are on
 	*@param karel -the robot
	*@returns the robot moving and calls the embedded method pickthing()
	*/
	public static void clearStreet(Robot karel) 
	{
		while(karel.frontIsClear()) //while your not going to hit the wall
		{
			if(karel.frontIsClear()) //if your not going to hit the wall
			{
				karel.move(); //move forward
				pickthing(karel); //call embedded pickthing method
			}
		}

	}
	
	
	
	/**part B Writes the file to text
	*@returns a text file with the filled array
	*/
	public static void Writetotxt() 
	{
	    try 
	    {
	        File arrayfile = new File("arrayfile.txt");
	    	if (arrayfile.createNewFile()) 
	    	{
	            System.out.println("File created: " + arrayfile.getName() + " with game data");
	         }else{
	            System.out.println("File already exists and is being filled with game data.");
	        }
	    	
	    	
	        FileWriter Writer = new FileWriter("arrayfile.txt");
			for (int i = 0; i < MineArray.length; i++)
			{
				for (int j = 0; j < MineArray[i].length; j++)
				{
					  Writer.write(MineArray[i][j] + " ");//display data
			    }
				  Writer.write("\n");
			}
			Writer.close();
	        System.out.println("Successfully wrote to the file.");
	        
	      } catch (IOException e) {
	        System.out.println("A file error occurred.");
	        e.printStackTrace();
	      }
	}
	
	
	/**part C Reads the file to text
	*@returns the data from the file into the minefeild
	*/
	public static void Readfromtxt() 
	{
	    try 
	    {
	    	String SLine = "";
	    	String[][] ALine = new String[1][3]; //create an array of data for the current mine 
	        File arrayfile = new File("arrayfile.txt");
	        Scanner Reader = new Scanner(arrayfile);
	        while (Reader.hasNextLine() )
	        {
	           SLine  = Reader.nextLine() ;
	 	       ALine[0] = SLine.split(" ");
	 	       newMineArray = stringappend(newMineArray, ALine);
	        }	       
	        
	        Reader.close();
	    }catch (FileNotFoundException e) {
	          System.out.println("A file error occurred.");
	          e.printStackTrace();
	    }
	}
	
	
	/**Clears the entire city
	*@param karel -the robot
 	*@param startstreet -the begining street
	*@returns the robot moving and calls the embedded method clearStreet()
	*/
	public static void clearMines(Robot karel, int startstreet) 
	{
		while(karel.frontIsClear())//while your not going to hit the wall
		{
			clearStreet(karel); //run embedded method to clear the street
			
			if(!karel.frontIsClear() && (startstreet - karel.getStreet()) %2 == 0) //if you have reached a wall on an even number street
			{
				turnRight(karel); //turn right
				
				if(!karel.frontIsClear()) //check if the robot is clear
				{
					Writetotxt();
					Readfromtxt();
					Resetposition(karel,startstreet);
					break;
				}
				karel.move();//move forward
			
				
				pickthing(karel);//pick something up
				turnRight(karel);//turn right
			}
			
			
			if(!karel.frontIsClear() && (startstreet - karel.getStreet()) %2 != 0)//if you have reached a wall on an even number street
			{
				karel.turnLeft();//run embedded method to clear the street
				
				if(!karel.frontIsClear())  //check if the robot is clear
				{
					Writetotxt();
					Readfromtxt();
					Resetposition(karel,startstreet);
					break;
				}
				karel.move();	//move forward
				
				
				pickthing(karel);//pick something up
				karel.turnLeft();//turn right

			}
		}	
		
	}
	
	
	
	/**reset the position to the start of the minefeild
 	*@param karel -the robot
 	*@param start street to get the final posisition
	*@returns to original position
	*/
	public static void Resetposition(Robot karel, int startstreet) 
	{
		turnRight(karel); //turn right
		turnRight(karel); //turn right
		clearStreet(karel); 		
		turnRight(karel); //turn right
		FillMines(karel,startstreet);

	}
	
	
	
	/**checks if the current position was a position with a mine the 
 	*@param karel -the robot
	*@returns the robot moving and calls the embedded method putthing()
	*/
	public static void checkmineposition(Robot karel, int startstreet) 
	{
		if(mineplacecounter != newMineArray.length && karel.getStreet() == Integer.parseInt(newMineArray[mineplacecounter][1]) && karel.getAvenue() == Integer.parseInt(newMineArray[mineplacecounter][2]) ) 
		{
			karel.putThing();
			mineplacecounter +=1;
		}else if(mineplacecounter == newMineArray.length -1){
			run = false; 
		}
	}
	
	
	/**fill the street you are on with mines
 	*@param karel -the robot
	*@returns the robot moving and calls the embedded method pickthing()
	*/
	public static void fillStreet(Robot karel, int startstreet) 
	{
		while(karel.frontIsClear()) //while your not going to hit the wall
		{
			if(karel.frontIsClear()) //if your not going to hit the wall
			{
				karel.move(); //move forward
				checkmineposition(karel, startstreet); //call embedded pickthing method
			}
		}

	}

	/**Fill the entire city
	*@param karel -the robot
 	*@param startstreet -the begining street
	*@returns the robot moving and calls the embedded method clearStreet()
	*/
	public static void FillMines(Robot karel, int startstreet) 
	{
		while(karel.frontIsClear())//while your not going to hit the wall
		{
			if(mineplacecounter == newMineArray.length -1){
				break; 
			}else {
				fillStreet(karel,startstreet); //run embedded method to clear the street
			}
			if(!karel.frontIsClear() && (startstreet - karel.getStreet()) %2 == 0) //if you have reached a wall on an even number street
			{
				turnRight(karel); //turn right
				
				if(!karel.frontIsClear()) //check if the robot is clear
				{
					FillMines(karel,startstreet);
					break;
				}
				karel.move();//move forward
			
				
				checkmineposition(karel, startstreet);//pick something up
				turnRight(karel);//turn right
			}
			
			
			if(!karel.frontIsClear() && (startstreet - karel.getStreet()) %2 != 0)//if you have reached a wall on an even number street
			{
				karel.turnLeft();//run embedded method to clear the street
				
				if(!karel.frontIsClear())  //check if the robot is clear
				{
					FillMines(karel,startstreet);
					break;
				}
				karel.move();	//move forward
				
				
				checkmineposition(karel, startstreet);
				karel.turnLeft();//turn right

			}
		}	
		
	}
	
	
	/**Turns the robot right
	*@param karel -the robot
	*@returns the robot rotating right
	*/
	public static void turnRight(Robot karel) 
	{
		//turn left 3 times to effectively turn right
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
	}
	
	
	
	/**Picks up an object and stores it
	*@param karel -the robot
	*@returns an appended array minearray
	*/
	public static void pickthing(Robot karel) 
	{
		if (karel.canPickThing() == true) //if you can pick something up
		{
			int[][] currentmine = new int[1][3]; //create an array of data for the current mine 

			currentmine[0][0] = minenum; //fill that array with data
			currentmine[0][1] = karel.getStreet();
			currentmine[0][2] = karel.getAvenue();
			
			minenum += 1; //add one to the index of the mines
			
			MineArray = append(MineArray,currentmine); //add that temporary data to the current mine
			karel.pickThing(); //pick it up
		}
	}
	
	
	
	/**Displays a 2d minearray / all data collected
	*@param karel -the robot
	*@returns data through printing to console
	*/
	public static void displayMineArray() 
	{
		System.out.println("Mine  Number\t Row (Street)\t Column (Avenue)");//display titles 
		for (int i = 0; i < MineArray.length; i++)
		{
			for (int j = 0; j < MineArray[i].length; j++)
			{
				System.out.print(MineArray[i][j] + "\t\t");//display data
		    }
			System.out.println();
		}
		System.out.println("the total number of mines is: " + MineArray.length);//display total number of appends
	}
	
	
	
	/**A standard method for appending two arrays
	*@param Initial array
	*@param Added array
	*@returns new appended array
	*/
    public static int[][] append(int[][] initial, int[][] added) 
    {
    	int[][] appendedarray = new int[initial.length + added.length][];//create a temporary appended array the length of the two arrays put together
        System.arraycopy(initial, 0, appendedarray, 0, initial.length);
        System.arraycopy(added, 0, appendedarray, initial.length,added.length);
        return appendedarray;
    }

	/**A standard method for appending two arrays
	*the same thing as above but for strings
	*/
    public static String[][] stringappend(String[][] initial, String[][] added) 
    {
    	String[][] appendedarray = new String[initial.length + added.length][];//create a temporary appended array the length of the two arrays put together
        System.arraycopy(initial, 0, appendedarray, 0, initial.length);
        System.arraycopy(added, 0, appendedarray, initial.length,added.length);
        return appendedarray;
    }
    
	
	public static void buildWalls(City newmarket) {
		Wall blockAve1n = new Wall(newmarket, 3, 2, Direction.NORTH);
		Wall blockAve2n = new Wall(newmarket, 3, 3, Direction.NORTH);
		Wall blockAve3n = new Wall(newmarket, 3, 4, Direction.NORTH);
		Wall blockAve4n = new Wall(newmarket, 3, 5, Direction.NORTH);
		Wall blockAve5n = new Wall(newmarket, 3, 6, Direction.NORTH);
		Wall blockAve6n = new Wall(newmarket, 3, 7, Direction.NORTH);
		Wall blockAve7n = new Wall(newmarket, 3, 8, Direction.NORTH);
//
		Wall blockAve1s = new Wall(newmarket, 10, 3, Direction.SOUTH);
		Wall blockAve2s = new Wall(newmarket, 10, 4, Direction.SOUTH);
		Wall blockAve8s = new Wall(newmarket, 10, 5, Direction.SOUTH);
		Wall blockAve3s = new Wall(newmarket, 10, 6, Direction.SOUTH);
		Wall blockAve4s = new Wall(newmarket, 10, 7, Direction.SOUTH);
		Wall blockAve5s = new Wall(newmarket, 10, 8, Direction.SOUTH);
		Wall blockAve7s = new Wall(newmarket, 10, 2, Direction.SOUTH);

		Wall blockAve1e = new Wall(newmarket, 3, 8, Direction.EAST);
		Wall blockAve2e = new Wall(newmarket, 4, 8, Direction.EAST);
		Wall blockAve3e = new Wall(newmarket, 5, 8, Direction.EAST);
		Wall blockAve4e = new Wall(newmarket, 6, 8, Direction.EAST);
		Wall blockAve5e = new Wall(newmarket, 7, 8, Direction.EAST);
		Wall blockAve6e = new Wall(newmarket, 8, 8, Direction.EAST);
		Wall blockAve7e = new Wall(newmarket, 9, 8, Direction.EAST);
		Wall blockAv8e = new Wall(newmarket, 10, 8, Direction.EAST);

//Wall blockAve32w = new Wall(newmarket, 3 ,2 , Direction.WEST);
		Wall blockAve33w = new Wall(newmarket, 4, 2, Direction.WEST);
		Wall blockAve35w = new Wall(newmarket, 5, 2, Direction.WEST);
		Wall blockAve36w = new Wall(newmarket, 6, 2, Direction.WEST);
		Wall blockAve37w = new Wall(newmarket, 7, 2, Direction.WEST);
		Wall blockAve39w = new Wall(newmarket, 8, 2, Direction.WEST);
		Wall blockAve310w = new Wall(newmarket, 9, 2, Direction.WEST);
		Wall blockAve311w = new Wall(newmarket, 10, 2, Direction.WEST);
	}

	public static void buildThings(City newmarket) {
		Thing t1 = new Thing(newmarket, 4, 5);
		Thing t2 = new Thing(newmarket, 5, 4);
		Thing t4 = new Thing(newmarket, 5, 6);
		Thing t6 = new Thing(newmarket, 6, 4);
		Thing t8 = new Thing(newmarket, 6, 6);
		Thing t10 = new Thing(newmarket, 7, 2);
		Thing t12 = new Thing(newmarket, 7, 4);
		Thing t13 = new Thing(newmarket, 7, 5);
		Thing t16 = new Thing(newmarket, 7, 8);
		Thing t17 = new Thing(newmarket, 8, 2);
		Thing t18 = new Thing(newmarket, 8, 7);
		Thing t19 = new Thing(newmarket, 9, 2);
		Thing t20 = new Thing(newmarket, 10, 4);
		Thing t21 = new Thing(newmarket, 10, 7);

		/*
		 * int x = 0; int y = 0; int z = Random(1,20); Thing[] mines = new Thing[z]; for
		 * (int i = 0; i < z; i++) { x = Random(4, 10); y = Random(2, 8); mines[i] = new
		 * Thing(newmarket, x, y);
		 */
	}


} // end class