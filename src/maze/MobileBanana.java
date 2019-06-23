package maze;


public
class
MobileBanana extends Banana
			 implements Moveable
{

	public
	MobileBanana(char symbol,
				 int row,
				 int column)
	{
		super(symbol,
			  row,
			  column);
	}


	@Override
	public
	void
	move(int row,
		 int column)
	{
		// TODO Auto-generated method stub
		this.setRow(row);
		this.setColumn(column);
	}
}
