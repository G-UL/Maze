package maze;


public
interface
Grid<T>
{
//	public
//	boolean
//	equals(Grid<T> other);


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
	String
	toString();
}
