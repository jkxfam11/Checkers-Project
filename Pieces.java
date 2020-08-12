import java.awt.Color;
import java.awt.Graphics;
/*
 * Authors: Kevin Xu and Harold Pham
 * Creation Date: 8/11/2020
 * File Detail: The file will handle the piece behaviors within the checkers game board alongside with game logic. 
 * 
 */
import java.util.*;

public class Pieces 
{
	private final int EMPTY = 0;
	private final int RED = 1;
	private final int WHITE = 2;
	private final int RED_KING = 3;
	private final int BLACK_KING = 4;
	
	private int[][] board = new int[8][8]; //Defaults to empty spaces
	
	public Pieces(Graphics g, DrawingPanel p)
	{
		int w = 107;
		int h = 8;
    //populate red's pieces
		g.setColor(Color.red);
		for(int c = 0; c < 3; c++)
		{
				if(c % 2 == 1) //if it is an odd column
				{
					for(int r = 0; r < 8; r++)
					{
						if(r % 2 == 0)//then every even row space will have a piece
						{
							board[r][c] = 1;
							g.fillOval(62*r+w, 62*c+h, 50, 50);
						}
					}
				}
				else if(c % 2 == 0) //if it is an even column
				{
					for(int r = 0; r < 8; r++)
					{
						if(r % 2 == 1) //then every odd row space will have a piece
						{
							board[r][c] = 1;
							g.fillOval(62*r+w, 62*c+h, 50, 50);
						}
					}
				}	
		}
		
    //populate white's pieces
		g.setColor(Color.white);
		for(int c = 5; c < 8; c++) 
		{
				if(c % 2 == 1) //if it is an odd column
				{
					for(int r = 0; r < 8; r++)
					{
						if(r % 2 == 0)//then every even row space will have a piece
						{
							board[r][c] = 2;
							g.fillOval(62*r+w, 62*c+h, 50, 50);
						}
					}
				}
				else if(c % 2 == 0) //if it is an even column
				{
					for(int r = 0; r < 8; r++)
					{
						if(r % 2 == 1) //then every odd row space will have a piece
						{
							board[r][c] = 2;
							g.fillOval(62*r+w, 62*c+h, 50, 50);
						}
					}
				}	
		}
		
	}
	
  //Used for when pieces will move
	public void makeMove(int fromRow, int fromCol, int toRow, int toCol) 
		{
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = EMPTY;
            if (fromRow - toRow == 2 || fromRow - toRow == -2) 
            {
                // The move is a jump.  Remove the jumped piece from the board.
                int jumpRow = (fromRow + toRow) / 2;  // Row of the jumped piece.
                int jumpCol = (fromCol + toCol) / 2;  // Column of the jumped piece.
                board[jumpRow][jumpCol] = EMPTY;
            }
            
            if (toRow == 0 && board[toRow][toCol] == RED)
                board[toRow][toCol] = RED_KING;
            
            if (toRow == 7 && board[toRow][toCol] == BLACK)
                board[toRow][toCol] = BLACK_KING;
        }
}
