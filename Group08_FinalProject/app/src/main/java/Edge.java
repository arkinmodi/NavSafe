/**
 * ADT for a street edge.
 * A street edge is defined as a road connecting two adjacent vertices.
 * Vertices are represented by the intersections
 */
public class Edge{
    private final String streetName;
    private final Intersection firstIntersection;
    private final Intersection secondIntersection;
    private final int edgeWeight;

    public Edge(int edgeWeight){
        

        this.edgeWeight = edgeWeight;
    }

    /**
     * Get edge weight
     * 
     * @return edgeWeight - edge weight
     */
    public int getWeight(){
        return edgeWeight;
    }
}