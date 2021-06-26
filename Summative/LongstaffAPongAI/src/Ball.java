/**This program was completed as an ICS4U Summative assesment
	*Ball object file.
	*demos artificial intelligence concepts through the video game pong
	*@author Alex Longstaff
	*@Version 2021-06-17
*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Random;

public class Ball {
	//defining variables
	private static final int DIAMETER = 30;
	int x = 100;
	int y = 100;
	int xa = 2;
	int ya = 2;
	int Gen = 1;
	int gcounter = 0;
	int sess = 0;
	Boolean done = true;
	Boolean start = false;
	int netcounter = 0;
	int[] scorearray1 = new int[0];
	int[] scorearray2 = new int[0];	
	int Loss1 = 0;
	int Loss2 = 0;
    int bounces1 = 0;
    int bounces2 = 0;
    
    //defining some objects
	Random r = new Random();
	private GameMain GameMain;


	public Ball(GameMain GameMain) {
		this.GameMain= GameMain;


	}

	/**Moves the ball to the position it should be on
	 * also controlls when the game ends and begins
	 *no parameters just redefines variables
	*/
	void move() {
		start = GameMain.getStart();

		//when it moves, if the game has started, reset all the variables to 0
		if(start == true && done == true) {
			Gen = 1;
			gcounter = 0;
			sess = 0;
			netcounter = 0;	
			scorearray1 = new int[0];
			scorearray2 = new int[0];	
			Loss1 = 0;
			Loss2 = 0;
		    bounces1 = 4;
		    bounces2 = 4;
		    done = false;
		}
		
		//updates the speed/direction when it bounces off a wall
		if (x + xa < 10) {
			xa = (r.nextInt(3-(1)) +1);
		}
		if (x + xa > 296 - DIAMETER) {
			xa = -(r.nextInt(3-(1)) +1);

		}
		//moves the location
		x = x + xa;
		y = y + ya;
		
		//on a collision with a paddel
		if (GameMain.Racketone.getBounds().intersects(getBounds())){
			ya = -(r.nextInt(3-(1)) +1);//change speed
			y = GameMain.Racketone.getTopY() - DIAMETER;//reset direction
			bounces1 ++;//increase number of bounces
		}
		//on a collision with a paddel
		if (GameMain.Rackettwo.getBounds().intersects(getBounds())){
			ya = (r.nextInt(3-(1)) +1);//change speed
			y = GameMain.Rackettwo.getTopY() + DIAMETER - 10;//reset direction
			bounces2 ++;//increase number of bounces

		}
		
		
		//on death
		if (y + ya > 386 - DIAMETER) {
			//determines loss. a variable used for training
			Loss1 +=  Math.abs((x - GameMain.Racketone.getTopX()));
			x= 100;
			y= 100;
			int xad = 0;
			int yad = 0;
			//picks a random direction for the ball to be moving in
			while(xad == 0 || yad == 0 && (xa != xad || ya != yad)){
		      	xad = (r.nextInt(3-(-3)) -3);
	        	yad =  (r.nextInt(3-(-3)) -3);
			}
    		xa = xad;        
    		ya = yad;
			gcounter +=1;
			//when 10 games occur do the following
			if (gcounter > 10) {
				gcounter = 0;
				//add the loss to an array
				scorearray1 = Arrays.copyOf(scorearray1,scorearray1.length +1);
				scorearray1[scorearray1.length -1] = Loss1 - bounces1;
				scorearray2 = Arrays.copyOf(scorearray2,scorearray2.length +1);
				scorearray2[scorearray2.length -1] = Loss2 - bounces2 ;
				
				GameMain.gameOver(); //call gameover in the main method
				
				//resets variables
				sess +=1;
				bounces1 =4;
				bounces2 =4;
				Loss1 = 0;
				Loss2 = 0;
			}
		}
		//on death
		if (y + ya < 10 - DIAMETER) {
			//determines loss. a variable used for training
			Loss2 += Math.abs((x - GameMain.Rackettwo.getTopX()));
			x= 100;
			y= 100;
			int xad = 0;
			int yad = 0;
			//picks a random direction for the ball to be moving in
			while(xad == 0 || yad == 0 && (xa != xad || ya != yad)) {
		      	xad = (r.nextInt(3-(-3)) -3);
	        	yad =  (r.nextInt(3-(-3)) -3);
			}
    		xa = xad;        
    		ya = yad;
			//when 10 games occur do the following
			gcounter +=1;
			if (gcounter > 10) {
				gcounter = 0;
				//add the loss to an array
				scorearray1 = Arrays.copyOf(scorearray1,scorearray1.length +1);
				scorearray1[scorearray1.length -1] = Loss1 - bounces1;
				scorearray2 = Arrays.copyOf(scorearray2,scorearray2.length +1);
				scorearray2[scorearray2.length -1] = Loss2 - bounces2;
				GameMain.gameOver();//call gameover in the main method

				//resets variables
				sess +=1;
				bounces1 =4;
				bounces2 =4;
				Loss1 = 0;
				Loss2 = 0;
			}
		}	
	}
	

	/**get method to return the value
	 *@returns Xspeed of the ball
	*/
	public int getxa() {
		return xa;
	}
	/**get method to return the value
	 *@returns Yspeed of the ball
	*/
	public int getya() {
		return ya;
	}
	/**get method to return the value
	 *@returns x coordinate of the ball
	*/
	public int getX() {
		return x;
	}
	/**get method to return the value
	 *@returns y coordinate of the ball
	*/
	public int getY() {
		return y;
	}
	/**get method to return the value
	 *@returns the score of a racket game in an array
	*/
	public int[] getScore1() {
		return scorearray1;
	}
	/**get method to return the value
	 *@returns the score of a racket game in an array
	*/
	public int[] getScore2() {
		return scorearray2;
	}
	/**get method to return the value
	 *@returns The number of sessions that have occured
	*/
	public int sess() {
		return sess;
	}
	/**get method to return the value
	 *@returns the number of games that have occured
	*/
	public int getgcounter() {
		return gcounter;
	}
	/**Paints the ball and border
	 *@param graphics g
	*/
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.drawRect(10, 10, 286, 386);
	   
	}
	/**draws a rectangle
	 *no parameters just creates an object
	*/
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}