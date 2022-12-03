package ui_buttons_panel;
import javax.swing.*;

import ui.MazeApp;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class TypeIndicator extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;	
	private static Image aImage;
	private static Image wImage;
	private static Image dImage;
	private static Image eImage;
	
	static {
		try {
			aImage = ImageIO.read(new File("data/aBox.png"));
			wImage = ImageIO.read(new File("data/wBox.png"));
			eImage = ImageIO.read(new File("data/eBox.png"));
			dImage = ImageIO.read(new File("data/dBox.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TypeIndicator(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
	}
	
	public void notifyForUpdate() {
		repaint();
	}
	
	@Override
	protected final void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(mazeApp.getModel().getSymbol() == 'A') {
			 g.drawImage(aImage, 0,0,getWidth(),getHeight(),this);}
		else if(mazeApp.getModel().getSymbol() == 'D') {
		    g.drawImage(dImage, 0,0,getWidth(),getHeight(),this);}
		else if (mazeApp.getModel().getSymbol() == 'E') {
			g.drawImage(eImage, 0,0,getWidth(),getHeight(),this);}
		else {
			g.drawImage(wImage, 0,0,getWidth(),getHeight(),this);}
	}
	
}
