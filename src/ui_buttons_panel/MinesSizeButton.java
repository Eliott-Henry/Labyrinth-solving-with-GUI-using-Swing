package ui_buttons_panel;

import javax.swing.JButton;

import ui.MazeApp;
import java.awt.event.*;

public class MinesSizeButton extends JButton implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private MazeApp mazeApp;
	
	public MinesSizeButton(MazeApp mazeApp) {
		super("-");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		mazeApp.getModel().decreaseSize();
	}
}
