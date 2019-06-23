package ui;

import java.awt.*;
import javax.swing.*;
import maze.MazeGame;


/**
 * A simple GUI for the Maze Game.
 */
@SuppressWarnings("serial")
public
class
GUI extends JFrame
//GUI extends JFrame implements UI
{
    private
    MazeGame
    game;


    private
    JLabel[][]
    	tile;


    /** 
     * Initializes a GUI for the given MazeGame.
     * @param game The MazeGame of this GUI 
     */
    public
    GUI(MazeGame game)
    {
        this.game = game;
    }


    /** 
     * Returns the MazeGame of this GUI.
     * @return the MazeGame of this GUI
     */
    public
    MazeGame
    getGame()
    {
        return game;
    }


    // @Override
    public
    void
    launchGame()
    {
        int numRows = game.getNumRows();
        int numCols = game.getNumCols();
        
        Container c = this.getContentPane();
        c.setLayout(new GridLayout(numRows, numCols));
        tile = new JLabel[numRows][numCols];

        GUIListener listener = new GUIListener(this);
        this.addKeyListener(listener);

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                tile[i][j] = new JLabel();
                tile[i][j].setText("" + game.get(i,
                									j).toString());                
                tile[i][j].setFont(new Font(null,
                							   Font.BOLD, 18));
                tile[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                tile[i][j].setVerticalAlignment(SwingConstants.CENTER);
                c.add(tile[i][j]);
            }
        }
        setVisible(true);
        pack();
    }

    // @Override
    public
    void
    displayWinner()
    {
        int won = game.hasWon();        
        String message;
        if (game.isBlocked())
        {
        		// Tie
            message = "Game over! Both players are stuck.";
        }
        else
        {
        		// Game is still on.
            if (won == 0)
            {
                return;
            }
            else if (won == 1)
            {
            		int playerOneNumMoves = game.getPlayer1().getNumMoves();
            		message = "Congratulations Player 1! You won the maze in " +
            				  playerOneNumMoves +
            				  " moves.";
            }
            else if (won == 2)
            {
            		int playerTwoNumMoves = game.getPlayer2().getNumMoves();
            		message = "Congratulations Player 2! You won the maze in " +
            				  playerTwoNumMoves +
            				  " moves.";
            }
            else
            {
            		// Tie Game
                message = "It's a tie!";
            }
        }        
        JOptionPane.showMessageDialog(null, message);
        setVisible(false);
    }


    /** Update the grid display. */
    public
    void
    updateLabels()
    {
        int numRows = game.getNumRows();
        int numCols = game.getNumCols();

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                tile[i][j].setText(game.get(i,
                							   j).toString());
            }
        }
        displayWinner();
    }
}
