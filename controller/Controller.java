package controller;
import java.util.Scanner;

import games.ComplicatesMove;
import games.ComplicatesRules;
import games.Connect4Move;
import games.Connect4Rules;
import games.Move;
import logic.Game;
import logic.Piece;
import logic.TypeofGame;


/**
 * 
 * @author Guillermo Romero Alonso
 * 
 * controls the execution of the application, 
 * asking the user what he wants to do and updating the game according to what it indicates
 *
 */
public class Controller {
	private Game game; 
	private Scanner in;
	private TypeofGame gameName;
	
	
	/**
	 * controller's constructor
	 * @param input
	 */
	public Controller (Scanner input){
		game = new Game(new Connect4Rules());
		gameName = TypeofGame.CONNECT4;
		in = input;
	}
	
	/**
	 * Starts the game showing an interface where the user can choose some options and start playing
	 * By default it starts running Connect 4
	 */
	public void run(){	
		String input;
		int col;
		boolean ok;
		boolean finish = false;
		Move mov = null;	

		System.out.println ("WELCOME TO " + gameName);
		
		while (!finish){
			// Shows the board, the turn and asks the user to insert a piece
			System.out.println (game.drawBoard());
			System.out.println (game.getPlayer() + " are playing.");
			System.out.print ("Choose an option (put, undo, restart, play c4, play co, exit): ");
			input = in.nextLine();
			
			switch (input){
			case "put":	
	
				do{
					System.out.print ("Put in column: ");
					col =  in.nextInt()-1;
					in.nextLine();
					
					if (gameName == TypeofGame.CONNECT4)
						 mov = new Connect4Move(col, game.getTurn(), Piece.EMPTY);
					else 
						 mov = new ComplicatesMove(col, game.getTurn(), Piece.EMPTY);
					
					ok = game.validMove(mov);
					
					if (!ok)
						System.out.println("ERROR!: the column is not valid. Try again.");
					else {
						game.move(mov);
						
						if (game.finished(mov)){
							System.out.println (game.drawBoard() + "\n" + game.getPlayer() + " win");
							finish = true;			
						}
						else if (game.tie(mov)){
							System.out.println (game.drawBoard() + "\n Tie! Game Over");
							finish = true;
						}
					}
				} while (!ok);
				
				break;
				
				
			case "play c4":
				gameName = TypeofGame.CONNECT4; 
				game = new Game (new Connect4Rules());
				System.out.println ("\nWELCOME TO " + gameName);
				
				break;
				
				
			case "play co":
				gameName = TypeofGame.COMPLICATES; 
				game = new Game(new ComplicatesRules());
				System.out.println ("\nWELCOME TO " + gameName);
				
				break;
				
				
			case "undo":
				if (!game.undo(mov))
					System.out.println ("ERROR!: you can not undo more moves.");
					
				break;
				
				
			case "restart":
				if (gameName == TypeofGame.CONNECT4)
					game = new Game(new Connect4Rules());
				else
					game = new Game(new ComplicatesRules());
				System.out.println ("\nWELCOME TO " + gameName);
				
				break;
				
				
			case "exit":
				System.out.print ("\nYou abandoned the game. See you!");
				finish = true;
				
				break;
			
				
			default:
				System.out.println ("Unknown command. Try again.\n");
				
				break;
			}
		}
	}
	
}
