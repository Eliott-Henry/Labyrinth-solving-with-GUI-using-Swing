package ui_buttons_panel;
import java.awt.event.ActionEvent;

import javax.swing.*;

import ui.MazeApp;
import java.awt.event.*;

public final class DButton extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private MazeApp mazeApp;
	
	public DButton(MazeApp mazeApp) {
		super("Departure");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().changeSelectedType('D');
	}
	
}
