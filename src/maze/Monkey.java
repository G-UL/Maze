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
