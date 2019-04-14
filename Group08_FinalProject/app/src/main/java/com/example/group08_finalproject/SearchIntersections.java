package com.example.group08_finalproject;

import java.io.IOException;

public class SearchIntersections {
	public static Integer[] search(String streetName, String streetEnd1, String streetEnd2) throws IOException {

		Intersection[] intersections = ReadIntersections.read();

		int intersection1 = intersections.length;
		int intersection2 = intersections.length;
		
		for (int i = 0; i < intersections.length; i++) {
			if (intersections[i].getUnitDesc().contains(streetName)
					&& intersections[i].getUnitDesc().contains(streetEnd1)) {
				intersection1 = i;
			}
			
			if (intersections[i].getUnitDesc().contains(streetName)
					&& intersections[i].getUnitDesc().contains(streetEnd2)) {
				intersection2 = i;
			}
			
			if ((intersection1 != intersections.length) && (intersection2 != intersections.length)) {
				break;
			}
		}
		return new Integer[] {intersection1, intersection2};
	}
}
