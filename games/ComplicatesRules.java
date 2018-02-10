package games;
import logic.Board;
import logic.Piece;


/**
 * 
 * @author  * @author Guillermo Romero Alonso

 *
 */
public class ComplicatesRules extends FamilyC4Rules {
	public static final int ROWS = 7;
	public static final int COLUMNS = 4;

	
	/**
	 * ComplicatesRules constructor that calls the superclass constructor (FamilyC4Rules)
	 * giving the dimensions of the board
	 */
	public ComplicatesRules(){
		super(ROWS, COLUMNS);
	}
	
	
	/**
	 * Checks if a move is valid
	 * @param board board in where the game is being played
	 * @param mov movement performed on the board
	 * @return
	 */
	public boolean validMove (Board board, Move mov){
		
		return (mov.col >= 0 && mov.col < board.getWidth());
	}
	
	
	/**
	 * checks if there is a winner 
	 * @param board
	 * @param mov
	 */
	public boolean checkWinner (Board board, Move mov){
		int columns = 0;
		int rows = 0;
		int diagonals = 0;
		
		for (int i = 0; i < ROWS; i++){
			for (int j = 0; j < COLUMNS; j++){
				
				if (board.getPiece(i, j) != Piece.EMPTY){
					if (checkColumns(i, j, mov))
						columns++;
					else if (checkRows(i, j, mov))
						rows++;
					else if (checkDiagonals(i, j, mov))
						diagonals++;
				}
			}
		}

		if ((columns >= 1 && rows == 0 && diagonals == 0) || 
			(columns == 0 && rows == 4 && diagonals == 0) || 
			(columns == 0 && rows == 0 && diagonals == 4))
			finish = true;
		
		return finish;
	}
	
	
	/**
	 * Complicates game can never end in tie
	 */
	public boolean tie (Board board, Move mov){		
		
		return false;
	}
	
}
