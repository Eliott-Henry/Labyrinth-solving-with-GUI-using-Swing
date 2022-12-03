package ui_menu_panel;

import javax.swing.*;

import ui.MazeApp;
import java.awt.event.*
;

public final class EditMenuItem extends JMenuItem implements ActionListener {
	
	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public EditMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Edit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().setEdit();
	}
}
