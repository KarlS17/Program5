/*
* File name: Lot.java
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

import java.text.DecimalFormat;

/**
 * Lot class 
 * @author Karl-Eric Schmitt
 *
 */
public class Lot
{
	DecimalFormat decimal = new DecimalFormat(".##");
	final int ftToAcres = 43560;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private int lotSizeSqFt;
	
	/**
	 * Basic Constructor
	 */
	public Lot()
	{
		super();
	}

	/**
	 * Fancy constructor
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param lotSizeSqFt
	 */
	public Lot(String street, String city, String state, String zipcode,
			int lotSizeSqFt)
	{
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.lotSizeSqFt = lotSizeSqFt;
	}
	
	/**
	 * @return the street
	 */
	public String getStreet()
	{
		return street;
	}
	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode()
	{
		return zipcode;
	}
	/**
	 * @return the lotSizeSqFt
	 */
	public int getLotSizeSqFt()
	{
		return lotSizeSqFt;
	}
	/**
	 * @return the ftToAcres
	 */
	public int getFtToAcres()
	{
		return ftToAcres;
	}

	/**
	 * To string that returns the Street,City,State,Zip and converts feet to acres
	 * @return str
	 */
	public String toString() {
		String str = "Street: " + street +"\nCity/State/Zip: " + city+", " + state +" " + zipcode+"\nAcreage: " + decimal.format(((double)lotSizeSqFt/(double)ftToAcres));
		return str;
	}
}
