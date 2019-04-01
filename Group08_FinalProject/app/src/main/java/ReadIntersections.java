import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads and extracts intersection data from SeattleIntersections.csv and stores each intersection as an ADT
 */
public class ReadIntersections {

	public static Intersection[] read() throws IOException {
		
		Intersection[] intersections = new Intersection[15429]; //Array of intersections ADT
		
		String file_path = new File("").getAbsolutePath();
		
		BufferedReader inFile = new BufferedReader(new FileReader(file_path + "/data/SeattleIntersections.csv"));

		String read = null;
		
		int count = 0;
		
		read = inFile.readLine();
		while ((read = inFile.readLine()) != null) {
			String[] splitRead = read.split(",");
			intersections[count] = new Intersection(splitRead);
//			System.out.println(count);
			count += 1;
		}
		
		return intersections;
	}
}
