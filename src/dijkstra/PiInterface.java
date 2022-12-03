package dijkstra;

/** Interface de la fonction pi de l'algorithme de Dijkstra
 * 
 * @author Eliott Henry
 *
 */

public interface PiInterface {
	
	/** Assigne une valeur de pi � un sommet
	 * @param vertex Le sommet consid�r�
	 * @param weight La valeur donn�e � pi(r)
	**/
	public void setWeight(VertexInterface vertex, int weight); 
	
	/** Renvoie la valeur de pi pour un sommet
	 * @param vertex Le sommet consid�r�
	 * @return  La valeur de pi(r)
	**/
	public int getWeight(VertexInterface vertex); // renvoie la valeur de pi(vertex)
}
