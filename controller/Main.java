package controller;
import java.util.Scanner;


/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * It is the class that contains the main method of the application. 
 * In this case the main method simply creates an empty game, 
 * creates a controller with that game, and invokes the controller's run method.
 *
 */
public class Main {
	
	public static void main (String[] args) {	
		Scanner input = new Scanner(System.in);
		Controller controller = new Controller (input);
		
		controller.run();
		input.close();
	}
}
