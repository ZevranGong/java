package Moderate;
/**
 * @author Zevran
 *
 */
public class Main {
	public static void main(String args[]){
		Main m = new Main();
		
		//Test for 17.1
		m.swap(4,7);
		m.swap(0,-1);
		
		//Test for 17.2
		char[][] board1 = new char[3][3];
		//Check empty
		System.out.println(m.tictactoeChecker(board1));
		//Check row
		board1[2][2]=board1[1][1]=board1[0][0]='X'; 
		System.out.println(m.tictactoeChecker(board1));
		//Check column
		board1[0][1]=board1[1][1]=board1[2][1]='O'; 
		System.out.println(m.tictactoeChecker(board1));
		//Check row
		board1[2][1]=board1[2][0]=board1[2][2]=board1[0][1]='X';
		System.out.println(m.tictactoeChecker(board1));
		//Check no winner
		board1[2][0]='O';
		System.out.println(m.tictactoeChecker(board1));
	}

	/**
	 * 17.1
	 * Write a function to swap a number in place
	 * REVISE: XOR works better
	 * @param a 
	 * @param b
	 */
	public void swap (int a, int b){
		a += b; // a = a+b
		b = a - b; // b = a
		a -= b; // a = b
		System.out.println(a + "\t" + b);
	}
	
	/**
	 *  17.2 Design an algorithm to figure out if someone has won
	 *  	 a game of tic-tac-toe. Assume players use X and O as 
	 *  	 marker
	 * @return True if there is a winner, 
	 */
	public boolean tictactoeChecker(char[][] board){
		int counterRow, counterCol, counterDiag = 0;
		for (int i = 0; i < 3; i++){
			//Check i-th row
			counterRow = entryHelper(board,i,0)+entryHelper(board,i,1)+entryHelper(board,i,2);
			//Check i-th colum
			counterCol = entryHelper(board,0,i)+entryHelper(board,1,i)+entryHelper(board,2,i);
			//Check i-th diagonal if applicable
			if (i%2==0){
				counterDiag = entryHelper(board,i,i)+entryHelper(board,1,1)+entryHelper(board,2-i,2);
			}
			if (Math.abs(counterRow)==3 || Math.abs(counterCol)==3 || Math.abs(counterDiag)==3){
				return true;
			}
		}
		return false;
	}
	
	/** Check the entry on a 2d board, assuming the entry could be X, O, or empty char.
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	private int entryHelper(char[][] board,int row, int col){
		if (board[row][col]=='X'){
			return 1;
		} else if (board[row][col]=='O'){
			return -1;
		}
		return 0;
	}
}