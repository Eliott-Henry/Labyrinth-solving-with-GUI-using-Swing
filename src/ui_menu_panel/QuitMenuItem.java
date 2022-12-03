package ui_menu_panel;

import javax.swing.*;
import ui.MazeApp;
import ui.MazeAppModel;
import java.awt.event.*;


public final class QuitMenuItem extends JMenuItem implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	
	public QuitMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Quit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getModel();
		
		if(mazeAppModel.getModified()) {
			int response = JOptionPane.showInternalOptionDialog(this, "Drawing not saved. Save it ?", "Quit application", 
					JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,null,null) ;
					
			switch (response) {
				case JOptionPane.CANCEL_OPTION: return ;
				case JOptionPane.OK_OPTION: mazeAppModel.saveMaze() ;
					break ;
				case JOptionPane.NO_OPTION: break;
			}
		}
	}
	
}
