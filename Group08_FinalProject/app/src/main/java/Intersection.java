/**
 * An ADT for Intersection Data for Seattle
 */
public class Intersection implements Comparable<Intersection>{
	private float fXCoord;		//X-coordinate of intersection location
	private float fYCoord;		//Y-coordinate of intersection location
	private String fUnitDesc;	//Intersection description
	private String fStreetNS;	//Street in north-south direction
	private String fStreetEW;	//Street in east-west direction
	
	
	/**
	 * Constructor for an intersection
	 * 
	 * @param splitRead - array of intersections data from read module
	 */
	public Intersection(String[] splitRead) {
		this.fXCoord = Float.parseFloat(splitRead[0]);
		this.fYCoord = Float.parseFloat(splitRead[1]);
		this.fUnitDesc = splitRead[10];
		this.fStreetNS = fUnitDesc.split(" AND ")[0];
		this.fStreetEW = fUnitDesc.split(" AND ")[1];
	}

	/**
	 * Second constructor for an intersection - necessary for DijkstraSP.java
	 * 
	 * @param xCoord - x coordinate
	 * @param yCoord - y coordinate
	 * @param unitDesc - description of intersection
	 */
	public Intersection(String xCoord, String yCoord, String unitDesc){
		this.fXCoord = Float.parseFloat(xCoord);
		this.fYCoord = Float.parseFlot(yCoord);
		this.fUnitDesc = unitDesc;
		this.fStreetNS = fUnitDesc.split(" AND ")[0];
		this.fStreetEW = fUnitDesc.split(" AND ")[1];
	}

	/**
	 * Gets x-coordinate for an intersection
	 * 
	 * @return fXCoord - The x-coordinate
	 */
	public float getXCoord() {
		return fXCoord;
	}
	
	/**
	 * Gets y-coordinate for an intersection
	 * 
	 * @return fYCoord - The y-coordinate
	 */
	public float getYCoord() {
		return fYCoord;
	}
	
	/** 
	 * Gets description of intersection
	 * 
	 * @return fUnitDesc - intersection description
	 */
	public String getUnitDesc(){
		return fUnitDesc;
	}
	
	/** 
	 * Gets NS street
	 * 
	 * @return fStreetNS - street of intersection in north-south direction
	 */
	public String getNS(){
		return fStreetNS;
	}
	
	/** 
	 * Gets EW street
	 * 
	 * @return fStreetEW - street of intersection in east-west direction
	 */
	public String getEW(){
		return fStreetEW;
	}
	
	public String toString(){
		return ("StreetNS: " + fStreetNS +" StreetEW: " + fStreetEW); 
	}
	
	/**
	 * Compares two intersections based on Unit Desc
	 * 
	 * @param j - an intersection
	 * @return value - number indicating whether less than or not
	 */
	public int compareTo(Intersection j) {
			int value = 0;
			int i = 0;
			int k = 0;
			String  unitDesc1 = fUnitDesc;
			String unitDesc2 = j.getUnitDesc();
			int length1 = unitDesc1.length();
			int length2 = unitDesc2.length();

			while (i < length1 && k < length2) {
				char c1 = unitDesc1.charAt(i);
				char c2 = unitDesc2.charAt(k);
				if (c1 < c2) {
					value = -1;
					return value;
				} else if (c1 > c2) {
					value = 1;
					return value;
				}
				i += 1;
				k += 1;
			}

			if (value == 0) {
				if (length1 < length2) {
					value = -1;
					return value;
				} else {
					value = 1;
					return value;
				}
			}
		
		// Else return value
		return value;
	}
}
