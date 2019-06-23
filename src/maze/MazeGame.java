package maze;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * A class that represents the basic functionality of the maze game.
 * This class is responsible for performing the following operations:
 *
 *     1. At creation, it initializes the instance variables used to store the
 *        current state of the game.
 *
 *     2. When a move is specified, it checks if it is a legal move and makes the
 *        move if it is legal.
 *
 *     3. It reports information about the current state of the game when asked.
 */
public
class
MazeGame
{
    // A random number generator to move the MobileBananas.
//    private
//    Random
//    random;
    

    // The maze grid.
    private
    Grid<Sprite>
    maze;


	private
    Monkey
    // The first player.
    player1,
    // The second player.
    player2;

    // The bananas to eat.
    private
    List<Banana>
    bananas;


    /**
     * Creates a new MazeGame that corresponds to the maze in the file
     * named layoutFileName.
     * @param layoutFileName the path to the input maze file
     */
    public
    MazeGame(String layoutFileName) throws IOException
    {

        // A random number generator to move the MobileBananas.
        Random random = new Random();
        int[] dimensions = getDimensions(layoutFileName);
        maze = new ArrayGrid<Sprite>(dimensions[0],
        								dimensions[1]);
        Scanner sc = new Scanner(new File(layoutFileName));

        /* INITIALIZE THE GRID HERE */
    
        sc.close();
    }


    /**
     * Returns the dimensions of the maze in the file named layoutFileName.
     * @param layoutFileName the path of the input maze file
     * @return an array [numRows, numCols], where numRows is the number
     * 		   of rows and numCols is the number of columns in the maze that
     * 		   corresponds to the given input maze file
     * @throws IOException
     */
    private
    int[]
    	getDimensions(String layoutFileName) throws IOException
    {
        Scanner sc = new Scanner(new File(layoutFileName));
        // Finds the number of columns.
        String nextLine = sc.nextLine();
        int numCols = nextLine.length();
        int numRows = 1;

        // Finds the number of rows
        while (sc.hasNext())
        {
            numRows++;
            nextLine = sc.nextLine();
        }
        sc.close();

        return new int[]{numRows,
        					numCols};
    }


    public
    int
    getNumRows()
    {
		return 0;
	}


    public
    void
    move(char nextMove)
    {

	}


    public
    int
    hasWon()
    {
		return 0;
	}


    public
    boolean
    isBlocked()
    {
		return false;
	}


    public
    int
    getNumCols()
    {
		return 0;
	}


    public
    Sprite
    get(int i,
    		int j)
    {
		return null;
	}


	public
	Grid<Sprite>
	getMaze()
	{
		return null;
	}


    public
    Monkey
    getPlayer1()
    {
		return player1;
	}


	public
	void
	setPlayer1(Monkey player1)
	{
		this.player1 = player1;
	}


	public
	Monkey
	getPlayer2()
	{
		return player2;
	}


	public
	void
	setPlayer2(Monkey player2)
	{
		this.player2 = player2;
	}


	public
	List<Banana>
	getBananas()
	{
		return bananas;
	}


	public
	void
	setBananas(List<Banana> bananas)
	{
		this.bananas = bananas;
	}


	public
	void
	setMaze(Grid<Sprite> maze)
	{
		this.maze = maze;
	}

}
