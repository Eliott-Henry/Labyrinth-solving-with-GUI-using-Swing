package dijkstra;
import java.util.HashSet;

/** Classe de l'ensemble A de l'algorithme de Dijkstra. 
 * @author Eliott Henry
  **/

public final class ASet implements ASetInterface{
	
	// création d'un set sur lequel on va travailler
	private HashSet<VertexInterface> set;
	
	// constructeur
	public ASet() {
		set = new HashSet<VertexInterface>(); 
	}
	
	/** Ajoute un sommet à l'ensemble A. 
	 * @param vertex Sommet à ajouter à l'ensemble.
	 **/
	
	public void add(VertexInterface vertex) {
		set.add(vertex);
	}
	
	
	/** Vérifie si un sommet appartient à l'ensemble A.	
	 * @param vertex Le sommet dont on veut tester l'appartenance à A
	 * @return true si le sommet appartient à A et false sinon.
	 **/
	public boolean contains(VertexInterface vertex) {
		return set.contains(vertex);
	} 
}
