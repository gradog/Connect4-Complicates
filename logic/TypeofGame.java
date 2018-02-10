package logic;


/**
 * 
 * @author Guillermo Romero Alonso
 *
 */
public enum TypeofGame {CONNECT4, COMPLICATES;

	/**
	 * reads a variable of type TypeofGame 
	 * @return typeofGame the name of the game playing
	 */
	public String toString(){
		String typeofGame = "";
	
		switch (this){
			case CONNECT4:
				typeofGame = "CONNECT 4";
				
				break;
			
			case COMPLICATES:
				typeofGame = "COMPLIATES";
				
				break;
		}
	
		return typeofGame;
	}
}
