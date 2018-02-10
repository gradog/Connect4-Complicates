package logic;

import games.Move;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public class Stack {
	private Move[] undoStack;
	private int numUndo;
	private final int MAX_STACK = 10;

	/**
	 * Constructor of the stack
	 */
	public Stack (){
		undoStack = new Move[MAX_STACK];
		numUndo = 0;
	}
	
	
	/**
	 * push a new movement in the stack
	 * @param mov 
	 */
	public void push(Move mov){	
		if (numUndo < MAX_STACK){
			undoStack[numUndo] = mov;
			numUndo++;
		}
		else{	
			for (int i = 1; i < MAX_STACK; i++)
				undoStack[i-1] = undoStack[i];
			undoStack[MAX_STACK-1] = mov;
		}
	}
	
	
	/**
	 * Remove a movement from the stack
	 * @param mov
	 * @return boolean
	 */
	public boolean pop (Move mov){
		if (numUndo > 0){
			numUndo--;
			return true;
		}
		else 
			return false;

	}
	
	
	/**
	 * Get the movement placed at the top of the stack
	 * @return undoStack[numUndo]
	 */
	public Move top (Move mov){
		mov = undoStack[numUndo];
		
		return mov;
	}

}
