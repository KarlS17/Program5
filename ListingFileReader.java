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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads Real Estate Listing data from a file into an array of Listing objects.
 *
 * @author Tracy S. Milam
 *
 */
public class ListingFileReader
{
	private String[] columns;
	
	/**
	 * Reads the lines from the inventory.txt file
	 * parses them and creates objects
	 * 
	 * @param inventory
	 * @return size
	 */
	public int readInventory(Listing[] inventory)
	{
		final String FILENAME = "listings.txt";
		int size = 0;
		int rowNum = 1;
		String[] record;
		
		Scanner input = null;
		try
		{
			input = new Scanner(new File(FILENAME));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to open file " + FILENAME + ".");
			return 0;
		}

		// Variables for Listing object
		String propertyId = "";
		double price = 0.0;
		
		// Variables for Lot object
		String street = "";
		String city = "";
		String state = "";
		String zipcode = "";
		int lotSizeSqFt = 0;
		
		// Variables for House object
		String architecture = "";
		String exteriorMaterial = "";
		int finishedSqFt = 0;
		int numRooms = 0;
		int bedrooms = 0;
		double bathrooms = 0.0;
		String parkingType = "";
		int coveredParkingSpaces = 0;
		int yearBuilt = 0; 
		
		while (input.hasNext() && size < inventory.length)
		{
			// Capture column headers for looks 
			// (Note:  assumes input file has a header row)
			if (rowNum == 1)
			{
				columns = input.nextLine().split("\t");
			}
			
			// read next row of data from file
			record = input.nextLine().split("\t");
			
			// parse row into data elements
			propertyId = readString(record, "zpid");		
			price = readDouble(record, "price");		
			street = readString(record, "street");
			city = readString(record, "city");
			state = readString(record, "state");
			zipcode = readString(record, "zipcode");
			lotSizeSqFt = readInt(record, "lotSizeSqFt");
			architecture = readString(record, "architecture");
			exteriorMaterial = readString(record, "exteriorMaterial");
			finishedSqFt = readInt(record, "finishedSqFt");
			numRooms = readInt(record, "numRooms");
			bedrooms = readInt(record, "bedrooms");
			bathrooms = readDouble(record, "bathrooms");
			parkingType = readString(record, "parkingType");
			coveredParkingSpaces = readInt(record, "coveredParkingSpaces");
			yearBuilt = readInt(record, "yearBuilt", 1900); 
			/*
			 *  Start Here
			 *    Instatiation of Listing object - with aggregation
			 *    hint:  includes Lot and House classes
			 */
			House house = new House(architecture,exteriorMaterial,finishedSqFt,numRooms,bedrooms,bathrooms,parkingType,coveredParkingSpaces,yearBuilt);
			Lot lot = new Lot(street, city,  state, zipcode,lotSizeSqFt);
			//Listing realListings = new Listing(propertyId,price,lot,house);What i created, testing what was provided
			Listing tempListing = new Listing(propertyId,price,lot,house);
			/*
			 *  End Here
			 */
			
			inventory[size] = tempListing;
			size++;
			rowNum++;
		} // end of while loop

		input.close();
		
		return size;
	}

	private int findColumnIndex(String columnName)
	{
		if (columns != null)
			for(int i=0; i < columns.length; i++)
				if (columns[i].equals(columnName))
					return i;
		return -1;
	}
	
	private int readInt(String[] record, String columnName)
	{
		return readInt(record, columnName, 0);
	}

	private int readInt(String[] record, String columnName, 
			int defaultValue)
	{
		int index = findColumnIndex(columnName);
		if ( (record != null) && (index >= 0) 
				&& (record.length >= index + 1) && !("".equals(record[index])))
			return Integer.parseInt(record[index]);
		else
			return defaultValue;
	}

	private double readDouble(String[] record, String columnName)
	{
		return readDouble(record, columnName, 0.0);
	}

	private double readDouble(String[] record, String columnName, 
			double defaultValue)
	{
		int index = findColumnIndex(columnName);
		if ( (record != null) && (index >= 0) 
				&& (record.length >= index + 1) && !("".equals(record[index])))
			return Double.parseDouble(record[index]);
		else
			return defaultValue;
	}

	private String readString(String[] record, String columnName)
	{
		return readString(record, columnName, "");
	}

	private String readString(String[] record, String columnName, 
			String defaultValue)
	{
		int index = findColumnIndex(columnName);
		if ( (record != null) && (index >= 0) 
				&& (record.length >= index + 1) && !("".equals(record[index])) )
			return record[index];
		else
			return defaultValue;
	}
}
