package games;
import logic.Board;
import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public class Connect4Move extends FamilyC4Moves {
	
	/**
	 * Connect4Move constructor that calls the superclass constructor (FamilyC4Moves)
	 * @param col
	 * @param turn
	 * @param lostPiece
	 */
	public Connect4Move (int col, Piece turn, Piece lostPiece) {
		super (col, turn, lostPiece); 
	}

	
	/**
	 * Performs a move over the board
	 * @param board
	 * @return if the pie was successfully placed
	 */
	public boolean move (Board board) {
		int row = board.getHigh()-1;
		
		// Searches for an empty position where to place a piece
		while (row >= 0){
			if (board.getPiece (row, col) == Piece.EMPTY){
				board.putPiece (row, col, turn);
				this.row = row;
				return true;
			}
			row--;
		}
		
		return false;
	}
	
	
	/**
	 * undo a movement over the board
	 */
	public void undo (Board board){
		boolean stop = false;
		int i = 0;
		
		// Goes through the column searching the piece to remove
		while (i < board.getHigh() && !stop){
			if (board.getPiece(i, col) != Piece.EMPTY){
				board.removePiece(i, col);
				stop = true;	
			}
			i++;
		}
	}
}
