package games;

import logic.Board;
import logic.Piece;

/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public class ComplicatesMove extends FamilyC4Moves {
	
	/**
	 * ComplicatesMove constructor that calls the superclass constructor (FamilyC4Moves)
	 * @param col
	 * @param turn
	 * @param lostPiece
	 */
	public ComplicatesMove(int col, Piece turn, Piece lostPiece) {
		super(col, turn, lostPiece);
	}

	/**
	 * Performs a move over the board
	 * @return if the movement was successfully made
	 */
	public boolean move(Board board) {
		int row = board.getHigh()-1;
		
		while (row >= 0){
			// if the column is full, moves the pieces of the column downwards
			if (row == 0 && board.getPiece (row, col) != Piece.EMPTY){
				columnDown (board, col);
				board.putPiece(0, col, turn);
				this.row = 0;
				return true;
			}
			else if (board.getPiece (row, col) == Piece.EMPTY){
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
	public void undo(Board board){
		int row = 0;
		boolean stop = false;
		
		// if the column is full, moves the pieces of the column upwards
		if (board.getPiece(0, col) != Piece.EMPTY && lostPiece != Piece.EMPTY){
			board.removePiece (0, col);
			columnUp (board, col);
			board.putPiece (board.getHigh()-1, col, lostPiece);
		}
		else{
			while (row < board.getHigh() && !stop){
				if (board.getPiece (row, col) != Piece.EMPTY){
					board.removePiece (row, col);
					stop = true;
				}
				row++;
			}	
		}
	}
	
	
	/**
	 * Given a column, moves downwards all pieces on that column
	 * so it can make room to the new piece to place on
	 * @param board
	 * @param col
	 * @return lostPiece backup of the piece placed on the columns floor
	 */
	private void columnDown(Board board, int col){

		// backups the piece placed on the columns base
		this.lostPiece = board.getPiece(board.getHigh()-1, col);
		
		// moves downwards all pieces on the column
		for(int i = board.getHigh()-1; i > 0; i--)
			board.putPiece (i, col, board.getPiece(i-1, col));			
	}
	
	
	/**
	 * Given a column, moves upwards all pieces on that column
	 * so it can complete an "undo" operation
	 * this case happens when the column is full 
	 * and the user performs an "undo" operation
	 * @param board
	 * @param col
	 * @return fichaPerdida
	 */
	private void columnUp (Board board, int col){

		for(int i = 0; i < board.getHigh()-1; i++)
			board.putPiece (i, col, board.getPiece(i+1, col));
		
		// restores the lostPiece
		board.putPiece (board.getHigh()-1, col, lostPiece);
	}

}

