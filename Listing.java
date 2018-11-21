/*
* File name:  Listing.java
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
 * Represents a Real Estate Listing
 *
 * @author Karl Schmitt
 *
 */
public class Listing
{
	private String propertyId;
	private double price;
	private Lot lot;
	private House house;
	DecimalFormat prices = new DecimalFormat("$000,000");
	DecimalFormat twoPlaces = new DecimalFormat("#.00");
	

	/**
	 * Constructor for listing class that contains 4 parameters, help from Prof
	 * @param propertyId
	 */
	public Listing(String propertyId) 
	{
		super();
		this.propertyId = propertyId;
	}

	/**
	 * Constructor for listing class that contains 4 parameters,help from Prof
	 * @param propertyId
	 * @param price
	 * @param lot
	 * @param house
	 */
	public Listing(String propertyId, double price, Lot lot, House house) //Not sure yet
	{
		super();
		this.propertyId = propertyId;
		this.price = price;
		this.lot = lot;
		this.house = house;
	}

	/**
	 * @return the propertyId
	 */
	public String getPropertyId()
	{
		return propertyId;
	}

	/**
	 * Gets the price
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * Gets the lot
	 * @return the lot
	 */
	public Lot getLot()
	{
		return lot;
	}

	/**
	 * Gets the house
	 * @return the house
	 */
	public House getHouse()
	{
		return house;
	}
	/**
	 * ToString Method for Listing class
	 * @return str
	 */
	public String toString() {
		double acres = ((double)lot.getLotSizeSqFt()/(double)lot.getFtToAcres());
		String str =  propertyId + "\t" + prices.format(price) + "\t" + house.getYearBuilt() +
				"\t" + house.getBedrooms() +"\t"+ (int)house.getBathrooms() +"\t" + house.getFinishedSqFt()+"\t" + twoPlaces.format(acres);
		return str;
	}
	/**
	 * Needs to be tested
	 * @param listing
	 * @return
	 */
	public boolean equals(Listing listing) {
		boolean isValid = false;
		String ID = listing.getPropertyId();
		if(propertyId.equals(ID)) 
			isValid = true;
		return isValid;
	}

	
	
	
	

	
}
