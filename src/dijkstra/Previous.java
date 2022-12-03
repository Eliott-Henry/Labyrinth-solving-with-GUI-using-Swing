package dijkstra;
import java.util.ArrayList;
import java.util.Hashtable;

/** Classe des pères des sommets
 * @author Eliott Henry
 */

public class Previous implements PreviousInterface {
	
	private Hashtable<VertexInterface, VertexInterface> table;
	
	public Previous() {
		table = new Hashtable<VertexInterface, VertexInterface>();
	}
	
	/** Définit le lien de succession entre deux sommets.
	 * @param vertex Le sommet fils.
	 * @param value Le sommet père.
	 **/
	public void setValue(VertexInterface vertex, VertexInterface value){
		table.put(vertex, value);
	}
	
	/** Renvoie le père d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet père
	 **/
	
	public VertexInterface getValue(VertexInterface vertex) {
		return table.get(vertex);
	}
	
	/** Renvoie la liste représentant le plus court chemin jusqu'à un sommet donné
	 * @param vertex Le sommet d'arrivée
	 * @return La liste des sommets formant le chemin jusqu'à vertex
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
