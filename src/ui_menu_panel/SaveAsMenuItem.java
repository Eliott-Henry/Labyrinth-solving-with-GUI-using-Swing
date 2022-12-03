package ui_menu_panel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import ui.MazeApp;
import ui.MazeAppModel;

import java.awt.event.*;

public final class SaveAsMenuItem extends JMenuItem implements ActionListener {	
	
	static final long serialVersionUID = 1L;
	
	private MazeApp mazeApp;
	
	public SaveAsMenuItem(MazeApp mazeApp) {
		super("Save as");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}
	
	// Choisir le nom du nouveau file
	public void actionPerformed(ActionEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getModel();
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers texte", "txt"));
		int returnVal = fileChooser.showSaveDialog(getParent());
		if(returnVal == fileChooser.APPROVE_OPTION) {
			String fileName = fileChooser.getSelectedFile().getAbsolutePath();
			int index = fileName.lastIndexOf(".");
			if(index != -1) {
				String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				if(extension.equals(".txt")) {
					// l'erreur est gérée dans importFromFile
					mazeAppModel.exportToFile(fileName);
					mazeAppModel.importFromFile(fileName);
					mazeAppModel.setCurrentFileName(fileName);
					mazeAppModel.saveMaze();
				}
				else {
					System.out.println("Il faut choisir un fichier txt.");
				}
			}
			
		}
	}
}
