package maze;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/** Classe des graphes
 * 
 * Un graphe est représenté par la matrice de ses cases (maze), ses dimensions (width,height), une arrivée et un départ.
 * 
 * @author Eliott Henry
 *
 */

public class Maze implements GraphInterface {
	
	private MBox[][] boxes;
	private int width;
	private int height;
	private ABox arrival;
	private DBox departure;
	
	public Maze() {
	}
	
	public Maze(MBox[][] boxes) {
		this.boxes = boxes;
		height = boxes.length; 
		width = boxes[0].length;
	}
	
	
	// renvoie le maze résolu
	public final Maze solveMaze() throws IOException, MazeReadingException{
		PreviousInterface previous = Dijkstra.dijkstra(this, departure);
		ArrayList<VertexInterface> path = previous.getShoertestPath(arrival);
		Maze solvedMaze = new Maze(boxes);
		
		if(path.size() == 1) {
			// lance l'erreur sur le chemin inexistant
			throw new MazeReadingException("MainTest.java", 0, "Il n'y a pas de chemin entre l'arrivée et le départ");
		}
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(path.contains(boxes[i][j]) && arrival != boxes[i][j] && departure != boxes[i][j]){
					solvedMaze.getBox(i, j).setSymbol('P');
				}
			}
		}
		
		return solvedMaze;
	}
	
	public final void setBox(int i, int j, char symbol) {
		switch(symbol) {
		case('A') : 
			boxes[i][j] = new ABox(i, j);
			arrival = new ABox(i, j);
			break;
		case('D') : 
			boxes[i][j] = new DBox(i, j);
			departure = new DBox(i, j);
			break;
		case('E') : 
			boxes[i][j] = new EBox(i, j);
			break;
		case('W') : 
			boxes[i][j] = new WBox(i, j);
			break;
		}
	}
	
	/** Renvoie la largeur du laby
	 * 
	 * @return la largeur du laby
	 */
	public int getwidth() {
		return width;
	}
	
	/** Renvoie la hauteur
	 * @return la hauteur
	 */
	public int getheight() {
		return height;
	}
	
	/** Renvoie le sommet spécifié
	 * @param i l'ordonnée du sommet
	 * @param j l'abscisse du sommet
	 * @return le sommet
	 */
	public MBox getBox(int i, int j) {
		return boxes[i][j];
	}
	
	/** Renvoie la matrice des sommets
	 * @return La matrice des sommets
	 */
	public MBox[][] getBoxes(){
		return boxes;
	}
	
	/** Renvoie le départ
	 * @return le départ
	 */
	public MBox getDeparture() {
		return departure;
	}
	
	/** Renvoie l'arrivée
	 * @return l'arrivée
	 */
	public MBox getArrival() {
		return arrival;
	}

	/** Renvoie la liste des voisins d'un sommet dans le graphe
	 * @param vertex Le sommet dont on cherche les voisins
	 * @return La liste des voisins
	 **/
	public ArrayList<VertexInterface> getAllVertexes(){ 
		ArrayList<VertexInterface> vertexList = new ArrayList<VertexInterface>() ;
		for (MBox[] rows : boxes) {
			for(MBox box : rows) {
				vertexList.add(box);}
		}
		return vertexList;
	}
	
	/** Renvoie la liste des voisins d'un sommet dans le graphe
	 * @param vertex Le sommet dont on cherche les voisins
	 * @return La liste des voisins
	 **/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex){
		
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex;
		
		int i = box.geti();
		int j = box.getj();
		
		if (i > 1) {
			if (boxes[i-1][j].getCrossable()) {
				successors.add(boxes[i-1][j]);
			}
		}
		
		if (i < height - 1) {
			if (boxes[i+1][j].getCrossable()) {
				successors.add(boxes[i+1][j]);
			}
		}
		
		if (j > 1) {
			if (boxes[i][j-1].getCrossable()) {
				successors.add(boxes[i][j-1]);
			}
		}
		
		if (j < width - 1) {
			if (boxes[i][j+1].getCrossable()) {
				successors.add(boxes[i][j+1]);
			}
		}
		
		return successors;
	}
	
	/** Renvoie le poids dans le graphe de l'arête entre deux sommets
	 * @param src Le sommet d'origine
	 * @param dst Le sommet d'arrivée
	 * @return Le poids de l'arête src-dst **/
	public int getWeight(VertexInterface src, VertexInterface dst) {
		ArrayList<VertexInterface> successors = getSuccessors(src);
		if(successors.contains(dst)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/** Initialise le labyrinthe à partir d'un fichier texte
	 * @param fileName Adresse du fichier texte
	 * @throws MazeReadingException si le labyrinthe n'est pas valide
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			ArrayList<String> tab = new ArrayList<String>();
			
			try {
				String line;
				while((line = file.readLine()) != null) {
					tab.add(line);
					line.length();
				}
			}
			catch(IOException e) {
			}
			
			file.close();
			
			this.height = tab.size();
			this.width = tab.get(0).length();
			this.boxes = new MBox[height][width];
			this.arrival = null;
			this.departure = null;
			
			for(int i = 0; i <= height - 1; i++) {
				
				String line = tab.get(i);
				if(line.length() != width) {
					//lance l'exception sur la longueur de la ligne
					throw new MazeReadingException(fileName, i+1, "La ligne n'a pas la bonne longueur");
				}
				
				for(int j = 0; j <= width - 1; j++) {
					
					char type = line.charAt(j);
					
					if(type == 'A') {
						if(getArrival() != null){
							// lance l'exception sur le surplus de cases arrivées
							throw new MazeReadingException(fileName, i + 1, "Il y a plusieurs cases arrivées dans le laby");
						}
						boxes[i][j] = new ABox(i, j);
						arrival = (ABox) boxes[i][j];
					}
					else if(type == 'E') {
						boxes[i][j] = new EBox(i, j);
					}
					else if(type == 'D') {
						if(getDeparture() != null) {
							// lance l'exception sur le surplus de cases départ
							throw new MazeReadingException(fileName, i+1, "Il y a plusieurs cases départ dans le laby");
						}
						boxes[i][j] = new DBox(i, j);
						departure = (DBox) boxes[i][j];
					}
					else if(type == 'W') {
						boxes[i][j] = new WBox(i, j);
					}
					else if(type == 'P') {
						boxes[i][j] = new PBox(i, j);
					}
					else {
						// lance l'exception sur le symbole invalide de la case
						throw new MazeReadingException(fileName, i+1, "Le " + (j+1) + "e caractère de la ligne " + (i + 1) + " n'est pas du bon format");
					}
				}
			}
			
			if(getArrival() == null) {
				throw new MazeReadingException(fileName, 0, "Il n'y a pas de case arrivée");		
			}
			if(getDeparture() == null) {
				throw new MazeReadingException(fileName, 0, "Il n'y a pas de case départ");		
			}
		}
		catch(IOException e){
			System.out.print("Le fichier est introuvable");
		}
	}
	
	/** Ecris le labyrinthe dans un fichier texte
	 * @param fileName le chemin vers le fichier dans lequel on veut écrire
	 */
	public final void saveToTextFile(String fileName) {	
		try {
			PrintWriter writer = new PrintWriter(fileName);
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					writer.print(boxes[i][j].getSymbol());
				}
				if(i != height - 1) {
					writer.println();
				}
			}
			writer.close();
		}
		catch(IOException e) {
			System.out.print("Le fichier est introuvable");
		}
	}
	
}