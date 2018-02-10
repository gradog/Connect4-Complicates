package games;

import logic.Board;
import logic.Piece;

/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public abstract class FamilyC4Moves extends Move{

	
	/**
	 * FamilyC4Moves constructor that calls the superclass constructor (Move)
	 * @param col
	 * @param turn
	 * @param lostPiece
	 */
	public FamilyC4Moves(int col, Piece turn, Piece lostPiece) {
		super(col, turn, lostPiece);
	}
	

	/**
	 * returns the piece placed at [row][col] on the board
	 * @param board
	 * @param row
	 * @param col
	 * @return Piece
	 */
	public Piece getPiece(Board board, int row, int col) {
		if (row >= 0 && row < board.getHigh() && col >= 0 && col < board.getWidth())
			return board.getPiece(row, col);
		else
			return null;
	}	

}
