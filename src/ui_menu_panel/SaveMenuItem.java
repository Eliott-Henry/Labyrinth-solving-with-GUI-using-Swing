package ui_menu_panel;
import java.awt.event.*;
import javax.swing.*;

import ui.MazeApp;

public final class SaveMenuItem extends JMenuItem implements ActionListener {

	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public SaveMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Save");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().saveMaze();
	}
}
