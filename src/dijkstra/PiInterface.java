package dijkstra;

/** Interface de la fonction pi de l'algorithme de Dijkstra
 * 
 * @author Eliott Henry
 *
 */

public interface PiInterface {
	
	/** Assigne une valeur de pi à un sommet
	 * @param vertex Le sommet considéré
	 * @param weight La valeur donnée à pi(r)
	**/
	public void setWeight(VertexInterface vertex, int weight); 
	
	/** Renvoie la valeur de pi pour un sommet
	 * @param vertex Le sommet considéré
	 * @return  La valeur de pi(r)
	**/
	public int getWeight(VertexInterface vertex); // renvoie la valeur de pi(vertex)
}
