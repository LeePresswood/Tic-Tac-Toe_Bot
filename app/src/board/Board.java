package board;

import java.util.Scanner;

public class Board
{
	private final char BOARD_TOKEN_X = 'X';
	private final char BOARD_TOKEN_O = 'O';
	private final char BOARD_TOKEN_NONE = ' ';
	
	public BoardToken[][] board;
	
	public boolean first_turn;
	
	public Board()
	{
		board = new BoardToken[3][];		
		for(int i = 0; i < 3; i++)
		{
			board[i] = new BoardToken[3];
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = BoardToken.NONE;
			}
		}
		
		//We want the first player to go first.
		first_turn = true;
		
		//
	}
	
	/**
	 * Print every row of the board. Automatically adds in spacing and lines.
	 */
	private void printBoard()
	{		
		//Display turn information.
		System.out.print("Displaying Board: ");
		if(first_turn)
			System.out.print("(First Player)\n");
		else
			System.out.print("(Second Player)\n");
		
		//Display board.
		for(BoardToken[] row : board)
		{			
			//Print each item in the row.
			for(BoardToken token : row)
			{
				//Get the item type to print.
				char c = '.';
				switch(token)
				{
					case NONE:
						c = BOARD_TOKEN_NONE;
						break;
					case O:
						c = BOARD_TOKEN_O;
						break;
					case X:
						c = BOARD_TOKEN_X;
						break;
				}
				
				//Print item and gap.
				System.out.print(c);
				System.out.print(' ');
			}
			
			//New line for grid pattern.
			System.out.print('\n');
		}
	}

	/**
	 * Game loop.
	 */
	public void play()
	{
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		//Loop while game is not over.
		while(running)
		{
			//Display current state of board.
			printBoard();
			
			//Determine turn.
			if(first_turn)
			{//Player's turn.
				int value;
				do
				{
					//Get position.
					System.out.print("Enter space (1-9): ");
					value = scanner.nextInt();
				}while(!isValidPosition(value));
				
				//Place in position.
				board[(value - 1) / 3][(value - 1) % 3] = BoardToken.X;
			}
			else
			{//Bot's turn.
				
			}
			
			//Flip to next player's turn;
			first_turn = !first_turn;
			
			//Change running variable.
			running = !(hasWinner(1) || hasWinner(2));
		}
		
		//Display final board and win status.
		printBoard();
		if(hasWinner(1))
			System.out.println("Player 1 Wins!");
		else
			System.out.println("Player 2 Wins!");
		
		//Freeze game for analysis.
		System.out.println("Type any letter + Enter to close.");
		scanner.next();
		
		//End.
		scanner.close();
	}
	
	/**
	 * Player tried to place a value in this position Is it blank?
	 * @param value Single-level coordinate.
	 * @return True if board value is valid. False otherwise.
	 */
	private boolean isValidPosition(int value)
	{
		//Can't be less than 0 or greater than 9.
		if(value < 0 || value > 9)
			return false;
		
		//Check board. Value must be blank.
		return board[(value - 1) / 3][(value - 1) % 3] == BoardToken.NONE;
	}

	/**
	 * Score board for a winner.
	 * @return True if winner. False otherwise.
	 */
	private boolean hasWinner(int player)
	{
		BoardToken check;
		
		if(player == 1)	//X
			check = BoardToken.X;
		else					//O
			check = BoardToken.O;
		
		//Check the 8 different lines.
		//Vertical
		for(int i = 0; i < 3; i++)
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
			return true;
		
		//No win.
		return false;
	}
}
