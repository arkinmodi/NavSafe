import java.io.IOException;

public class SearchCollision {
	public static int search(Intersection x, Intersection y) throws IOException {
		// Variable Declarations
		int weight = 0; // Sum of severities of all collisions
		String int1NS = x.getNS(); // North-south street of intersection x
		String int1EW = x.getEW(); // East-west street of intersection x
		String int2NS = y.getNS(); // North-south street of intersection y
		String int2EW = y.getEW(); // East-west street of intersection y
		Collision[] collisions = Read.read(); // Array of collisions
		
		for (int i = 0; i < collisions.length; i++) {
			//Check if collision is between 2 intersections or occurs on one of the 2 intersections
			if ((collisions[i].getLocation().contains("BETWEEN") && ((collisions[i].getLocation().contains(int1NS)
					&& collisions[i].getLocation().contains(int2NS))
					|| (collisions[i].getLocation().contains(int1EW)
							&& collisions[i].getLocation().contains(int2EW))))
					|| ((!(collisions[i].getLocation().contains("BETWEEN"))
							&& ((collisions[i].getLocation().contains(int1NS)
									&& collisions[i].getLocation().contains(int1EW))
									|| (collisions[i].getLocation().contains(int2EW)
											&& collisions[i].getLocation().contains(int2NS)))))) {
				
				//Get sevcode and add assigned sevcode value to weight
				if (collisions[i].getSevCode().equals("0")) {
					weight += 1;
				} else if (collisions[i].getSevCode().equals("1")){
					weight += 2;
				} else if (collisions[i].getSevCode().equals("2")) {
					weight += 3;
				} else if (collisions[i].getSevCode().equals("2b")) {
					weight += 4;
				} else if (collisions[i].getSevCode().equals("3")) {
					weight += 5;
				}
			}
		}
		return weight;
	}
	
	//Uncomment to test
//	public static void main(String[] args) throws IOException {
//		Intersection[] intersections = ReadIntersections.read();
//		System.out.println(intersections[1028]);
//		System.out.println(intersections[3654]);
//		System.out.println(intersections[1028].getNS());
//		System.out.println(intersections[1028].getEW());
//		int weight = search(intersections[1029],intersections[3655]);
//		System.out.println(weight);
//	}
}
