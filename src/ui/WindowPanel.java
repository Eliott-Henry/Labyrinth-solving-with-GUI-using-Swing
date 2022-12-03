package ui;
import javax.swing.*;
import java.awt.*;
import maze.*;
import ui_buttons_panel.ButtonsPanel;
import java.awt.event.*;

public final class WindowPanel extends JPanel {
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}
	
	public WindowPanel(MazeApp mazeApp) {
		
		super();	
		// disposition des mazePanel et buttonsPanel dans le windowPanel
		setLayout(new BorderLayout());
		add(mazePanel = new MazePanel(mazeApp), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.SOUTH);	
		
	}
}
