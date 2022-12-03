package dijkstra;
import java.util.ArrayList;
import java.util.Hashtable;

/** Classe des p�res des sommets
 * @author Eliott Henry
 */

public class Previous implements PreviousInterface {
	
	private Hashtable<VertexInterface, VertexInterface> table;
	
	public Previous() {
		table = new Hashtable<VertexInterface, VertexInterface>();
	}
	
	/** D�finit le lien de succession entre deux sommets.
	 * @param vertex Le sommet fils.
	 * @param value Le sommet p�re.
	 **/
	public void setValue(VertexInterface vertex, VertexInterface value){
		table.put(vertex, value);
	}
	
	/** Renvoie le p�re d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet p�re
	 **/
	
	public VertexInterface getValue(VertexInterface vertex) {
		return table.get(vertex);
	}
	
	/** Renvoie la liste repr�sentant le plus court chemin jusqu'� un sommet donn�
	 * @param vertex Le sommet d'arriv�e
	 * @return La liste des sommets formant le chemin jusqu'� vertex
     **/
	public ArrayList<VertexInterface> getShoertestPath(VertexInterface vertex){
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		while(vertex != null) {
			path.add(vertex);
			vertex = table.get(vertex);
		}
		return path;
	}	
}
