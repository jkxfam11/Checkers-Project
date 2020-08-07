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
		p.setBackground(Color.gray);
		g.setColor(Color.BLACK);
				
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		g.drawRect(1, 18, 96, 35);
		
		displayPlayer(1,15);
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
		if(currentPlayer == 0) //set to RED Player
			currentPlayer = 1;
		else
			currentPlayer = 0; //Set to BLACK Player
	}
	
	public void nextTurn()
	{
		currentTurn++;
	}
	
//Misc. Methods
	//Converts our binary player variable into a String at a given spot on the window.
	public void displayPlayer(int x, int y)
	{
		g.setFont(new Font("Monospaced", Font.BOLD,18));//Set text size/font
		
		g.drawString("Your turn", x, y); //Note: It was easier to just use two separate msgs.
		
		if(currentPlayer == 0)
			g.drawString("BLACK",x+23,y+26);
		else
		{
			g.setColor(Color.RED);
			g.drawString("RED",x+33,y+27);
			g.setColor(Color.BLACK);
		}
	}
		
	
	
	
}
