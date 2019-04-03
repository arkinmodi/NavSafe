
public class Street {
	private String fName;		//Street Name
	private String fStreetEnd1;	//One end of the street
	private String fStreetEnd2;	//One end of the street
	
	
	/**
	 * Constructor for an street
	 * 
	 * @param splitRead - array of streets data from read module
	 */
	public Street(String[] splitRead) {
		this.fName = splitRead[4];
		this.fStreetEnd1 = splitRead[5];
		this.fStreetEnd2 = splitRead[6];
	}
	
	/**
	 * Gets name of street
	 * 
	 * @return fName - name of street
	 */
	public String getName() {
		return fName;
	}
	
	/**
	 * Gets end 1 of street
	 * 
	 * @return fStreetEnd1 - one end of street
	 */
	public String getEnd1() {
		return fStreetEnd1;
	}

	/**
	 * Gets end 2 of street
	 * 
	 * @return fStreetEnd2 - one end of street
	 */
	public String getEnd2() {
		return fStreetEnd2;
	}

}
