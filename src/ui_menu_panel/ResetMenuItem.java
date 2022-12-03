package ui_menu_panel;
import javax.swing.*;

import java.awt.event.*;

import ui.MazeApp;

public final class ResetMenuItem extends JMenuItem implements ActionListener{
	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public ResetMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Reset");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt){
		try {
			mazeApp.getModel().resetMaze();
		}
		catch(Exception e) {
		}
	}
}
