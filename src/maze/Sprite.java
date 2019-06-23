package maze;


public
abstract
class
Sprite
{
	protected
	char
	symbol;


	protected
	int
	column,
	row;


	public
	Sprite(char symbol,
		   int row,
		   int column)
	{
		this.symbol = symbol;
		this.row = row;
		this.column = column;
	}


	public
	char
	getSymbol()
	{
		return symbol;
	}


	public
	void
	setSymbol(char symbol)
	{
		this.symbol = symbol;
	}


	public
	int
	getColumn()
	{
		return column;
	}


	public
	void
	setColumn(int column)
	{
		this.column = column;
	}


	public
	int
	getRow()
	{
		return row;
	}


	public
	void
	setRow(int row)
	{
		this.row = row;
	}
}
