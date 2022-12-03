package ui_menu_panel;
import javax.swing.*;
import ui.MazeApp;
import java.awt.event.*;

public final class SolveMenuItem extends JMenuItem implements ActionListener{

	static final long serialVersionUID = 1L;
	private MazeApp mazeApp;
	
	public SolveMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getModel().solveMaze();
		} catch(Exception e) {
			System.out.println("Erreur");
		}
	}
}
