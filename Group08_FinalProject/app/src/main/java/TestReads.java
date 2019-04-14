import com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import java.io.IOException;

public class TestReads {

	@Test
	public void testRead() throws IOException {
		Collision[] collisions = Read.read();
		assert(collisions[0].getLocation().equals("AIRPORT WAY S BETWEEN S HILL ST AND S WALKER N ST"));
		assert(collisions[0].getSevCode().equals("2"));
		assert(collisions[0].getSevDesc().equals("Injury Collision"));
		assert(collisions[0].getInjuries() == 1);
		assert(collisions[0].getSInjuries() == 0);
		assert(collisions[0].getFatalities() == 0);
		
		assert(collisions[1].getLocation().equals("35TH AVE NE AND NE 55TH ST"));
		assert(collisions[1].getSevCode().equals("2"));
		assert(collisions[1].getSevDesc().equals("Injury Collision"));
		assert(collisions[1].getInjuries() == 1);
		assert(collisions[1].getSInjuries() == 0);
		assert(collisions[1].getFatalities() == 0);
		
		assert(collisions[200205].getLocation().equals("15TH AVE NE BETWEEN NE 117TH ST AND PINEHURST WAY NE"));
		assert(collisions[200205].getSevCode().equals("1"));
		assert(collisions[200205].getSevDesc().equals("Property Damage Only Collision"));
		assert(collisions[200205].getInjuries() == 0);
		assert(collisions[200205].getSInjuries() == 0);
		assert(collisions[200205].getFatalities() == 0);
	}
	
	@Test
	public void testReadIntersections() throws IOException {
		Intersection[] intersections = ReadIntersections.read();
		assert(intersections[0].getUnitDesc().equals("MARSHALL AVE SW AND SW EDDY ST"));
		assert(intersections[0].getNS().equals("MARSHALL AVE SW"));
		assert(intersections[0].getEW().equals("SW EDDY ST"));

		assert(intersections[1].getUnitDesc().equals("42ND AVE W AND W ARMOUR ST"));
		assert(intersections[1].getNS().equals("42ND AVE W"));
		assert(intersections[1].getEW().equals("W ARMOUR ST"));
		
		assert(intersections[11360].getUnitDesc().equals("6TH AVE W AND W OLYMPIC W PL"));
		assert(intersections[11360].getNS().equals("6TH AVE W"));
		assert(intersections[11360].getEW().equals("W OLYMPIC W PL"));
		
		assert(intersections[15428].getUnitDesc().equals("1ST AVE W AND W ROY ST"));
		assert(intersections[15428].getNS().equals("1ST AVE W"));
		assert(intersections[15428].getEW().equals("W ROY ST"));
	}
	
	@Test
	public void testReadStreets() throws IOException {
		Street[] streets = ReadStreets.read();
		assert(streets[0].getName().equals("1ST AVE BETWEEN SENECA ST AND UNIVERSITY ST"));
		assert(streets[0].getEnd1().equals("1ST AVE"));
		assert(streets[0].getEnd2().equals("SENECA ST"));
		
		assert(streets[1].getName().equals("1ST AVE BETWEEN WARREN PL AND BAY ST"));
		assert(streets[1].getEnd1().equals("1ST AVE"));
		assert(streets[1].getEnd2().equals("WARREN PL"));
		
		assert(streets[90].getName().equals("15TH AVE SW BETWEEN SW HOLLY ST AND DEAD END 3"));
		assert(streets[90].getEnd1().equals("15TH AVE SW"));
		assert(streets[90].getEnd2().equals("SW HOLLY ST"));
		
		assert(streets[23797].getName().equals("28TH AVE NE BETWEEN NE 72ND S ST AND NE 72ND N ST"));
		assert(streets[23797].getEnd1().equals("28TH AVE NE"));
		assert(streets[23797].getEnd2().equals("NE 72ND S ST"));
	}
}
