package maze;


public
class
ArrayGrid<T> implements Grid<T>
{
	private
	int
	numColumns,
	numRows;


	private
	Sprite[][]
	grid;


	public
	ArrayGrid(int numRows,
			  int numColumns)
	{
		this.setNumColumns(numColumns);
		this.setNumRows(numRows);
		this.setGrid(new Sprite[numRows][numColumns]);
	}


	/**********************************************************************
	 ************************* Getters & Setters **************************
	 **********************************************************************/


	public
	Sprite[][]
	getGrid()
	{
		return grid;
	}


	public
	void
	setGrid(Sprite[][] grid)
	{
		this.grid = grid;
	}


	public
	void
	setNumColumns(int numColumns)
	{
		this.numColumns = numColumns;
	}


	public
	void
	setNumRows(int numRows)
	{
		this.numRows = numRows;
	}


//	@Override
//	public
//	boolean
//	equals(Grid<T> other)
//	{
//		// TODO Auto-generated method stub
//		return false;
//	}


	@Override
	public
	Sprite
	getCell(int row,
			int column)
	{
		return this.grid[row][column];
	}


	@Override
	public
	int
	getNumColumns()
	{
		return this.numColumns;
	}


	@Override
	public
	int
	getNumRows()
	{
		return this.numRows;
	}


	@Override
	public
	void
	setCell(int row,
			int column,
			T item)
	{
		this.grid[row][column] = (Sprite) item;
	}
}
