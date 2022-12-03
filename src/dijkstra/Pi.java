package dijkstra;
import java.util.Hashtable;

/** Classe de la fonction pi de l'algorithme de Dijkstra
 * 
 * @author Eliott Henry
 *
 */

public class Pi implements PiInterface {
	private Hashtable<VertexInterface, Integer> table;
	
	public Pi() {
		table = new Hashtable<VertexInterface, Integer>();
	}
	
	/** Assigne une valeur de pi à un sommet
	 * @param vertex Le sommet considéré
	 * @param weight La valeur donnée à pi(r)
	**/
	public void setWeight(VertexInterface vertex, int weight)
	{
		table.put(vertex, weight);
	}
	
	/** Renvoie la valeur de pi pour un sommet
	 * @param vertex Le sommet considéré
	 * @return  La valeur de pi(r)
	**/
	public int getWeight(VertexInterface vertex) {
		return table.get(vertex);
	}
	
}
