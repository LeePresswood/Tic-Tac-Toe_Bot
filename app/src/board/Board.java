package board;

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
	}
	
	/**
	 * Print every row of the board. Automatically adds in spacing and lines.
	 */
	public void printBoard()
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
				char c = 'W';
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
				
				//Print item, right border, and new line.
				System.out.print(c);
				System.out.print(' ');
			}
			
			//New line for grid pattern.
			System.out.print('\n');
		}
	}
}
