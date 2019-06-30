package maze;


public
class
Monkey extends Sprite
	   implements Moveable
{
	private
	int
	numMoves,
	score;


	public
	Monkey(char symbol,
		   int row,
		   int column)
	{
		super(symbol,
			  row,
			  column);
		this.setNumMoves(0);
		this.setScore(0);
	}


	public
	boolean
	isBlocked(Grid<Sprite> maze)
	{
		Sprite down = maze.getCell(row + MazeConstants.DOWN,
								  column),
			   left = maze.getCell(row,
								  column + MazeConstants.LEFT),
			   right = maze.getCell(row,
								   column + MazeConstants.RIGHT),
			   up = maze.getCell(row + MazeConstants.UP,
								column);

		if (Helper.isMoveable(down) ||
			Helper.isMoveable(left) ||
			Helper.isMoveable(right) ||
			Helper.isMoveable(up))
		{
			return false;
		}

		return true;
	}


	public
	int
	getNumMoves()
	{
		return numMoves;
	}


	public
	void
	setNumMoves(int numMoves)
	{
		this.numMoves = numMoves;
	}


	public
	int
	getScore()
	{
		return score;
	}


	public
	void
	setScore(int score)
	{
		this.score = score;
	}


	public
	void
	setStats(int newRow,
			 int newColumn)
	{
		this.setColumn(newColumn);
		this.setRow(newRow);
		this.setNumMoves(this.getNumMoves() + 1);
	}


	@Override
	public
	void
	move(int row,
		 int column)
	{
		this.setRow(row);
		this.setColumn(column);
	}
}
