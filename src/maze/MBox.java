package maze;
import dijkstra.VertexInterface;

/** Classe abstraite des cases du labyrinthes
 *  Une case est représentée par ses coordonnées (i,j) dans le labyrinthe, si c'est une case traversable (cross), et par son type (symbol)
 * @author Eliott Henry
 */

public abstract class MBox implements VertexInterface {
	
	private int i;
	private int j;
	private String label;
	private char symbol;
	private boolean crossable;
	
	protected MBox(int i, int j, char symbol, boolean crossable) {
		this.i = i;
		this.j = j;
		this.label = "(" + i + "," + j + ")";
		this.symbol = symbol;
		this.crossable = crossable;
	}
	
	
	/** Définit le symbol de la case
	 * @param symbol le symbole que l'on veut attribuer
	 **/
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	/** Renvoie la valeur de l'ordonnée
	 * 
	 * @return Ordonnée du sommet
	 **/
	public int geti() {
		return i;
	}
	
	/** Renvoie la valeur de l'abscisse
	 * 
	 * @return Ordonnée du sommet
	 **/
	public int getj() {
		return j;
	}
	

	/** Renvoie la valeur de label
	 * 
	 * @return label
	 **/
	public String getLabel() {
		return label;
	}
	

	/** Renvoie la valeur de symbol
	 * 
	 * @return symbol
	 **/
	public char getSymbol() {
		return symbol;
	}
	

	/** Renvoie la valeur de crossable
	 * 
	 * @return crossable
	 **/
	public boolean getCrossable() {
		return crossable;
	}
}
