import java.lang.reflect.Array;

/**
 * An ADT for Collision Data
 */
public class Collision implements Comparable<Collision>{

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
	 * Constructor for an collision
	 * 
	 * @param splitRead - array of collision data from read module
	 */
	public Collision(String[] splitRead) {
		this.fXCoord = Float.parseFloat(splitRead[0]);
		this.fYCoord = Float.parseFloat(splitRead[1]);
		this.fJuncType = splitRead[24];
		this.fSevCode = splitRead[12];
		this.fSevDesc = splitRead[13];
		this.fColType = splitRead[14];
		this.fColDesc = splitRead[26];
		this.fWeather= splitRead[29];
		this.fRoadCond= splitRead[30];
		this.fLightCond= splitRead[31];
		this.fPedCount = Integer.parseInt(splitRead[16]);
		this.fInjuries = Integer.parseInt(splitRead[19]);
		this.fSInjuries= Integer.parseInt(splitRead[20]);
		this.fFatalities = Integer.parseInt(splitRead[21]);
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
	 * Represent collision as a String
	 * 
	 * @return collisionStr - string representation
	 */
	public String toString(){
		return ("X-coord: " + fXCoord + " Y-coord: " + fYCoord + 
				" Collision Description: " + fColDesc + " Collision Type: " + 
				fColType + " Junction Type: " + fJuncType + " Light Condition: " +
				fLightCond + " Road Condition: " + fRoadCond +
				" Severity Description: " + fSevDesc + " Weather: " + fWeather + " Pedestrian Count: " + fPedCount +
				" Severe Injuries: " + fSInjuries + " Severity Code: " + fSevCode + " Fatalities: " + fFatalities + " Injuries: " + fInjuries); 
	}
	
	/**
	 * Compares two collisions based on number of severity code, then fatalities, then serious injuries, then number of injuries
	 * 
	 * @param j - a collision
	 * @return value - number indicating whether less than or not
	 */
	public int compareTo(Collision j) {
//		String sevCode1 = fSevCode;
//		String sevCode2 = j.getSevCode();
//
//		System.out.print(sevCode1);
//		if (sevCode1.charAt(0) < sevCode2.charAt(0)) { // 1 < 2, 1 < 3, 2 < 3
//			return -1;
//		} else if (sevCode1.charAt(0) > sevCode2.charAt(0)) { // 2 > 1, 3 > 2, 3 > 1
//			return 1;
//		} else if (sevCode1.length() < sevCode2.length()){ // 2 < 2b
//			return -1;
//		} else if (sevCode1.length() > sevCode2.length()){ // 2b > 2
//			return 1;
//		} else {
//			//check rest
//			return 0;
//		}

		String sevCode1 = fSevCode;
		String sevCode2 = j.getSevCode();
		int length1 = sevCode1.length();
		int length2 = sevCode2.length();
		int value = 0;
		int i = 0;
		int k = 0;
		while (i < length1 && k < length2) {
			char c1 = sevCode1.charAt(i);
			char c2 = sevCode2.charAt(k);
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
			} else if (length1 > length2){
				value = 1;
				return value;
			}
			else if (length1 == length2) {
				if (fFatalities < j.getFatalities())
					return -1;
				else if (j.getFatalities() < fFatalities)
					return 1;
				else if (fFatalities == j.getFatalities()) {
					if (fSInjuries < j.getSInjuries())
						return -1;
					else if (fSInjuries > j.getInjuries())
						return 1;
					if (fSInjuries == j.getInjuries()) {
						if (fInjuries < j.getInjuries())
							return -1;
						else if (fInjuries >= j.getInjuries())
							return 1;
					}
				}
					
			}
		}
		// Else return value
		return value;
	}
}
