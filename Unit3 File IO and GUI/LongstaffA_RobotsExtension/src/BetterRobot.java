import becker.robots.*; //Robot library

public class BetterRobot extends Robot
{
	public BetterRobot(City arg0, int arg1, int arg2, Direction arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	/**Turns the robot around
	*@param karel -the robot
	*@returns the robot rotating around 180
	*/
	public static void turnAround(Robot karel){
		karel.turnLeft();
		karel.turnLeft();
	}
	
	/**Turns the robot right
	*@param karel -the robot
	*@returns the robot rotating right
	*/
	public static void turnRight(Robot karel){
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
	}
	
	/**Moves Forward N number
	*@param karel -the robot
	*@returns Moves Forward N number
	*/
	public static void moveN(Robot karel, int N){
		for (int i = 0; i < N; i++)
		{
			karel.move(); //move forward
		}
		
	}
	/**Returns Robot speed
	*@param karel -the robot
	*@returns Robot Speed
	*/
	public static double getRobotSpeed(Robot karel){
		return karel.getSpeed();
	}
	
	/**Moves Robot Backwards
	*@param karel -the robot'
	*@returns Robot movesBack
	*/
	public static void moveBack(Robot karel){
		turnAround(karel);
		karel.move(); //move backward
		turnAround(karel);

	}
	/**sets the robot speed
	*@param karel -the robot
	*@param mps -moves per second
	*@returns Robot speed changes
	*/
	public static void setRobotSpeed(Robot karel, double mps){
		karel.setSpeed(mps); //
	}
	
	
}
