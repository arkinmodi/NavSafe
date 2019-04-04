import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
/**
 * Dijkstra's Algorithm for shortest-paths.
 * Used on a collision edge-weighted graph to calculate the "shortest path".
 * The shortest path is the safest path.based on a "score" for collisions.
 * A score is derived by the severity, fatalities, severe and minor injuries
 * in former collisions on the path, with precedence in the order given.
 */
public class DijkstraSP{
    // first intersection is the newest intersection to be added to path
    // second intersection is the intersection connecting the first intersection to path
    private HashMap<Intersection, Intersection> edgeTo;
    private HashMap<Intersection, Integer> distTo; //key = intersection, value = total weight from start
    private IndexMinPQ<Double> pq;
    EdgeWeightedGraph G;
    Intersection start;

    public DijkstraSP(String fileName, Intersection start) throws FileNotFoundException, IOException{
        edgeTo = new HashMap<Intersection, Intersection>();
        distTo = new HashMap<Intersection, Integer>();
        G = new EdgeWeightedGraph(15429);

        String filePath = new File("").getAbsoluteFile().getParentFile().getParentFile().getParentFile().getParent();
        BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName));
        String line;
        while((line = reader.readLine()) != null)
        {
            String[] split = line.split(", ");
            Intersection x = new Intersection(split[0], split[1], split[2]);
            Intersection y = new Intersection(split[3], split[4], split[5]);
            G.addEdge(x, y, Integer.parseInt(split[6]));
            distTo.put(x, Integer.MAX_VALUE);
            distTo.put(y, Integer.MAX_VALUE);
        }
        distTo.put(start, 0);
        pq = new IndexMinPQ<Double>(G.getNumIntersections());
    }
}