package games;
import logic.Board;
import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public class Connect4Rules extends FamilyC4Rules{
	public static final int ROWS = 6;
	public static final int COLUMNS = 7;
	
	
	/**
	 * ComplicatesRules constructor that calls the superclass constructor (FamilyC4Rules)
	 * giving the dimensions of the board
	 */
	public Connect4Rules(){
		
		super(ROWS, COLUMNS);
	}
	
	
	/**
	 * Given the board and the last move performed,
	 * checks if the move is valid
	 * @param board
	 * @param mov
	 * @return
	 */
	public boolean validMove(Board board, Move mov){
		
		return (mov.col >= 0 && 
				mov.col < board.getWidth() && 
				board.getPiece (0, mov.col) == Piece.EMPTY && 
				!tie (board, mov));
	}	
	
	
	/**
	 * Given the last move performed, checks if
	 * there is a winner
	 */
	public boolean checkWinner (Board board, Move mov){	
		if (checkColumns (mov.row, mov.col, mov) ||  checkRows (mov.row, mov.col, mov) || checkDiagonals (mov.row, mov.col, mov)) {
			finish = true;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Given the board and the movement performed on it,
	 * checks if there is a tie (the board is completely full)
	 * @return boolean
	 */
	public boolean tie (Board board, Move mov){
		int count = 0;
		
		for (int j = 0; j < board.getWidth(); j++){
			if (board.getPiece (0, j) != Piece.EMPTY)
				count++;
		}
			
		if (count == board.getWidth ()) {
			finish = true;
			return true;
		}
		else {
			return false;
		}
	}
	
}
