package ui;
import java.util.*;

import javax.swing.JOptionPane;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import maze.*;
import ui_buttons_panel.*;

public class MazeAppModel extends Observable{
	
	private String currentFileName;
	
	private Box[][] newBoxes;
	private int mazeHeight;
	private int mazeWidth;
		
	private char selectedType;
	private boolean modified;
	private boolean solved;
	private boolean edit;
	
	public MazeAppModel() {
		modified = false;
		solved = false;
		edit = false;	
		selectedType = 'W';
		
		currentFileName = "data/labyrinthe.txt";
		try {
			importFromFile(currentFileName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// on dessine les boxes dans le panel : changer paintBox en prenant en argument panelHeight et panelWidth ?
	public final void paintBoxes(Graphics g, MazePanel mazePanel) {
		for(Box[] ligne : newBoxes) {
			for(Box box : ligne) {
				box.paintBox(g, mazePanel, mazeHeight, mazeWidth);
			}
		}
	}
	
	// Cette méthode résoud le labyrinthe graphiquement
	public final void solveMaze() throws MazeReadingException, IOException {
		if(!solved) {
			exportToFile("data/export.txt"); // on exporte le labyrinthe actuel (il n'est peut être pas save)
			Maze maze = new Maze();
			try {
				// On vérifie s'il est résoluble
				maze.initFromTextFile("data/export.txt");
				
				try {
					maze = maze.solveMaze();
					maze.saveToTextFile("data/solvedMaze.txt");
					importFromFile("data/solvedMaze.txt");
					solved = true;
					setChanged();
					notifyObservers();
				}
				catch(MazeReadingException e) {
					// Exception relative à la résolubilité du labyrinthe
					System.out.println(e.getMessage());
				}
			}			
			catch(MazeReadingException e) {
				// Exception relative à la validité du labyrinthe (taille, symboles, bon nombre d'arrivée et départ)
				System.out.println(e.getMessage());
			}		
		}
	}
	
	// Reviens à l'affichage du labyrinthe sans la solution
	public final void unsolve() {
		if(solved) {
			importFromFile("data/export.txt");
			solved = false;
			setChanged();
			notifyObservers();
		}
	}
	
	public final void changeBox(int i, int j) {	
		// on ne peut modifier les box que si ce n'est pas un laby résolu
		if(!solved && edit) {
			try {
			newBoxes[i][j].setTypeBox(selectedType);
			modified = true;
			setChanged();
			notifyObservers();}
			catch(Exception e) {
			}
		}
	}
	// change le symbol courant
	public final void changeSelectedType(char newType) {
		this.selectedType = newType;
		setChanged();
		notifyObservers();
	}
	
	// Augmente de 1 unité la taille du labyrinthe
	public final void increaseSize() {
		if(edit) {
			changeDim(mazeHeight + 1, mazeWidth + 1);
			setChanged();
			notifyObservers();
		}
	}
	
	// Réduis de 1 unité la taille du labyrinthe
	public final void decreaseSize() {
		if(edit) 
		{
			if(mazeWidth > 2 && mazeHeight > 2) {
				changeDim(mazeHeight - 1, mazeWidth - 1);
				setChanged();
				notifyObservers();
			}
			else {
				System.out.println("Vous ne pouvez plus réduire la taille du labyrinthe.");
			}
		} 
	}
	
	public final void setCurrentFileName(String fileName) {
		this.currentFileName = fileName;
	}
	
	// Change la dimension du labyrinthe
	public final void changeDim(int newHeight, int newWidth) {
		newBoxes = new Box[newHeight][newWidth];
		mazeHeight = newHeight;
		mazeWidth = newWidth;
		initialiseMaze();
		modified = true;
		solved = false;		
	}
	
	// Initialise un labyrinthe avec une case départ, une case arrivée et du vide
	public final void initialiseMaze() {
		for(int i = 0; i < mazeHeight; i++) {
			for(int j =0; j < mazeWidth; j++) {
				if(i == 0 && j == 0) {
					newBoxes[i][j] = new Box(i, j, 'D');
				}	
				else if((i == mazeHeight - 1) && (j == mazeWidth - 1))
				{
					newBoxes[i][j] = new Box(i, j, 'A');
				}
				else {
					newBoxes[i][j] = new Box(i, j, 'E');
				}
			}
		}
	}
	
	
	// retourne au dernier maze sauvegardé
	public final void resetMaze() throws MazeReadingException {
		importFromFile(currentFileName);
		solved = false;
		modified = false;
		setChanged();
		notifyObservers();
	}
	
	// sauvegarde le maze dans le fichier courant
	public final void saveMaze() {
		if(!solved) {
			exportToFile("data/export.txt");
			Maze maze = new Maze();
			try {
				// on vérifie que le laby est valide en créant un maze à partir de celui ci
				maze.initFromTextFile("data/export.txt");
				exportToFile(currentFileName);
				modified = false;
				setChanged();
				notifyObservers();
			}
			catch(MazeReadingException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	// Cette méthode exporte dans un fichier laby les symboles des Boxes
	public final void exportToFile(String fileName) {
		try {	
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			for(Box[] row : newBoxes) {
				for(Box box : row) {
					pw.print(box.getSymbol());
				}
				pw.println();
			}
			pw.close();
		} catch(FileNotFoundException e) {
			System.out.println("Fichier " + fileName + " introuvable.");
		}
	}
		
	// Cette méthode construis le labyrinthe visuel à partir d'un fichier texte
	public final void importFromFile(String fileName) {
		
		Maze maze = new Maze();
		try {
			maze.initFromTextFile(fileName);
			this.mazeHeight = maze.getheight();
			this.mazeWidth = maze.getwidth();
			this.newBoxes = new Box[mazeHeight][mazeWidth];
				
			for(int i = 0; i < mazeHeight; i++) {
				for(int j = 0; j < mazeWidth; j++) {
					this.newBoxes[i][j] = new Box(i, j, maze.getBox(i, j).getSymbol());
				}
			}
			modified = false;
			setChanged();
			notifyObservers();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	// getters
	
	public final int getHeight() {
		return mazeHeight;
	}
	
	public final int getWidth() {
		return mazeWidth;
	}
	
	public final char getSymbol() {
		return selectedType;
	}
	
	public final boolean getModified() {
		return modified;
	}	
	
	public final void setEdit() {
		edit = true;
	}	
}
