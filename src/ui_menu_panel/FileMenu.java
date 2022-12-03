package ui_menu_panel;

import javax.swing.*;

import ui.MazeApp;

public final class FileMenu extends JMenu {
	
	private static final long serialVersionUID = 1L;
	
	private final OpenMenuItem openMenuItem;
	private final QuitMenuItem quitMenuItem;
	private final EditMenuItem editMenuItem;
	private final SaveMenuItem saveMenuItem;
	private final SaveAsMenuItem saveAsMenuItem;
	
	
	
	public FileMenu(MazeApp mazeApp) {
		super("File");
		add(openMenuItem = new OpenMenuItem(mazeApp));
		add(saveMenuItem = new SaveMenuItem(mazeApp));
		add(saveAsMenuItem = new SaveAsMenuItem(mazeApp));
		add(editMenuItem = new EditMenuItem(mazeApp));
		add(quitMenuItem = new QuitMenuItem(mazeApp));
	}
}
