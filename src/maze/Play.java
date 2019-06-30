package maze;


// Java
import java.io.IOException;

// Package
import ui.GUI;


public
class
Play
{
	public
	static
	void
	main(String[] args) throws IOException
	{
		String path = Play.class.getResource(MazeConstants.FILENAME).getPath();
		MazeGame game = new MazeGame(path);
		GUI gameUI = new GUI(game);
		gameUI.launchGame(); 
		gameUI.displayWinner();
	}
}
