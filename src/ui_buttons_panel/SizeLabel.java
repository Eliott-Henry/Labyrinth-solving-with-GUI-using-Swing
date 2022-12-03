package ui_buttons_panel;
import javax.swing.*;
import ui.MazeApp;

public class SizeLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	
	public void notifyForUpdate() {
		setText("Size : " + String.valueOf(mazeApp.getModel().getHeight()));
		repaint();
	}
	
	public SizeLabel(MazeApp mazeApp) {
		super("Size : " + mazeApp.getModel().getHeight());
		this.mazeApp = mazeApp;
	}
	
	
}
