package longstaffAClearMines;

import becker.robots.*; //Robot library

class ClearMines {
		public static void main(String[] args) {
	//Create a city were the robot lives
			City newmarket = new City();

	//Call build walls method
			buildWalls(newmarket);

	//Put the mines
			buildThings(newmarket);

	//create an object type Robot called karel
			Robot karel = new Robot(newmarket, 3, 1, Direction.EAST);

	//
//			if (karel.canPickThing() == true) {
//				karel.pickThing();
//			}
	//
			karel.move();


		} // end main

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
		/*
		 * private static int getRandomNumberInRange(int min, int max) {
		 * 
		 * if (min >= max) { throw new
		 * IllegalArgumentException("max must be greater than min"); }
		 * 
		 * Random r = new Random(); return r.nextInt((max - min) + 1) + min; }
		 */

	} // end class

