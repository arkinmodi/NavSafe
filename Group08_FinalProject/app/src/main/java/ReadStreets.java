import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads and extracts street data from Seattle_streets.csv and stores each street as an ADT
 */
public class ReadStreets {

	public static Street[] read() throws IOException {
		
		Street[] streets = new Street[23798]; //Array of street ADTs
		
		String file_path = new File("").getAbsoluteFile().getParentFile().getParentFile().getParentFile().getParent();
		
		BufferedReader inFile = new BufferedReader(new FileReader(file_path + "/data/Seattle_Streets.csv"));

		String read = null;
		
		int count = 0;
		
		read = inFile.readLine();
		while ((read = inFile.readLine()) != null) {
			String[] splitRead = read.split(",");
			streets[count] = new Street(splitRead);
//			System.out.println(count);
			count += 1;
		}
		
		return streets;
	}
}