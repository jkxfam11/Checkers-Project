/*
 * Authors: Harold Pham and Kevin Xu
 * Creation Date: 8/6/2020
 * File Details: Will be the Board class that constructs every new game and holds game data.
*/

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Board 
{
//VARIABLES
	public int currentPlayer = 0; //0 == WHITE/P1   1 = BLACK/P2
	//private static int final 
	//int white = 0; int black =1;
	public int currentTurn;
	
//CONSTRUCTORS
	public Board() //Default construction
	{
		//Create the Objects
				DrawingPanel p = new DrawingPanel(700,500);
				Graphics g = p.getGraphics();
				Image p1B = p.loadImage(new File("Board.jpg")); 
				
				//Set the Colors
				p.setBackground(Color.BLUE);
				g.setColor(Color.BLACK);
				
				g.drawImage(p1B,100,0,p); //Makes the checker Board
				
	}
	
//METHODS
	
	
}
