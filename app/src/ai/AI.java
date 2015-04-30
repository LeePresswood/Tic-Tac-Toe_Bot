package ai;

import board.Board;
import board.BoardToken;

public class AI
{
	/**
	 * Using the board, determine the best position to play.
	 * @param board_holder Instance of the board manager.
	 * @return One-dimensional coordinate for the board.
	 */
	public static int play(Board board_holder)
	{
		BoardToken[][] board = board_holder.board;
		
		/* Rule 1: If I have a winning move, take it.
		 *	Rule 2: If the opponent has a winning move, block it.
		 *	Rule 3: If I can create a fork (two winning ways) after this move, do it.
		 * Rule 4: Do not let the opponent creating a fork after my move. (Opponent may block your winning move and create a fork.)
		 * Rule 5: Place in the position such as I may win in the most number of possible ways.
		 */
		int return_value = ruleOne(board);
		/*if(return_value == 0)
			return_value = ruleTwo(board);
		if(return_value == 0)
			return_value = ruleThree(board);
		if(return_value == 0)
			return_value = ruleFour(board);
		if(return_value == 0)
			return_value = ruleFive(board);*/
		
		//Error in finding position.
		return return_value;
	}	
	
	private static int ruleOne(BoardToken[][] board)
	{
		//Check the 8 different lines.
		//Vertical
		/*for(int i = 0; i < 3; i++)
			if(board[0][i] == check && board[1][i] == check && board[2][i] == check)
				return true;
		
		//Horizontal
		for(int i = 0; i < 3; i++)
			if(board[i][0] == check && board[i][1] == check && board[i][2] == check)
				return true;
		
		//Diagonal
		if(board[0][0] == check && board[1][1] == check && board[2][2] == check)
			return true;
		if(board[2][0] == check && board[1][1] == check && board[0][2] == check)
			return true;*/
		
		return 0;
	}
}
