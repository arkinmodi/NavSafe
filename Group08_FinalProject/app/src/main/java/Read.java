import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads and extracts collision data from collisions.csv and stores each collision as an ADT
 */
public class Read {

	public static Collision[] read() throws IOException {
		
		Collision[] collisions = new Collision[200206]; //Array of collisions ADT
		
		String file_path = new File("").getAbsoluteFile().getParentFile().getParentFile().getParentFile().getParent();
		
		BufferedReader inFile = new BufferedReader(new FileReader(file_path + "/data/collisionsExtract.csv"));

		String read = null;
		
		int count = 0;
		
		while ((read = inFile.readLine()) != null && count != 200206) {
			String[] splitRead = read.replace("Not Enough Information, or Insufficient Location Information","").split(",");
			collisions[count] = new Collision(splitRead);
//			System.out.println(count);
			count += 1;
		}
		
		return collisions;
	}
}
