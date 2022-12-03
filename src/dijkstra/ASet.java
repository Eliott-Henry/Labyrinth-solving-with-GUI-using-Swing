package dijkstra;
import java.util.HashSet;

/** Classe de l'ensemble A de l'algorithme de Dijkstra. 
 * @author Eliott Henry
  **/

public final class ASet implements ASetInterface{
	
	// cr�ation d'un set sur lequel on va travailler
	private HashSet<VertexInterface> set;
	
	// constructeur
	public ASet() {
		set = new HashSet<VertexInterface>(); 
	}
	
	/** Ajoute un sommet � l'ensemble A. 
	 * @param vertex Sommet � ajouter � l'ensemble.
	 **/
	
	public void add(VertexInterface vertex) {
		set.add(vertex);
	}
	
	
	/** V�rifie si un sommet appartient � l'ensemble A.	
	 * @param vertex Le sommet dont on veut tester l'appartenance � A
	 * @return true si le sommet appartient � A et false sinon.
	 **/
	public boolean contains(VertexInterface vertex) {
		return set.contains(vertex);
	} 
}
