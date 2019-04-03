import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Reads and extracts collision data from collisions.csv and stores each
 * collision as an ADT
 */
public class ReadWrite {

	public static void readWrite() throws IOException {

		String file_path = new File("").getAbsoluteFile().getParentFile().getParentFile().getParentFile().getParent();

		BufferedReader inFile = new BufferedReader(new FileReader(file_path + "/data/collisions.csv"));
		BufferedWriter writer = new BufferedWriter(new FileWriter(file_path + "/data/collisionsExtract.csv"));

		String read = null;

		int count = 0;

		read = inFile.readLine();
		while ((read = inFile.readLine()) != null) {
			String[] splitRead = read.split(",");
			if (splitRead[0].equals("") == false) {
				writer.write(read);
				writer.newLine();
			}
		}
		writer.close();
		inFile.close();
	}
	
	public static void main(String[] args) throws IOException {
		readWrite();
		
	}

}

