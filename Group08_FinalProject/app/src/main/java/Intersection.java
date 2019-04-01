/**
 * An ADT for Intersection Data for Seattle
 */
public class Intersection{

	private float fXCoord;		//X-coordinate of collision location
	private float fYCoord;		//Y-coordinate of a collision location
	private String fUnitDesc;	//Intersection description
	
	
	/**
	 * Constructor for an collision
	 * 
	 * @param splitRead - array of collision data from read module
	 */
	public Intersection(String[] splitRead) {
		this.fXCoord = Float.parseFloat(splitRead[0]);
		this.fYCoord = Float.parseFloat(splitRead[1]);
		this.fUnitDesc = splitRead[10];
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
}
