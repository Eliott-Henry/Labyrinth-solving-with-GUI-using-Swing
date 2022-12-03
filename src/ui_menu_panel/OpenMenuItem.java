package ui_menu_panel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.MazeApp;
import ui.MazeAppModel;

import java.awt.event.*;

public final class OpenMenuItem extends JMenuItem implements ActionListener {	
	
	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public OpenMenuItem(MazeApp mazeApp) {
		// nom du bouton
		super("Open");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	// Choisir le file 
	public void actionPerformed(ActionEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getModel();
		
		if(mazeAppModel.getModified()) {
			int response = JOptionPane.showInternalOptionDialog(this, "Maze not saved, do you want to save it", "Open new file", 
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
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers texte", "txt"));
		int returnVal = fileChooser.showOpenDialog(getParent());
		if(returnVal == fileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().getAbsolutePath();
			// l'erreur est gérée dans importFromFile
			mazeAppModel.importFromFile(fileName);
			mazeAppModel.setCurrentFileName(fileName);
		}
	}
}
