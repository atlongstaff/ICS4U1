/**This program was completed as an ICS4U Summative assesment
	*Racket and network object file.
	*demos artificial intelligence concepts through the video game pong
	*@author Alex Longstaff
	*@Version 2021-06-17
*/

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Racketone {
	//defines some variables
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 10;
	int xa = 0;
	double epsilon = 0.1;
	double[] datasetlist = {};
	int median = 0;
	int meanv = 0;
	int searchs = 0;
	int sortVs = 0;
	int sortVi = 0;
	
	Random r = new Random();
	private GameMain GameMain;
	
	
	/**Randomizes the weights of the Neural Network
	 *generates a random network to overcome the hill climbing problem 
	*/
	public double[][] randomizeweights(){
		double weights[][] = new double[8][6];
	     for (int i = 0; i < weights.length; i++) {
	        for (int j = 0; j < weights[i].length ; j++) {
	        	double result = r.nextInt(100-(-100)) -100;
	        	weights[i][j] = result / 100 ;
	        }
	     }
		return weights;	
	}
	//defines the weights as random 
	double[][] weights = randomizeweights();

	//defines the object
	public Racketone(GameMain GameMain) {
		this.GameMain = GameMain;
	}
	/**Determines the direction of the racket
	 *moves the paddel 
	*/
	public void move() {
		int Speed = 3;
		if (Neuralnetwork() == 1)
			xa = -Speed;
		if (Neuralnetwork() == -1)
			xa = Speed;
		if (x + xa > 9 && x + xa < 296 - WIDTH)
			x = x + xa;
	}

	/**Paints the Racket and any data to go along with it
	 *@param graphics g
	*/
	public void paint(Graphics2D g) {
		//sets color
		g.setColor(Color.RED);
		g.fillRect(x, Y, WIDTH, HEIGHT);
		//every 10 games, search for the data
		if((GameMain.ball.sess()) % 10 == 0 && GameMain.ball.sess() != 0 && GameMain.ball.getgcounter() < 5){
			median = (int) this.sortfile()[GameMain.ball.sess()/2][0][0][0];
			meanv = this.mean();
			searchs = this.Search(meanv); // you can pass this paramater in to test the search function : 
			sortVs = (int) this.sortfile()[0][0][0][0];
			sortVi = (int) this.sortfile()[0][1][0][0];
		}
		//when no datas been generated, display a different messege
		if(meanv == 0 ){
			g.drawString("Not enough data yet.",400,250);
			g.drawString("Data will be generated every 10 sessions",400,275);
		}else{//when datas been generated, display it
			g.drawString("Network 1s median loss value is:",400,250);
			g.drawString(String.valueOf(median),600,250);
			g.drawString("Network 1s mean loss value is:",400,275);
			g.drawString(String.valueOf(meanv),600,270);
			
			//if the search came with zero data display it if not display a different messege 
			if(searchs != 0) {
				g.drawString("The game that had the mean loss value is game: ",400,300);
				g.drawString(String.valueOf(searchs),700,300);
			}else {
				g.drawString("A non inclusive datasearch found no games that had the mean loss value",400,300);
			}
			
			//display best run so far
			g.drawString("Network 1s best run had a loss of:",400,325);
			g.drawString(String.valueOf(sortVs),600,325);
			g.drawString("Which had the index of:",400,350);
			g.drawString(String.valueOf(sortVi),600,350);
		}
		//reset color
		g.setColor(Color.BLUE);
	}
	
	/**Uploads the neural network after the game was run
	 *no paramater, just defines a new variable
	 *@returns a 2d string array with the content of the files
	*/
	public String[][] uploadnetworks() {
        File arrayfile = new File("networkfile1.txt");
        String[][] numStrings = new String[1][3];
        String[] CStrings;
        String[][] C2Strings= new String[1][3];
        try {
        	Scanner Reader = new Scanner(arrayfile);
	        while (Reader.hasNextLine() ){
	            String token1 = Reader.nextLine();
	            // put each value into an array with String#split();
	            CStrings = token1.split(" : ");
	            C2Strings[0] = CStrings;
	            // parse number string into doubles 
	            numStrings = stringappend(numStrings,C2Strings);
	        }
            Reader.close();
        } catch (IOException e) {
	        System.out.println("A file error occurred.");
	        e.printStackTrace();
	    }
		//return a 2d string array
		return numStrings;
		
	}
	/**calls the upload method and turns it into a double array
	 *no parameter, just defines a new variable
	 *@returns a 2d string array with the content of the files
	*/
	public double[][][] parsenetwork(int quality) {
		//uploads the data into a string
		String[][] Fullstringlistdoc = uploadnetworks();
		String Fullstringarray = Fullstringlistdoc[quality][2];
		int score = Integer.parseInt(Fullstringlistdoc[quality][0]) ;
		//breaks the data into 3 components
		double[][] scored = new double[1][1];
		scored[0][0] = score;
		int index = Integer.parseInt(Fullstringlistdoc[quality][1]) ;
		double[][] indexd = new double[1][1];
		indexd[0][0] = index;
		String[] Halfstringarray = Fullstringarray.split("], ");//splits 2d stringformat into 1d string array 
		String Quarterstring;
		double[][] Fulldouble = new double[8][6];
		for(int i = 0; i < Halfstringarray.length; i++) { //for each internal array
			Quarterstring = Halfstringarray[i].replaceAll("\\]", " ").replaceAll("\\[", " "); //clean it up
			String[] Quarterstringarray = Quarterstring.split(","); //turn it into an actual string array
			double[] Quarteredoublearray = new double [Quarterstringarray.length]; //create a double
			for(int j = 0; j < Quarterstringarray.length; j++) { //for the length of an internal array
				Quarteredoublearray[j] = Double.parseDouble(Quarterstringarray[j]); //fill the double with string array
			}
			Fulldouble[i] = Quarteredoublearray; //puts the double in the bigger double
		}
		double[][][] tripledouble = {scored,indexd,Fulldouble};
		return tripledouble;
	}
	
	
	/** 4d sorting algorithm
	 *sorts the data that was collected in the upload and parse steps
	*/
	public double[][][][] sortfile() {
		double[][][][] fourdouble = new double[GameMain.ball.sess()][ parsenetwork(1).length][parsenetwork(1)[0].length][parsenetwork(1)[0][0].length];
		//creates a 4d double from calling parse network which calls upload network
		for(int i = 0; i <fourdouble.length ; i++) {
			if(parsenetwork(i+1)[2].length > 0) {
				fourdouble[i] = parsenetwork(i+1);
			}
		}
		
		for (int i = 0; i < fourdouble.length; i++){//iterates through row
            int selection = i;   //selects the index
            for (int j = i+1; j < fourdouble.length; j++) {//iterates through column
                if (fourdouble[j][0][0][0] < fourdouble[selection][0][0][0]) {//checks if iteration is less than selection
                	selection = j;
                }
            }
            //swaps with selection
            double[][][] temp = fourdouble[selection];
            fourdouble[selection] = fourdouble[i];
            fourdouble[i] = temp;
        }
		return fourdouble;
    }
		
	
	/**Calculates the mean of the data in the file
	 *sorts the data that was collected in the upload and parse steps, then averages it
	 *@returns the mean loss of the dataset
	*/
	public int mean() {
		int sum = 0;
		double[][][][] bestnw = sortfile();
		//iterates through loop adding the data
		for (int i = 0; i< bestnw.length; i++) {
			sum += bestnw[i][0][0][0];
		}
		return sum /bestnw.length;
	}
	
	
	/**Calculates the mean of the data in the file
	 *sorts the data that was collected in the upload and parse steps, then averages it
	 *@returns the mean loss of the dataset
	*/
	public int Search(double search){//note**this code dosent run that often because the odds of the mean being run is very low. To test it you can change it to the median or maximum if you would like to.
		double[][][][] bestnw = sortfile();
		int EndLength = bestnw.length -1;
		int StartLength = 0;
		int guess = (EndLength - StartLength) / 2; //make a guess(half of bounds)
		while(StartLength < EndLength) {
				if(bestnw[guess][0][0][0] == search) { //if the guess is correct The following code runs.									
					return (int) bestnw[guess][1][0][0];
				}else if (bestnw[guess][0][0][0] > search) { //if the guess is bigger than the integer we are searching for
					EndLength = guess - 1;	//set the guess as the upper bound
					guess = (EndLength - StartLength) / 2; //set the guess to the middle of the bounds
					continue;
				}else if (bestnw[guess][0][0][0] < search){ //if the guess is smaller than the integer we are searching for
					StartLength = guess + 1;//set the guess as the lower bound
					guess = (EndLength + StartLength) / 2; //set the guess to the middle of the bounds
					continue; 
				}
				if (StartLength > EndLength) { //if the bounds move over each other
					break;
				}
		 }
		return 0;
	}
	

	/**Re trains the weights of the network
	 *sorts the data that was collected in the upload and parse steps, then selects the best one
	 *@returns the retrained weights
	*/
	public double[][] Trainweights(){
		 double[][][][] bestnw = sortfile();
		 double[][] weights = bestnw[0][2];
		for (int i = 0; i < weights.length -1; i++) { //iterates through columns
		    for (int j = 0; j < weights[i].length ; j++) {//iterates through rows
		      	double random = new Random().nextDouble(); 
		        weights[i][j] = weights[i][j] + (-1*epsilon) + (random * (epsilon - (-1*epsilon) )); //generates a random value between the epsilons
		    }
		}
		epsilon /= 1.0001;//decreases epsilon 
		return weights;
	}
	
	/** Downloads the Neural network
	 *downloads the neural network with the score and index after its ran.
	*/
	public void downloadnetworks() {
		int[] Score2 = GameMain.ball.getScore1();
		int session = GameMain.ball.sess();
	    try {
	        FileWriter Writer = new FileWriter("networkfile1.txt", true);
	        //writes the data to the file
	        Writer.write(Score2[session] + " : "+ session +" : " + Arrays.deepToString(weights) + "\n");
			Writer.close();
	      } catch (IOException e) {
	        System.out.println("A file error occurred.");
	        e.printStackTrace();
	      }
	}
	

	
	/**Uses recursion to calculate the dot product of the weight and input vectors
	 *@returns the dot product of the two vectors
	*/
	public double dot(double inputs[], double weights[] , int i) {
		if(i == 0) {
			return inputs[0]*weights[0];
		}else {
			return (inputs[i] * weights[i]) + dot(inputs,weights,i-1);
		}
	}
	
	/**calculates the sigmoid product of the dot product of the two vectors
	 *@returns the sigmoid product of the two vectors
	*/
	public double sigmoid(double alpha) {
		double e =2.71828182; 
		return 1/(1+Math.pow(e,alpha));
	}
	
	
	/**Uses SVM concepts to create a neural network
	 *@returns a 1 or -1 or 0 depending on its decision
	*/
	public int Neuralnetwork() {
		//creates a vector of all inputs
		double[] inputs = {GameMain.ball.getX() , GameMain.ball.getY(), GameMain.ball.getxa(),GameMain.ball.getya(), x, 1};
		int i = (weights[0].length) -1;
		//creates a node from the dot product of the inputs and the weights
		double alpha1 = dot(inputs, weights[0] , i);
		double alpha2 = dot(inputs, weights[1] , i);
		double alpha3 = dot(inputs, weights[2] , i);
		double alpha4 = dot(inputs, weights[3] , i);
		double alpha5 = dot(inputs, weights[4] , i);
		double alpha6 = dot(inputs, weights[5] , i);
		//uses the nodes as the next input
		double[] Layer2 = {sigmoid(alpha1) ,sigmoid(alpha2),sigmoid(alpha3),sigmoid(alpha4),sigmoid(alpha5),sigmoid(alpha6)  ,  1};
		//gets the product from the dot product of the nodes and weights
		double alphaB1 = dot(Layer2, weights[6] , i);
		double alphaB2 = dot(Layer2, weights[7] , i);
		//gets the output product
		double[] output = {sigmoid(alphaB1) ,sigmoid(alphaB2)};
		//returns a decision based on the outputs
		if(output[0] > output[1]) {
			return 1;
		}else if(output[0] < output[1]) {
			return -1;
		}else {
			return 0;
		}
	}
	
	/**When the game ends redefine the weights based on how many sessions have occured
	 * calls download networks
	 *@returns the weights
	*/
	public void gameover() {
		downloadnetworks();
		if(GameMain.ball.sess() < 75) {
			weights = randomizeweights();
		}else {
			weights = Trainweights();
		}
	}	
	
	/**Uses a new array to generate a second one
	 *@returns the new array with the other one appended onto the end
	*/
    public static String[][] stringappend(String[][] initial, String[][] added)  {
    	String[][] appendedarray = new String[initial.length + added.length][];//create a temporary appended array the length of the two arrays put together
        System.arraycopy(initial, 0, appendedarray, 0, initial.length);
        System.arraycopy(added, 0, appendedarray, initial.length,added.length);
        return appendedarray;
    }

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	
	/**get method to return the value
	 *@returns Y position of the Racket
	*/
	public int getTopY() {
		return Y;
	}
	/**get method to return the value
	 *@returns X position of the Racket
	*/
	public int getTopX() {
		return x;
	}
}