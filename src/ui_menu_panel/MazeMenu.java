package ui_menu_panel;
import javax.swing.*;

import ui.MazeApp;

public final class MazeMenu extends JMenu {
	private ResetMenuItem resetMenuItem;
	private SolveMenuItem solveMenuItem;
	private UnsolveMenuItem unsolveMenuItem;
	
	public MazeMenu(MazeApp mazeApp) {
		super("Maze");
		add(solveMenuItem = new SolveMenuItem(mazeApp));
		add(unsolveMenuItem = new UnsolveMenuItem(mazeApp));
		add(resetMenuItem = new ResetMenuItem(mazeApp));
	}
}
