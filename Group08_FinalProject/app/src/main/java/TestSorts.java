import com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import java.io.IOException;

public class TestSorts {

	@Test
	public void testSortCollisions() throws IOException {
		Collision[] collisions = Read.read();
		
		SortCollisions.sort(collisions, collisions.length);

		assert(collisions[0].toString().equals("X-coord: -122.327644 Y-coord: 47.630596 Collision Description: \"MOTOR VEHICLE STRUCK PEDALCYCLIST Collision Type:  Junction Type: At Intersection (intersection related) Light Condition:  Severe Injuries: 0 Severity Code:  Fatalities: 0 Injuries: 0"));
		assert(collisions[1].toString().equals("X-coord: -122.28652 Y-coord: 47.587086 Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));
		assert(collisions[2].toString().equals("X-coord: -122.38055 Y-coord: 47.69398 Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));
		assert(collisions[3].toString().equals("X-coord: -122.33512 Y-coord: 47.587166 Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));

		assert(collisions[collisions.length-6].toString().equals("X-coord: -122.32313 Y-coord: 47.520477 Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 1 Severity Code: 3 Fatalities: 2 Injuries: 4"));
		assert(collisions[collisions.length-5].toString().equals("X-coord: -122.29264 Y-coord: 47.68305 Collision Description: MOTOR VEHCILE STRUCK PEDESTRIAN Collision Type: Pedestrian Junction Type: At Intersection (intersection related) Light Condition:  Severe Injuries: 2 Severity Code: 3 Fatalities: 2 Injuries: 2"));
		assert(collisions[collisions.length-4].toString().equals("X-coord: -122.341995 Y-coord: 47.57143 Collision Description: MOTOR VEHICLE STRUCK OBJECT IN ROAD Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 3 Fatalities: 3 Injuries: 0"));
		assert(collisions[collisions.length-3].toString().equals("X-coord: -122.39537 Y-coord: 47.66827 Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT Collision Type: Other Junction Type: Mid-Block (but intersection related) Light Condition:  Severe Injuries: 1 Severity Code: 3 Fatalities: 3 Injuries: 1"));
		assert(collisions[collisions.length-2].toString().equals("X-coord: -122.26115 Y-coord: 47.520317 Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 3 Fatalities: 4 Injuries: 0"));
		assert(collisions[collisions.length-1].toString().equals("X-coord: -122.3473 Y-coord: 47.64717 Collision Description: MOTOR VEHICLE STRUCK OBJECT IN ROAD Collision Type: Head On Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 41 Severity Code: 3 Fatalities: 5 Injuries: 78"));
	
		//sorting an empty array
		Collision[] empty = {};
		SortCollisions.sort(empty, empty.length);
		assert(empty.length == 0);
	}
	
	@Test
	public void testSortIntersections() throws IOException {
		Intersection[] intersections = ReadIntersections.read();
		
		SortIntersectionDropDown.sort(intersections, intersections.length);

		assert(intersections[intersections.length-6].toString().equals("StreetNS: YALE AVE N StreetEW: DEAD END 2"));
		assert(intersections[intersections.length-1].toString().equals("StreetNS: YUKON AVE S StreetEW: S HENDERSON ST"));
		
		//sorting an empty array
		Intersection[] empty = {};
		SortIntersectionDropDown.sort(empty, empty.length);
		assert(empty.length == 0);
	}
}
