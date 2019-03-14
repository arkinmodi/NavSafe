import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sort.Product;

/**
 * Reads and extracts collision data from collisions.csv and stores each collision as an ADT
 */
public class Read {

	private Collision[] collisions = new Collision[205580];
			
	public void read() throws IOException {
		
		BufferedReader inFile = new BufferedReader(new FileReader("collisions.csv"));

		String read = null;
		int count = 0;
		while ((read = inFile.readLine()) != null) {
			String[] splitRead = read.split(",");
			collisions[count] = new Collision(splitRead);
			count += 1;
		}
	}
}
