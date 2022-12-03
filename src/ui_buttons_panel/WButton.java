package ui_buttons_panel;
import javax.swing.*;

import ui.MazeApp;
import java.awt.event.*;

public final class WButton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public WButton(MazeApp mazeApp) {
		super("Wall");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().changeSelectedType('W');
	}
}
