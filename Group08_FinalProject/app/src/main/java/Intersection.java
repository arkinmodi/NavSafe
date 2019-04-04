/**
 * An ADT for Intersection Data for Seattle
 */
public class Intersection{
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
	 * Constructor for an intersection given the x coordinate, y coordinate and unit description
	 * 
	 * @param fXCoord - x coordinate
	 * @param fYCoord - y coordinate
	 * @param unitDesc - unit description of intersection
	 */
	public Intersection(String fXCoord, String fYCoord, String unitDesc){
		this.fXCoord = Float.parseFloat(fXCoord);
		this.fYCoord = Float.parseFloat(fYCoord);
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
}
