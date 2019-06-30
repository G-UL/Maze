package maze;


/**
 * The constants used by the MazeGame.
 */
public
class
MazeConstants
{
	public
	static
	final
	String
	// Sets to the path of file.
	// For Eclipse Compiler Usage.
	FILENAME = "/assets/maze1.txt";
	// For jar File Usage.
	// FILENAME = "/src/assets/maze1.txt";

	public
	static
	final
	char
	// The symbol for a banana.
	BANANA = 'B',
	// The symbol for a mobile banana.
	MOBILE_BANANA = 'M',
	// The symbol for Player 1.
	P1 = '1',
	// The symbol for Player 1 moving down.
	P1_DOWN = 's',
	// symbol for Player 1 moving left.
	P1_LEFT = 'a',
	// The symbol for Player 1 moving right.
	P1_RIGHT = 'd',  
	// The symbol for Player 1 moving up.
	P1_UP = 'w',
	// The symbol for Player 2.
	P2 = '2',
	// The symbol for Player 2 moving down.
	P2_DOWN = 'k',
	// The symbol for Player 2 moving left.
	P2_LEFT = 'j',
	// The symbol for Player 2 moving right.
	P2_RIGHT = 'l',
	// The symbol for Player 2 moving up.
	P2_UP = 'i',
	// The symbol for a hallway.
	VACANT = ' ',
	// The symbol for a visited.
	VISITED = '.',
	// The symbol for a wall.
	WALL = 'X';


	public
	static
	final
	int
	// The score for a banana.
	BANANA_SCORE = 1,
	// The adjustment for moving down.
	DOWN = 1,
	// The adjustment for moving left.
	LEFT = -1,
	// The score for a mobile banana.
	MOBILE_BANANA_SCORE = 2,
	// No Movement
	NO_MOVEMENT = 0,
	// The adjustment for moving right.
	RIGHT = 1,
	// The adjustment for moving up.
	UP = -1;
}
