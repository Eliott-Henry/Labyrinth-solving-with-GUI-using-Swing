package ui;
import javax.swing.*;
import java.awt.*;

public final class MazePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public void notifyForUpdate() {
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		mazeApp.getModel().paintBoxes(g, this);
	}
	
	public MazePanel(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
		setPreferredSize(new Dimension(256, 256));	
		MouseDisplay mouseDisplay = new MouseDisplay(mazeApp, this);
		addMouseListener(mouseDisplay);
		addMouseMotionListener(mouseDisplay);
	}
}
