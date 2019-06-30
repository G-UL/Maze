package maze;


public
interface
Grid<T>
{
	public
	Sprite
	getCell(int row,
			int column);


	public
	int
	getNumColumns();


	public
	int
	getNumRows();


	public
	void
	setCell(int row,
			int column,
			T item);


	public
	void
	setNumColumns(int numColumns);


	public
	void
	setNumRows(int numRows);


	public
	String
	toString();
}
