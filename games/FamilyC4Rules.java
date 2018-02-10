package games;
import logic.Board;
import logic.Piece;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public abstract class FamilyC4Rules extends GameRules {
	
	/**
	 * ComplicatesRules constructor that calls the superclass constructor (GameRules)
	 * giving the dimensions of the board
	 */
	public FamilyC4Rules(int row, int col) {
		super(row, col);
	}
	
	
	/**
	 * prepares an empty board for a new game
	 * @return the board prepared
	 * 
	 */
	public Board prepareBoard(){
		board.prepareBoard();;
		
		return board;
	}
	
	
	/**
	 * Tells who is the winner
	 * @return Piece
	 */
	public Piece winner(){
		
		return winner;
	}
	
	
	/**
	 * @return board.draw() returns the board picture
	 */
	public String drawBoard() {
		
		return board.draw();	
	}
	
	
	/**
	 * Sets the winner of the game
	 * @param mov
	 * @param fila
	 * @param col
	 */
	private void setWinner(int row, int col){
		
		winner = board.getPiece(row, col);
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks whether there are 4 pieces of the same player placed consecutive the same row
	 * @return if there are 4 pieces of the same player place consecutive in the same row
	 */
	protected boolean checkColumns(int r, int c, Move mov){
		// get the position of the last piece placed
		int row = r;
		int col = c;
		int count = 0;
				
		// checks pieces on the same column
		while (row < r-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col)){			
			count++;
			row++;
		}
			
		if (count == 3) {
			setWinner (r, c);
			return true;
		}
		else
			return false;
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks whether there are 4 pieces of the same player placed consecutive the same column
	 * @return if there are 4 pieces of the same player place consecutive in the same column
	 */
	protected boolean checkRows(int r, int c, Move mov){
		int row = r;
		int col = c;
		int count = 0;
		
		// checks pieces on the same row (to the right)
		while (col < c-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row, col+1)){
			count++;
			col++;
		}

		
		row = r;
		col = c;
		// checks pieces on the same row (to the left)
		while (col > 0 && count < 3 && board.getPiece(row, col) == board.getPiece(row, col-1)){
			count++;
			col--;
		}
		
		if (count == 3) {
			setWinner (r, c);
			return true;
		}
		else
			return false;
	}
	
	
	/**
	 * given the position of the last piece paced
	 * checks if there are 4 pieces of the same player placed consecutive the same diagonal
	 * @return if there are 4 pieces of the same player place consecutive in the same diagonal
	 */
	protected boolean checkDiagonals(int r, int c, Move mov) {
		int row = r;
		int col = c;
		int count = 0;
		
		// check right diagonal (downwards)
		while (col > 0 && row < r-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col-1)){
			count++;
			row++;
			col--;
		}	
		
		row = r;
		col = c;
		// check right diagonal (upwards)
		while (col < c-1 && row > 0 && count < 3 && board.getPiece(row, col) == board.getPiece(row-1, col+1)){
			count++;
			row--;
			col++;
		}
		
		if (count == 3) {
			setWinner (r, c);
			return true;
		}
		

		row = r;
		col = c;
		count = 0;
		// check left diagonal (downwards)
		while (col < c-1 && row < r-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row+1, col+1)){
			count++;
			row++;
			col++;
		}
	    
		row = r;
		col = c;
		// check left diagonal (upwards)
		while (col > 0 && row < r-1 && count < 3 && board.getPiece(row, col) == board.getPiece(row-1,col-1)){
			count++;
			row--;
			col--;
		}
		
		if (count == 3) {
			setWinner (r, c);
			return true;
		}
		else
			return false;
	}

}
