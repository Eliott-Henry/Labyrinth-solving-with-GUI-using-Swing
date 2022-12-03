package ui_menu_panel;

import javax.swing.*;

import ui.MazeApp;
import java.awt.event.*
;

public final class UnsolveMenuItem extends JMenuItem implements ActionListener {
	
	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public UnsolveMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Unsolve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().unsolve();
	}
}
