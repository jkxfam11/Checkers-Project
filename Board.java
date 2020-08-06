import java.awt.*;
import java.io.*;
import javax.swing.*;

/*
 * Authors: Harold Pham and Kevin Xu
 * Creation Date: 8/6/2020
 * File Details: Will be the Board class that constructs every new game and holds game data.
*/
public class Board 
{
//VARIABLES
	public int currentPlayer; //0 == BLACK/P1   1 = RED/P2
	public int currentTurn;
	DrawingPanel p;
	Graphics g;
	
//CONSTRUCTORS
	public Board() //Default construction
	{
		currentPlayer = 0;
		currentTurn = 1;
		
		//Create the Window Objects
		p = new DrawingPanel(700,500);
		g = p.getGraphics();
		Image p1B = p.loadImage(new File("CheckerBoard.jpg")); 
				
		//Set the Colors
		p.setBackground(Color.BLUE);
		g.setColor(Color.BLACK);
				
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		
	}
	
//METHODS
	
//Accessor Methods
	public int turn()
	{
		return currentTurn;
	}
	
	public int player()
	{
		return currentPlayer;
	}
	
//Mutator Methods
	public void nextPlayer()
	{
		if(currentPlayer == 0)
			currentPlayer = 1;
		else
			currentPlayer = 0;
	}
	
	public void nextTurn()
	{
		currentTurn++;
	}
	
//Misc. Methods
	//Converts our binary player variable into a String at a given spot on the window.
	public void displayPlayer(int x, int y)
	{
		if(currentPlayer == 0)
			g.drawString("P1",x,y);
		else
			g.drawString("P2",x,y);
	}
	
}
