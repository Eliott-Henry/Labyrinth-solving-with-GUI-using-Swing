package ui_buttons_panel;

import java.awt.*;
import javax.swing.*;

import ui.MazeApp;

public final class ButtonsPanel extends JPanel {
	static final long serialVersionUID = 1L;
	
	private final AButton aButton;
	private final DButton dButton;
	private final EButton eButton;
	private final WButton wButton;
	private final SizeChooser sizeChooser;
	private final TypeIndicator typeIndicator;
	
	public void notifyForUpdate() {
		typeIndicator.notifyForUpdate();
		sizeChooser.notifyForUpdate();
	}
	
	public ButtonsPanel(MazeApp mazeApp) {
		super();
		
		setLayout(new GridLayout(1, 6));
		
		add(sizeChooser = new SizeChooser(mazeApp));
		add(typeIndicator = new TypeIndicator(mazeApp));
		add(dButton = new DButton(mazeApp));
		add(aButton = new AButton(mazeApp));
		add(wButton = new WButton(mazeApp));
		add(eButton = new EButton(mazeApp));			
	}
	

}
