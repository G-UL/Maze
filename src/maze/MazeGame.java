package maze;


// Java
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	// The maze grid.
	private
	ArrayGrid<Sprite>
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
		int[] dimensions = getDimensions(layoutFileName);
		maze = new ArrayGrid<Sprite>(dimensions[0],
									 dimensions[1]);
		maze.setNumColumns(dimensions[1]);
		maze.setNumRows(dimensions[0]);

		/* INITIALIZE THE GRID */
		int i = 0;
		bananas = new ArrayList<Banana> ();
		Scanner sc = new Scanner(new File(layoutFileName));
		while (sc.hasNextLine())
		{
			String line = sc.nextLine();
			for (int j = 0; j < line.length(); j++)
			{
				Sprite cell = Helper.createSprite(line.charAt(j),
												  i,
												  j);
				maze.setCell(i,
							 j,
							 cell);

				if (Helper.isBanana(cell))
				{
					bananas.add((Banana) cell);
				}

				if (cell.getSymbol() == '1')
				{
					this.setPlayer1((Monkey) cell);
				}

				if (cell.getSymbol() == '2')
				{
					this.setPlayer2((Monkey) cell);
				}
			}
			i++;
		}

		sc.close();
		this.setMaze(maze);
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

		return new int[] {numRows,
						  numCols};
	}


	public
	void
	handlePlayerMovement(Monkey player,
						 int[] movement)
	{
		if (player == null ||
			movement[0] == 0) return ;

		int row = player.getRow(),
			column = player.getColumn();
		int newRow = row + movement[1],
			newColumn = column + movement[2];
		Sprite nextCell = maze.getCell(newRow,
									  newColumn);
		if (Helper.isMoveable(nextCell))
		{
			if (Helper.isBanana(nextCell))
			{
				removeBanana(player,
							 nextCell);
			}

			Sprite vh = new VisitedHallway ('.',
											row,
											column);
			maze.setCell(row,
						 column,
						 vh);
			player.setStats(newRow,
							newColumn);
			maze.setCell(newRow,
						 newColumn,
						 player);
		}
	}


	public
	int
	hasWon()
	{
		if (bananas.size() == 0)
		{
			if (player1.getScore() > player2.getScore())
			{
				return 1;
			}
			else if (player1.getScore() < player2.getScore())
			{
				return 2;
			}
			else
			{
				return 3;
			}
		}
		else
		{
			return 0;
		}
	}


	public
	boolean
	isBlocked()
	{
		if (player1.isBlocked(this.getMaze()) &&
			player2.isBlocked(this.getMaze()))
		{
			return true;
		}

		return false;
	}


	public
	void
	move(char nextMove)
	{
		int valid[] = Helper.isValidMovement(nextMove);
		Monkey player = null;
		if (valid[0] == 1)
		{
			player = player1;
		}
		else if (valid[0] == 2)
		{
			player = player2;
		}

		handlePlayerMovement(player,
							 valid);
		moveBananas();
	}


	public
	void
	moveBananas()
	{
		for (int i = 0; i < bananas.size(); i++)
		{
			if (bananas.get(i) instanceof MobileBanana)
			{
				MobileBanana mb = (MobileBanana) bananas.get(i);
				int row = mb.getRow(),
					column = mb.getColumn();
				int[] mbMovement = Helper.nextMove();
				int newRow = row + mbMovement[0],
					newColumn = column + mbMovement[1];
				Sprite nextSpot = this.get(newRow,
										   newColumn);
				if (Helper.isMoveableForMobileBanana(nextSpot))
				{
					mb.move(newRow,
							newColumn);
					maze.setCell(newRow,
								 newColumn,
								 mb);
					Sprite uvh = new UnvisitedHallway(' ',
													  row,
													  column);
					maze.setCell(row,
								 column,
								 uvh);
				}
			}
		}
	}


	public
	void
	removeBanana(Monkey player,
				 Sprite banana)
	{
		int score = player.getScore() + ((Banana) banana).getScore();
		System.out.println(score);
		player.setScore(score);
		bananas.remove(banana);
	}


	/**********************************************************************
	 ************************* Getters & Setters **************************
	 **********************************************************************/


	public
	Sprite
	get(int i,
		int j)
	{
		return this.maze.getCell(i,
								 j);
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
	Grid<Sprite>
	getMaze()
	{
		return maze;
	}


	public
	void
	setMaze(ArrayGrid<Sprite> maze)
	{
		this.maze = maze;
	}


	public
	int
	getNumCols()
	{
		return this.maze.getNumColumns();
	}


	public
	int
	getNumRows()
	{
		return this.maze.getNumRows();
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
}
