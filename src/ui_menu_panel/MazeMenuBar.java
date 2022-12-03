package ui_menu_panel;
import javax.swing.*;

import ui.MazeApp;

public final class MazeMenuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	private FileMenu fileMenu;
	private MazeMenu mazeMenu;
	
	public MazeMenuBar(MazeApp mazeApp) {
		super();
		add(fileMenu = new FileMenu(mazeApp));
		add(mazeMenu = new MazeMenu(mazeApp));
	}
	
}
