package dijkstra;

/** Interface de l'ensemble A de l'algorithme de Dijkstra. 
 * @author Eliott Henry
  **/

public interface ASetInterface {
	

	/** Ajoute un sommet à l'ensemble A.
	 * @param vertex Sommet à ajouter à l'ensemble.
	 **/
	
	public void add(VertexInterface vertex);
	

	/** Vérifie si un sommet appartient à l'ensemble A.
	 * @param vertex Le sommet dont on veut tester l'appartenance à A
	 * @return vrai (true) si le sommet appartient à A et faux (false) sinon.
	 **/
	public boolean contains(VertexInterface vertex);
}
