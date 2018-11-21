/*
* File name: House.java
*
* Programmer: Karl Schmitt
* ULID: keschm1
*
* Date: Nov 8, 2018
*
* Class: IT 168
* Lecture Section: 19
* Lecture Instructor: Dr. Karen Johnson
* Lab Section: 21
* Lab Instructor: Kumar Rakholia
*/
package edu.ilstu;

/**
 * House class ELIMINATE SETTERS
 * @author Karl-Eric Schmitt
 *
 */
public class House
{
	private String architecture;
	private String exteriorMaterial;
	private int finishedSqFt;
	private int numRooms;
	private int bedrooms;
	private double bathrooms;
	private String parkingType;
	private int coveredParkingSpaces;
	private int yearBuilt;
	
	/**
	 * Basic Constructor
	 */
	public House()
	{
		super();
	}
	/**
	 * @param architecture
	 * @param exteriorMaterial
	 * @param finishedSqFt
	 * @param numRooms
	 * @param bedrooms
	 * @param bathrooms
	 * @param parkingType
	 * @param coveredParkingSpaces
	 * @param yearBuilt
	 */
	public House(String architecture, String exteriorMaterial, int finishedSqFt,
			int numRooms, int bedrooms, double bathrooms, String parkingType,
			int coveredParkingSpaces, int yearBuilt)
	{
		super();
		this.architecture = architecture;
		this.exteriorMaterial = exteriorMaterial;
		this.finishedSqFt = finishedSqFt;
		this.numRooms = numRooms;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.parkingType = parkingType;
		this.coveredParkingSpaces = coveredParkingSpaces;
		this.yearBuilt = yearBuilt;
	}

	/**
	 * @return the architecture
	 */
	public String getArchitecture()
	{
		return architecture;
	}
	/**
	 * @return the exteriorMaterial
	 */
	public String getExteriorMaterial()
	{
		return exteriorMaterial;
	}
	/**
	 * @return the finishedSqFt
	 */
	public int getFinishedSqFt()
	{
		return finishedSqFt;
	}
	/**
	 * @return the numRooms
	 */
	public int getNumRooms()
	{
		return numRooms;
	}
	/**
	 * @return the bedrooms
	 */
	public int getBedrooms()
	{
		return bedrooms;
	}
	/**
	 * @return the bathrooms
	 */
	public double getBathrooms()
	{
		return bathrooms;
	}
	/**
	 * @return the parkingType
	 */
	public String getParkingType()
	{
		return parkingType;
	}
	/**
	 * @return the coveredParkingSpaces
	 */
	public int getCoveredParkingSpaces()
	{
		return coveredParkingSpaces;
	}
	/**
	 * @return the yearBuilt
	 */
	public int getYearBuilt()
	{
		return yearBuilt;
	}

}
