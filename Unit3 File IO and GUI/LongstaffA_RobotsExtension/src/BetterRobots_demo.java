import becker.robots.*; //Robot library
	
import java.util.Scanner;  // Import the Scanner class
public class BetterRobots_demo {
 
	public static Scanner Inscanner = new Scanner(System.in); 	
	public static Scanner Vscanner = new Scanner(System.in); 	

	
	public static void main(String[] args) {
		
		City newmarket = new City();//Create a city were the robot lives
	
		buildWalls(newmarket);//Call build walls method
		buildThings(newmarket);//Put the mines
		
		Robot karel = new Robot(newmarket, 3, 1, Direction.EAST); //create an object type Robot called karel
		System.out.println("working \n");	

		
		
		
		System.out.println("Welcome To a better Robot demo"); 
		System.out.println("This uses a Text based UI to interact with the BetterRobot class"); 
		System.out.println("You can use it for the following:"); 

		System.out.println("To turn around, enter: 1"); 
		System.out.println("To turn right, enter: 2"); 
		System.out.println("To move forward, enter: 3"); 
		System.out.println("To set a new speed, enter: 4"); 
		System.out.println("to find your speed, enter: 5"); 
		System.out.println("To move backwards, enter: 6"); 
		while(true) {
			try { 			
				String minput = Inscanner.nextLine(); //checks for input
			if(Integer.valueOf(minput) <= 6 && Integer.valueOf(minput) >= 1){ //determines if input is valid
				//determines which input the user selected, and activates the corresponding method
				int mintinput = Integer.parseInt(minput);
				switch(mintinput) {
				
				case 1:
					
					BetterRobot.turnAround(karel);
					System.out.println("done \n");	
					break;
				case 2:
					
					BetterRobot.turnRight(karel);
					System.out.println("done \n");	
					break;
					
				case 3:
					System.out.println("How many moves would you like to make?");	

					int N = Vscanner.nextInt(); //checks for input

					BetterRobot.moveN(karel, N);
					System.out.println("done \n");	
					break;
				case 4:
					
					System.out.println("your speed is" + BetterRobot.getRobotSpeed(karel));	

					System.out.println("done \n");	
					break;
				case 5:
					
					BetterRobot.moveBack(karel);
					System.out.println("done \n");	
					break;
				case 6:
					System.out.println("How many moves per second would you like to make?");	

					double mps = Vscanner.nextDouble(); //checks for input

					
					BetterRobot.setRobotSpeed(karel,mps);
					System.out.println("done \n");	
	
				}
			}else { System.out.println("An error occured. Make sure your input is an option");  }
			}catch(Exception e) {System.out.println("An error occured. Make sure you are only inputing integers"); }

		}
		
			
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


	
	}

