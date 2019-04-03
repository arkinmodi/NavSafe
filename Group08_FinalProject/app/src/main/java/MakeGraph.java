import java.io.File;
import java.io.IOException;

public class MakeGraph {

	public static void makeGraph() throws IOException {

		Intersection[] intersections = ReadIntersections.read();
		Street[] streets = ReadStreets.read();
		EdgeWeightedGraph G = new EdgeWeightedGraph(intersections.length);
		String file_path = new File("").getAbsoluteFile().getParentFile().getParentFile().getParentFile().getParent();

		for (int i = 0; i < streets.length; i++) {
			int int1 = SearchIntersections.search(streets[i].getName(), streets[i].getEnd1(), streets[i].getEnd2())[0];
			int int2 = SearchIntersections.search(streets[i].getName(), streets[i].getEnd1(), streets[i].getEnd2())[1];
			G.addEdge(intersections[int1-1], intersections[int2-1]);
		}
		
		G.writeGraph(file_path + "/data/outGraph.csv");
	}
}
