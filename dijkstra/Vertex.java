import java.util.LinkedList;


/**
 class to represent a  vertex in a graph
*/
public class Vertex {
   
    private LinkedList<AdjListNode> adjList ; // the adjacency list 
    private int index; // the index of this vertex in the graph
    //possibly other fields, for example representing data
    // stored at the node, whether the vertex has been visited
    // in a traversal, its predecessor in such a traversal, etc.
    
    boolean visited; // whether vertex has been visited in a traversal
    boolean inqueue; //wether the vertex is in djiktstra's queue
    int distance; //distance from start word vertex
    int predecessor; // index of predecessor vertex in a traversal
    String name; //word stored in Vertex

     
    /**
	 creates a new instance of Vertex
	 */
    public Vertex(int n) {
    	adjList = new LinkedList<AdjListNode>();
    	index = n;
    	visited = false;
	name="";
    }
    
    /**
	 copy constructor
	*/
    public Vertex(Vertex v){
    	adjList = v.getAdjList();
    	index = v.getIndex();
    	visited = v.getVisited();
	name=v.getName();
    }
     
    
    public LinkedList<AdjListNode> getAdjList(){
        return adjList;
    }
    
   public void setName(String n){
	name=n;
    }

    public String getName(){
	return name;
    }

       public void setDistance(int n){
	distance=n;
    }

    public int getDistance(){
	return distance;
    }


    public int getIndex(){
    	return index;
    }
    
    public void setIndex(int n){
    	index = n;
    }
    
    public boolean getVisited(){
    	return visited;
    }
    
    public void setVisited(boolean b){
    	visited = b;
    }
    
    public int getPredecessor(){
    	return predecessor;
    }
    
    public void setPredecessor(int n){
    	predecessor = n;
    }
    
    public void addToAdjList(int n){
        adjList.addLast(new AdjListNode(n));
    }
    
    public int vertexDegree(){
        return adjList.size();
    }
}
