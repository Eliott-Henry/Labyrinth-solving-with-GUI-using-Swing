package dijkstra;
import java.util.ArrayList;

/** Classe de l'algorithme de Dijkstra
 * @author Eliott Henry
 */

public class Dijkstra {
	
	/** Pour un graphe, un sommet d'origine donné, un ensemble de sommets, une mesure de distance, et un previous renvoie ce qui contient le chemin le plus court au sommet d'origine
	 * @param g Le graphe considéré
	 * @param r Le sommet d'orgine
	 * @return  Previous
	 **/
	
	private final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		
		ArrayList<VertexInterface> vertexList = g.getAllVertexes();
		int n = vertexList.size();
				
		a.add(r);
		VertexInterface pivot = r;
		pi.setWeight(r, 0);
		
		for(VertexInterface vertex : vertexList) {
			pi.setWeight(vertex, Integer.MAX_VALUE);
		}
		
		for(int j = 0; j < n; j++) {
			ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			for(VertexInterface successor : successors) {
				if(a.contains(successor) == false) {
					int dist = pi.getWeight(pivot) + g.getWeight(pivot, successor);
					if(dist < pi.getWeight(successor)) {
						pi.setWeight(successor, dist);
						previous.setValue(successor, pivot);
					}
				}
			}
			
			VertexInterface newPivot = null;
			int dist = Integer.MAX_VALUE;
			
			for(VertexInterface vertex : vertexList) {
				if(a.contains(vertex) == false) {
					if(pi.getWeight(vertex) < dist) {
						dist = pi.getWeight(vertex);
						newPivot = vertex;
					}
				}
			}
			
			if(newPivot == null) {
				return previous;
			}
			
			a.add(newPivot);
			pivot = newPivot;
		}
		
		return previous;
	}
	
	/** Pour un graphe et un sommet d'origine donné, renvoie ce qui contient les chemins le plus court jusqu'à le sommet d'origine
	 * @param g Le graphe considéré
	 * @param r Le sommet d'orgine
	 * @return  Previous
	 **/
	public final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		return dijkstra(g, r, new ASet(), new Pi(), new Previous());
	}

	
}
