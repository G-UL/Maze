package maze;


// Java
import java.util.Random;


public
class
Helper
{
	// A random number generator to move the MobileBananas.
	static
	Random
	random = new Random();


	public
	static
	Sprite
	createSprite(char symbol,
				 int row,
				 int column)
	{
		Sprite sprite = null;
		switch (symbol)
		{
			case ' ':
				sprite = new UnvisitedHallway(symbol,
											 row,
											 column);
				break;

			case '.':
				sprite = new VisitedHallway(symbol,
										   row,
										   column);
				break;

			case '1':
				sprite = new Monkey(symbol,
									row,
									column);
				break;

			case '2':
				sprite = new Monkey(symbol,
									row,
									column);
				break;

			case 'B':
				sprite = new Banana(symbol,
									row,
									column);
				break;

			case 'M':
				sprite = new MobileBanana(symbol,
										 row,
										 column);
				break;

			case 'X':
				sprite = new Wall(symbol,
								  row,
								  column);
				break;
		}

		return sprite;
	}


	public
	static
	boolean
	isBanana(Sprite sprite)
	{
		if (sprite.getSymbol() == 'B' ||
			sprite.getSymbol() == 'M')
		{
			return true;
		}

		return false;
	}


	public
	static
	boolean
	isMoveable(Sprite sprite)
	{
		boolean flag;
		switch (sprite.getSymbol())
		{
			case ' ':
				flag = true;
				break;

			case 'B':
				flag = true;
				break;

			case 'M':
				flag = true;;
				break;

			default:
				flag = false;
				break;
		}

		return flag;
	}


	public
	static
	boolean
	isMoveableForMobileBanana(Sprite sprite)
	{
		if (sprite.getSymbol() == ' ')
		{
			return true;
		}

		return false;
	}


	public
	static
	int[]
	isValidMovement(char nextMove)
	{
		int[] valid = new int[3];
		switch (nextMove)
		{
			case MazeConstants.P1_DOWN:
				// Player Reference
				valid[0] = 1;
				// Row Movement
				valid[1] = MazeConstants.DOWN;
				// Column Movement
				valid[2] = MazeConstants.NO_MOVEMENT;
				break;

			case MazeConstants.P1_LEFT:
				// Player Reference
				valid[0] = 1;
				// Row Movement
				valid[1] = MazeConstants.NO_MOVEMENT;
				// Column Movement
				valid[2] = MazeConstants.LEFT;
				break;

			case MazeConstants.P1_RIGHT:
				// Player Reference
				valid[0] = 1;
				// Row Movement
				valid[1] = MazeConstants.NO_MOVEMENT;
				// Column Movement
				valid[2] = MazeConstants.RIGHT;
				break;

			case MazeConstants.P1_UP:
				// Player Reference
				valid[0] = 1;
				// Row Movement
				valid[1] = MazeConstants.UP;
				// Column Movement
				valid[2] = MazeConstants.NO_MOVEMENT;
				break;

			case MazeConstants.P2_DOWN:
				// Player Reference
				valid[0] = 2;
				// Row Movement
				valid[1] = MazeConstants.DOWN;
				// Column Movement
				valid[2] = MazeConstants.NO_MOVEMENT;
				break;

			case MazeConstants.P2_LEFT:
				// Player Reference
				valid[0] = 2;
				// Row Movement
				valid[1] = MazeConstants.NO_MOVEMENT;
				// Column Movement
				valid[2] = MazeConstants.LEFT;
				break;

			case MazeConstants.P2_RIGHT:
				// Player Reference
				valid[0] = 2;
				// Row Movement
				valid[1] = MazeConstants.NO_MOVEMENT;
				// Column Movement
				valid[2] = MazeConstants.RIGHT;
				break;

			case MazeConstants.P2_UP:
				// Player Reference
				valid[0] = 2;
				// Row Movement
				valid[1] = MazeConstants.UP;
				// Column Movement
				valid[2] = MazeConstants.NO_MOVEMENT;
				break;

			default:
				// Player Reference
				valid[0] = MazeConstants.NO_MOVEMENT;
				// Row Movement
				valid[1] = MazeConstants.NO_MOVEMENT;
				// Column Movement
				valid[2] = MazeConstants.NO_MOVEMENT;
		}

		return valid;
	}



	public
	static
	int[]
	nextMove()
	{
		/**
		 *  DOWN == 1
		 *	LEFT == 2
		 *  RIGHT == 3
		 *  UP == 4
		 *
		 * 	x := random.nextInt(3) - 1 (0 ~ 2 - 1)
		 */
		int direction = random.nextInt(4) + 1;
		switch (direction)
		{
			case 1:

				return new int[] {MazeConstants.DOWN,
								  MazeConstants.NO_MOVEMENT};

			case 2:

				return new int[] {MazeConstants.NO_MOVEMENT,
								  MazeConstants.LEFT};

			case 3:

				return new int[] {MazeConstants.NO_MOVEMENT,
								  MazeConstants.RIGHT};

			default:

				return new int[] {MazeConstants.UP,
								  MazeConstants.NO_MOVEMENT};
		}
	}
}
