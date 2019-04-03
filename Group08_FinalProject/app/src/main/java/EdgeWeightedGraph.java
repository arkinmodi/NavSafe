import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Edge weighted graph for the intersections and edges (roads) in Seattle.
 */
public class EdgeWeightedGraph{
    private int numIntersections;
    private int numEdges;
    private HashMap<Intersection, LinkedList<WeightedEdge>> adj;

    /**
     * Constructor for an edge weighted graph - intersections not connected
     * 
     * @param numIntersections - number of intersections
     */
    public EdgeWeightedGraph(int numIntersections)
    {
        if(numIntersections < 0){
            throw new IllegalArgumentException("Number of intersections must be positive");
        }
        this.numIntersections = numIntersections;
        this.numEdges = 0;
        this.adj = new HashMap<Intersection, LinkedList<WeightedEdge>>();
    }

    public int getNumIntersections(){
        return numIntersections;
    }

    public int getNumEdges(){
        return numEdges;
    }

    public void addEdge(Intersection x, Intersection y) throws IOException{
        int weight = SearchCollision.search(x, y);
        WeightedEdge e = new WeightedEdge(x, y, weight);
        LinkedList<WeightedEdge> edges = adj.get(x);
        edges.add(e);
        adj.put(x, edges);
        
        edges = adj.get(y);
        edges.add(e);
        adj.put(y, edges);
        
    }

}