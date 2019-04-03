/**
 * An ADT for Intersection Data for Seattle
 */
public class Intersection{
	private String fUnitDesc;	//Intersection description
	private String fStreetNS;	//Street in north-south direction
	private String fStreetEW;	//Street in east-west direction
	
	
	/**
	 * Constructor for an intersection
	 * 
	 * @param splitRead - array of intersections data from read module
	 */
	public Intersection(String[] splitRead) {
		this.fUnitDesc = splitRead[10];
		this.fStreetNS = fUnitDesc.split(" AND ")[0];
		this.fStreetEW = fUnitDesc.split(" AND ")[1];
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
