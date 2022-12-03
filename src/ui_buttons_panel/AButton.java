package ui_buttons_panel;
import javax.swing.*;
import java.awt.event.*;

import ui.MazeApp;

public final class AButton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private MazeApp mazeApp;
	
	public AButton(MazeApp mazeApp) {
		super("Arrival");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().changeSelectedType('A');
	}
}
