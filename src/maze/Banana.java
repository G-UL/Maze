package maze;


public
class
Banana extends Sprite
{
	private
	int
	score;


	public
	Banana(char symbol,
		   int row,
		   int column)
	{
		super(symbol,
			  row,
			  column);
		this.score = MazeConstants.BANANA_SCORE;
	}


	public
	int
	getScore()
	{
		return score;
	}
}
