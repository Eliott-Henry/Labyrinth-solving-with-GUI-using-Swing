package dijkstra;
import java.util.ArrayList;

/** Interface des pères des sommets
 * @author Eliott Henry
 */

public interface PreviousInterface {

	/** Définit le lien de succession entre deux sommets.
	 * @param vertex Le sommet fils.
	 * @param value Le sommet père.
	 **/
	public void setValue(VertexInterface vertex, VertexInterface value); 
	
	/** Renvoie le père d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet père
	 **/
	public VertexInterface getValue(VertexInterface vertex);
	
	/** Renvoie la liste représentant le plus court chemin jusqu'à un sommet donné
	 * @param vertex Le sommet d'arrivée
	 * @return La liste des sommets formant le chemin jusqu'à vertex
     **/
	public ArrayList<VertexInterface> getShoertestPath(VertexInterface vertex); 
}
