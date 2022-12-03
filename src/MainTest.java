import java.io.IOException;
import java.util.ArrayList;
import maze.*;
import dijkstra.*;

public class MainTest {

	public static void main(String[] args) throws IOException, MazeReadingException {
		Maze maze = new Maze();
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe2.txt");
		
		Maze solvedMaze = maze.solveMaze();
		
		for(int i = 0; i < maze.getheight(); i++) {
			for(int j = 0; j < maze.getwidth(); j++) {
				System.out.print(solvedMaze.getBox(i, j).getSymbol());
			}
			System.out.println();
		}
	}

}