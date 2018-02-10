package logic;

import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso

 *
 */
public class Board {
	private Piece[][] board;
	private int high;
	private int width;
	
	
	/**
	 * Board constructor that establish the board dimensions and prepares an empty board
	 * @param rows
	 * @param columns
	 */
	public Board(int rows, int columns){
		high = rows;
		width = columns;
		board = new Piece[high][width];
		prepareBoard();
	}
	
	
	/**
	 * fill the board of empty pieces
	 */
	public void prepareBoard(){
		for (int i = 0; i < high; i++){
			for (int j = 0; j < width; j++){
				removePiece(i, j);
			}
		}
	}
	
	
	/**
	 * Given a position on the board return the piece placed on it
	 * @param row
	 * @param col
	 * @return board[row][col]
	 */
	public Piece getPiece(int row, int col) {
		
		return board[row][col];
	}
	
	
	/**
	 * gives the boards high
	 * @return high
	 */
	public int getHigh(){
		
		return high;
	}
	
	
	/**
	 * gives the boards width
	 * @return width
	 */
	public int getWidth(){
		
		return width;
	}
	
	
	/**
	 * given a position, removes the piece on that position
	 * @param row
	 * @param col
	 */
	public void removePiece(int row, int col){
		
		board[row][col] = Piece.EMPTY;
	}

	
	/**
	 * given a position, puts a piece on that position
	 * @param row
	 * @param col
	 * @param color
	 */
	public void putPiece (int row, int col, Piece color) {
		board[row][col] = color;

	}
	
	
	/**
	 * draw the board
	 * @return a string (output) containing the board structure
	 */
	public String draw() {
		String output = "\n";
		
		for (int i = 0; i <= high; i++){
			for (int j = -1; j <= width; j++){
				
				// left side
				if (j == -1) {
					if (i == high)
						output += "+";		
					else
						output += "|";
				}
				// rigth side
				else if (j == width) { 
					if (i == high)
						output += "+\n";
					else
						output += "|\n";	
				}
				// floor and pieces
				if (j > -1 && j < width && i == high)
					output += "-";		
				else if (i < high && j >= 0 && j < width )
					output += board[i][j].toString();	
			}
		}
		
		output += " ";
		for (int j = 1; j <= width; j++) {
			output += j;
		}
		
		return output + "\n";
	}
	
}
