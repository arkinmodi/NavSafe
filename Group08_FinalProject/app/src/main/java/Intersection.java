import java.lang.reflect.Array;
/**
 * An ADT for Intersection Collision Data
 */
public class Intersection {

	private String fColDesc;	//Collision description
	private String fColType; 	//Collision type
	private String fJuncType; 	//Junction type
	private String fLightCond;
	private String fRoadCond;
	private String fSevCode; 	//Severity code
	private String fSevDesc;	//Severity description
	private String fWeather;
	private float fXCoord;
	private float fYCoord;
	
	/**
	 * Constructor for an intersection
	 */
	public Intersection(String[] splitRead) {
		this.fXCoord = Integer.parseInt(splitRead[0]);
		this.fYCoord = Integer.parseInt(splitRead[1]);
	}
	
	/**
	 * Gets x-coordinate for an intersection
	 * @return fXCoord - The x-coordinate
	 */
	public float xCoord() {
		return fXCoord;
	}
	
	/**
	 * Gets y-coordinate for an intersection
	 * @return fYCoord - The y-coordinate
	 */
	public float yCoord() {
		return fYCoord;
	}
}
