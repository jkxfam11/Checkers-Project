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
	private int currentPlayer; //0 == BLACK/P1   1 = RED/P2
	private int currentTurn;
	private DrawingPanel p;
	private Graphics g;
	private Image p1B;
//CONSTRUCTORS
	public Board() //Default construction
	{
		currentPlayer = 0;
		currentTurn = 1;
		
		//Create the Window Objects
		p = new DrawingPanel(700,500);
		g = p.getGraphics();
		p1B = p.loadImage(new File("CheckerBoard.jpg")); 
		
		p.setAlwaysOnTop(true);
		
		//Set the Colors
		p.setBackground(Color.gray);
		g.setColor(Color.BLACK);
		
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		//Set the Player Turn Display
		g.drawRect(1, 18, 96, 35);
		displayPlayer(1,15);
		
		//Set the Current Turn Display
		g.drawRect(601, 13, 97, 40);
		g.drawString("Turn: " + currentTurn, 605, 38);
		
		Pieces pieces = new Pieces(g);
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
	
	public void nextRound()
	{
		p.clear();//Clear the board
		
		//Change turns and players
		nextTurn(); 
		nextPlayer();
		
		//Refresh everything
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		//Set the Player Turn Display
		g.drawRect(1, 18, 96, 35);
		displayPlayer(1,15);
		
		//Set the Current Turn Display
		g.drawRect(601, 13, 97, 40);
		g.drawString("Turn: " + currentTurn, 605, 38);
		
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
