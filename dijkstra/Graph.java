import java.util.LinkedList;
import static java.lang.System.*;
import java.io.*;
import java.util.*;
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

public int position( String s1, String s2){ //function for finding the position where the character differs between two words
	int x=0;
	for (int i=0; i<s1.length(); i++){
		char a= s1.charAt(i);
		char b= s2.charAt(i);
		if(a!=b){
			x=i;}
		}
	return x;
	
	}


public void dijkstra(int startword, int endword){
	
	Vertex v=getVertex(startword); //locate start word
  	Vertex u=getVertex(endword); //locate end word
	List<Integer> distances = new ArrayList<Integer>();
	List<Vertex> S = new ArrayList<Vertex>();
	int fresult=0;

	S.add(v);
	for (Vertex a : vertices) {
		if ( a.equals(v)){// for all vertices except the start word
			continue;
			}
		a.setDistance(Integer.MAX_VALUE); //set distance to infinity for all vertices
		a.setPredecessor(startword); // set start word as a predecessor
		}

	LinkedList<AdjListNode> list = v.getAdjList(); // get adjacency list of the vertex
        for (AdjListNode node : list) {
		Vertex w = vertices[node.getVertexNumber()];
		String s1=v.getName();
		String s2=w.getName();
		int po=position(s1,s2);
		int result = ((int)s2.toLowerCase().charAt(po) - (int)s1.toLowerCase().charAt(po)); //calculate distance between characters
	 	result = Math.abs(result);
		distances.add(result);
		w.setDistance(result);
		}
	if(S.size()!=0){ //find the min distance
		int min=distances.get(0);
		for(int i=0; i<distances.size(); i++){
			int x=distances.get(i);
			if(x<=min){
				min=x;
				}
			}
		for(AdjListNode node : list){ //locate vertex with min distance
			Vertex w = vertices[node.getVertexNumber()];
			int n=w.getDistance();
			if (n==min){
				S.add(w);	//add vertex to S queue			
				}
			}	
	}
	for(AdjListNode node : list){
			Vertex y = vertices[node.getVertexNumber()];
			if(!S.contains(y)){			
					int n=y.getDistance();
					for(Vertex q:S){ //loop contains relaxation function
						String s1=q.getName();
						String s2=y.getName();
						String s3=v.getName();
						int po2=position(s1,s2);
						int r1 = ((int)s2.toLowerCase().charAt(po2) - (int)s1.toLowerCase().charAt(po2));
						r1 = Math.abs(r1);
						int po=position(s1,s2);
						int r2 = ((int)s3.toLowerCase().charAt(po2) - (int)s2.toLowerCase().charAt(po2));
						r2 = Math.abs(r2);
						r2+=r1;
						if(r2!=0){
							if(r2<=n){
								distances.add(r2); // add result of relaxation function to distance array
								 }
							}
						}
					}
			int min=distances.get(0); //find min result in distance array
			for(int i=0; i<distances.size(); i++){
				int x=distances.get(i);
					if(x<min){
					min=x;
					fresult=min;
						}
					}
			for(AdjListNode node2 : list){ //locate vertex with min distance
				Vertex w = vertices[node2.getVertexNumber()];
				int k=w.getDistance();
			if (k==min){
				S.add(w); //add vertex to S queue					
			}
		}							
					}
				if(S.contains(u)){ // if S queue contains the end word
					System.out.println("Distance is " + fresult +".");
					}
				else{
					System.out.println("No path");
					}
				}
			}
