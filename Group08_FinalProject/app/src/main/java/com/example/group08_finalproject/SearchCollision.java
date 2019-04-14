package com.example.group08_finalproject;

import java.io.IOException;

/**
 * @brief Search module (linear search) for collisions contained in a street/edge between 2 intersections.
 * @author Leon So
 * 
 */
public class SearchCollision {
	
	/**
	 * @brief Searches for all collisions contained in street/edge between 2 intersections.
	 * @param x - com.example.group08_finalproject.Intersection on one end of the street (com.example.group08_finalproject.Intersection ADT)
	 * @param y	- com.example.group08_finalproject.Intersection on the opposite end of the street (com.example.group08_finalproject.Intersection ADT)
	 * @return weight - Returns summed weight of all collisions calculated based on severity code.
	 * @throws IOException
	 */
	public static int search(Intersection x, Intersection y) throws IOException {
		ReadWrite.readWrite();
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
				/*	SevCode		Weight
				 * 	0			1
				 * 	1			2
				 * 	2			3
				 * 	2b			4
				 * 	3			5
				 */
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
//		com.example.group08_finalproject.Intersection[] intersections = com.example.group08_finalproject.ReadIntersections.read();
//		System.out.println(intersections[1028]);
//		System.out.println(intersections[3654]);
//		System.out.println(intersections[1028].getNS());
//		System.out.println(intersections[1028].getEW());
//		int weight = search(intersections[1029],intersections[3655]);
//		System.out.println(weight);
//	}
}
