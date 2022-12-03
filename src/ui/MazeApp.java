package ui;
import java.util.*;

import javax.swing.*;
import maze.*;
import ui_menu_panel.MazeMenuBar;

public class MazeApp extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private final MazeMenuBar mazeMenuBar;
	private WindowPanel windowPanel;
	private MazeAppModel mazeAppModel;
	
	public void update(Observable observable, Object parameter) {
		notifyForUpdate();
	}
	
	public void notifyForUpdate() {
		windowPanel.notifyForUpdate();
	}
	
	public final void setModel(MazeAppModel mazeAppModel) {
		this.mazeAppModel = mazeAppModel;
	}
	
	public final MazeAppModel getModel() {
		return mazeAppModel;
	}
	
	public MazeApp() {
		
		super("Maze Application");
		
		mazeAppModel = new MazeAppModel();
		mazeAppModel.addObserver(this);
		
		// création du menu
		mazeMenuBar = new MazeMenuBar(this);
		setJMenuBar(mazeMenuBar);
		
		// création du window 
		windowPanel = new WindowPanel(this);
		setContentPane(windowPanel);
		
		// parametres de sortie de l'app
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//applique les modifs
		pack();
		
		// rend visible
		setVisible(true);
		
	}
	
	
}
