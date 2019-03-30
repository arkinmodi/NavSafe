import java.lang.reflect.Array;

import sort.Product;
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
	 * 
	 * @param splitRead - array of collision data from read module
	 */
	public Collision(String[] splitRead) {
		this.fXCoord = Integer.parseInt(splitRead[0]);
		this.fYCoord = Integer.parseInt(splitRead[1]);
		//TODO Complete when read file is complete
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
	 * Gets description of collision
	 * 
	 * @return fColDesc - collision description
	 */
	public String getColDesc(){
		return fColDesc;
	}

	/**
	 * Gets collision type
	 * 
	 * @return fColType - collision type
	 */
	public String getColType(){
		return fColType;
	}

	/**
	 * Get junction type of collision
	 * 
	 * @return fJuncType - junction type
	 */
	public String getJuncType(){
		return fJuncType;
	}

	/**
	 * Get light condition during collision
	 * 
	 * @return fLightCond - light condition during collision
	 */
	public String getLightCond(){
		return fLightCond;
	}

	/**
	 * Get road condition during collision
	 * 
	 * @return fRoadCond - road condition during collision
	 */
	public String getRoadCond(){
		return fRoadCond;
	}

	/**
	 * Get severity code
	 * 
	 * @return fSevCode - severity code
	 */
	public String getSevCode(){
		return fSevCode;
	}

	/**
	 * Get severity description
	 * 
	 * @return fSevDesc - severity description
	 */
	public String getSevDesc(){
		return fSevDesc;
	}

	/**
	 * Get weather conditions of a collsion
	 * 
	 * @return fWeather - weather conditions during accident
	 */
	public String getWeather(){
		return fWeather;
	}

	/**
	 * Get pedestrian count involved a collsiion
	 * 
	 * @return fPedCount - number of pedestrians
	 */
	public int getPedCount(){
		return fPedCount;
	}

	/**
	 * Get injury count from a collision
	 * 
	 * @return fInjuries - number of injuries
	 */
	public int getInjuries(){
		return fInjuries;
	}

	/**
	 * Get count of severe injuries from a collision
	 * 
	 * @return fSInjuries - number of severe injuries
	 */
	public int getSInjuries(){
		return fSInjuries;
	}

	/**
	 * Get fatality count from a collision
	 * 
	 * @return fFatalities - number of fatalities
	 */
	public int getFatalities(){
		return fFatalities;
	}
	
	/**
	 * Compares two collisions based on severity, if severity equal, then sort by fatalities, if
	 * fatalities equal, then sort by number of injuries
	 * 
	 * @param j - a collision
	 * @return value - number indicating whether less than or not
	 */
	public int compareTo(Collision j) {
		// TODO
//		int value = (fSales - j.sales());
//		if (value == 0) {
//			int i = 0;
//			int k = 0;
//			String id1 = fId;
//			String id2 = j.id();
//			int length1 = id1.length();
//			int length2 = id2.length();
//
//			while (i < length1 && k < length2 && value == 0) {
//				char c1 = id1.charAt(i);
//				char c2 = id2.charAt(k);
//				if (c1 < c2) {
//					value = -1;
//					return value;
//				} else if (c1 > c2) {
//					value = 1;
//					return value;
//				}
//				i += 1;
//				k += 1;
//			}
//			if (value == 0) {
//				if (length1 < length2) {
//					value = -1;
//					return value;
//				} else {
//					value = 1;
//					return value;
//				}
//			}
//		}
//		// Else return value
//		return value;
	}
}
