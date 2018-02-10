package logic;

import games.GameRules;
import games.Move;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public class Game {
	private Board board;  
	private Piece turn;
	private GameRules rules;
	private Stack stack;
	
	
	/**
	 * Game constructor that initialize a game base on its rules
	 * @param rules
	 */
	public Game(GameRules rules){
		turn = Piece.WHITE;
		this.rules = rules;
		board = this.rules.prepareBoard();
		stack = new Stack();
	}

	
	/**
	 * Performs a movement given
	 * @param mov
	 * @return boolean
	 */
	public boolean move(Move mov){
		if (mov.move(board)){
			stack.push(mov);
			return true;
		}
		else
			return false;
	}		
	
	
	/**
	 * checks if the game has finished
	 * @param mov
	 * @return boolean
	 */
	public boolean finished (Move mov){
		
		if (rules.checkWinner(board, mov)){
			turn = rules.winner();
			return true;
		}
		else{
			turn = nextTurn();
			return false;
		}
	}
	
	
	/**
	 * Checks if there is a tie
	 * @param mov
	 * @return boolean
	 */
	public boolean tie (Move mov){
	
		return rules.tie(board, mov);
	}
	
	
	/**
	 * receives a move made by the player 
	 * and checks whether is valid
	 * @param mov
	 * @return boolean if the move is valid or not
	 */
	public boolean validMove (Move mov){
		
		return rules.validMove (board, mov);
	}
	
	
	/**
	 * undo a movement made over the board
	 * @param mov
	 * @return boolean that indicates if the undo operation 
	 * is successfully made
	 */
	public boolean undo (Move mov){

		if (stack.pop(mov)){
			mov = stack.top(mov);
			mov.undo(board);
			turn = nextTurn();
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * checks the turn of the game
	 * @return turn
	 */
	public Piece getTurn (){
		
		return turn;
	}
	
	
	/**
	 * check which player is playing
	 * @return string the name of the player
	 */
	public String getPlayer() {
		if (turn == Piece.WHITE)
			return "Whites";
		else
			return "Blacks";
	}
	
	
	/**
	 * Alternates between players
	 * @return Piece the turn that plays
	 */
	private Piece nextTurn(){
		if (turn == Piece.WHITE)
			return Piece.BLACK;
		else
			return Piece.WHITE;
	}
	
	
	/**
	 * calls board class to draw the board
	 * @return string containing the board
	 */
	public String drawBoard() {

		return rules.drawBoard();	
	}


}

