package maze;


public
class
MobileBanana extends Banana
			 implements Moveable
{
	private
	int
	score;


	public
	MobileBanana(char symbol,
				 int row,
				 int column)
	{
		super(symbol,
			  row,
			  column);
		this.score = MazeConstants.MOBILE_BANANA_SCORE;
	}


	public
	int
	getScore()
	{
		return score;
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
