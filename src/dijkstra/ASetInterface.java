package dijkstra;

/** Interface de l'ensemble A de l'algorithme de Dijkstra. 
 * @author Eliott Henry
  **/

public interface ASetInterface {
	

	/** Ajoute un sommet � l'ensemble A.
	 * @param vertex Sommet � ajouter � l'ensemble.
	 **/
	
	public void add(VertexInterface vertex);
	

	/** V�rifie si un sommet appartient � l'ensemble A.
	 * @param vertex Le sommet dont on veut tester l'appartenance � A
	 * @return vrai (true) si le sommet appartient � A et faux (false) sinon.
	 **/
	public boolean contains(VertexInterface vertex);
}
