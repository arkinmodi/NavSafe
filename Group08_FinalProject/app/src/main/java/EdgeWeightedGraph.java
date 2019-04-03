import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Edge weighted graph for the intersections and edges (roads) in Seattle.
 */
public class EdgeWeightedGraph{
    private int numIntersections;
    private int numEdges;
    private HashMap<Intersection, ArrayList<WeightedEdge>> adj;

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
        this.adj = new HashMap<Intersection, ArrayList<WeightedEdge>>();
    }

    /**
     * Get number of intersections in the graph
     * 
     * @return numIntersections - number of intersections in graph
     */
    public int getNumIntersections(){
        return numIntersections;
    }

    /**
     * Get number of edges in the graph
     * 
     * @return numEdges - number of edges in graph
     */
    public int getNumEdges(){
        return numEdges;
    }

    /**
     * Create a weighted edge from two intersections to add to the graph
     * 
     * @param x - first intersection
     * @param y - second intersection
     * @throws IOException
     */
    public void addEdge(Intersection x, Intersection y) throws IOException{
        //determine the weight of the edge
        int weight = SearchCollision.search(x, y);
        //create edge
        WeightedEdge e = new WeightedEdge(x, y, weight);
        //get the linked list of edges of intersection x
        ArrayList<WeightedEdge> edges = adj.get(x);
        //add edge to list
        edges.add(e);
        //overwrite the linked list associated with intersection x
        adj.put(x, edges);
        
        //perform same actions to intersection y
        edges = adj.get(y);
        edges.add(e);
        adj.put(y, edges);
        
        //increment number of edges by 1
        numEdges++;
    }

    /**
     * Get linked list of weighted edges that are connected to intersection x
     * @param x - intersection in question
     * @return array list of weighted edges connected to x
     */
    public ArrayList<WeightedEdge> adj(Intersection x){
        return adj.get(x);
    }

    /**
     * Write the graph to a given file name
     * 
     * @param fileName - file name to write to
     * @throws IOException
     */
    public void writeGraph(String fileName) throws IOException{
        String filePath = new File("").getAbsolutePath();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + fileName));
        
        writer.close();
    }
}