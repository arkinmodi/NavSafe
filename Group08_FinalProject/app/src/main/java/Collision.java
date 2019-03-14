import java.lang.reflect.Array;
/**
 * An ADT for Collision Data
 */
public class Collision{

	private float fXCoord;		//X-coordinate of collision location
	private float fYCoord;		//Y-coordinate of a collision location
	private String fColDesc;	//Collision description
	private String fColType; 	//Collision type
	private String fJuncType; 	//Junction type
	private String fLightCond;	//Light conditions
	private String fRoadCond;	//Road conditions
	private String fSevCode; 	//Severity code
	private String fSevDesc;	//Severity description
	private String fWeather;	//Weather conditions
	private int fPedCount;		//pedestrian count
	private int fInjuries; 		//number of injuries
	private int fSInjuries;		//number of serious injuries
	private int fFatalities;	//number of fatalities
	
	
	/**
	 * Constructor for an intersection
	 * @param splitRead - array of collision data from read module
	 */
	public Collision(String[] splitRead) {
		this.fXCoord = Integer.parseInt(splitRead[0]);
		this.fYCoord = Integer.parseInt(splitRead[1]);
		//TODO
	}
	
	/**
	 * Gets x-coordinate for an intersection
	 * @return fXCoord - The x-coordinate
	 */
	public float getXCoord() {
		return fXCoord;
	}
	
	/**
	 * Gets y-coordinate for an intersection
	 * @return fYCoord - The y-coordinate
	 */
	public float getYCoord() {
		return fYCoord;
	}

	/** 
	 * Gets description of collision
	 * @return fColDesc - collision description
	 */
	public String getColDesc(){
		return fColDesc;
	}

	/**
	 * Gets collision type
	 * @return fColType - collision type
	 */
	public String getColType(){
		return fColType;
	}
}
