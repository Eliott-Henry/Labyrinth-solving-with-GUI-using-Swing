package ui;
import javax.swing.*;
import java.awt.event.*;

public class MouseDisplay extends MouseAdapter{
	
	private MazeApp mazeApp;
	private MazePanel mazePanel;
	
	public MouseDisplay(MazeApp mazeApp, MazePanel mazePanel) {
		this.mazeApp = mazeApp;
		this.mazePanel = mazePanel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		MazeAppModel model = mazeApp.getModel();
		int heightBox = mazePanel.getHeight() / model.getHeight();
		int widthBox = mazePanel.getWidth() / model.getWidth();
		int iBox = e.getY()/heightBox;
		int jBox = e.getX()/widthBox;
		model.changeBox(iBox, jBox);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		MazeAppModel model = mazeApp.getModel();
		int heightBox = mazePanel.getHeight() / model.getHeight();
		int widthBox = mazePanel.getWidth() / model.getWidth();
		int iBox = e.getY()/heightBox;
		int jBox = e.getX()/widthBox;
		model.changeBox(iBox, jBox);
	}
	
}
