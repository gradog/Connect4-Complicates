package games;
import logic.Board;
import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public abstract class GameRules {
	protected Piece winner;
	protected Board board;
	protected boolean finish;
	
	
	/**
	 * GameRules constructor that initializes the chip 
	 * and creates a new board based on the game being played
	 * @param fila
	 * @param col
	 */
	public GameRules (int row, int col){
		winner = Piece.EMPTY;
		finish = false;
		board = new Board (row, col);
	}

	
	public abstract Piece winner ();
	
	public abstract Board prepareBoard ();
	
	public abstract boolean checkWinner (Board board, Move mov);
	
	public abstract boolean tie (Board board, Move mov);
	
	public abstract boolean validMove (Board board, Move mov);
	
	public abstract String drawBoard ();

	
}
