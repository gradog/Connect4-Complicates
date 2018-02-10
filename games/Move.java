package games;

import logic.Board;
import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public abstract class Move {
	protected int col;
	protected int row;
	protected Piece turn;
	protected Piece lostPiece;
	
	/**
	 * Move constructor that initialize some parameters
	 * @param col the column where to place a piece
	 * @param turn the turn of the player
	 * @param lostPiece 
	 */
	public Move(int col, Piece turn, Piece lostPiece){
		this.col = col;
		this.turn = turn;
		this.lostPiece = lostPiece;
	}
	
	public abstract boolean move (Board board);
	
	public abstract void undo (Board board);
	
	public abstract Piece getPiece (Board tab, int row, int col);
	
}
