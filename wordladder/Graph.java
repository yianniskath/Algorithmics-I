import java.util.LinkedList;
import static java.lang.System.*;

/**
 class to represent an undirected graph using adjacency lists
 */
public class Graph {

	private Vertex[] vertices; // the (array of) vertices
	private int numVertices = 0; // number of vertices

	// possibly other fields representing properties of the graph

	/**
	 creates a new instance of Graph with n vertices
	*/
	public Graph(int n) {
		numVertices = n;
		vertices = new Vertex[n];
		for (int i = 0; i < n; i++)
			vertices[i] = new Vertex(i);
	}

	public int size() {
		return numVertices;
	}

	public Vertex getVertex(int i) {
		return vertices[i];
	}

	public void setVertex(int i) {
		vertices[i] = new Vertex(i);
	}

	/**
	 visit vertex v, with predecessor index p,
	 during a depth first traversal of the graph
	 */
	private void Visit(Vertex v, int p) {
		v.setVisited(true);
		v.setPredecessor(p);
		LinkedList<AdjListNode> L = v.getAdjList();
		for (AdjListNode node : L) {
			int n = node.getVertexNumber();
			if (!vertices[n].getVisited()) {
				Visit(vertices[n], v.getIndex());
			}
		}
	}

	/**
     carry out a depth first search/traversal of the graph
	 */
	public void dfs() {
		for (Vertex v : vertices)
			v.setVisited(false);
		for (Vertex v : vertices)
			if (!v.getVisited())
				Visit(v, -1);
	}



		public void shortestpath(int startword, int endword) {
		
		for (Vertex v : vertices) {
			v.setVisited(false);
			v.setDfpr(0);} // initialise (all vertices unvisted)
  		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		boolean lad=false;

		Vertex startw=getVertex(startword);
  		Vertex endw=getVertex(endword);
  		
      			queue.add(startw); // add to queue for processing
      			while (!queue.isEmpty()) {
        			Vertex u = queue.remove(); // get next vertex to process
				LinkedList<AdjListNode> list = u.getAdjList(); // get adjacency list of the vertex
        			for (AdjListNode node : list) {
						Vertex w = vertices[node.getVertexNumber()];
						if (!w.getVisited()) { // if vertex has not been visited
							w.setVisited(true);
							w.setPredecessor(u.getIndex()); // w was found using u so this is the predecessor
							queue.add(w); // add to queue for processing*/
							int n=(u.getDfpr());
							w.setDfpr(n+1); //add 1 to the distance from predecessor
							if (w.equals(endw)){ // if vertex equals the end word
								System.out.println("Distance is "+ w.getDfpr()+".");
								lad=true;
								}
							
						}
					}
				}
			if (!lad){
				System.out.println("No ladder.");
						}
					}
		}
	

