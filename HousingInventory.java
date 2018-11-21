/*
* File name:  HousingInventory.java
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

import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents an inventory of real estate listings and the operations
 * to view, sort, and search the inventory.
 *
 * @author Karl Schmitt
 *
 */
public class HousingInventory
{
	Scanner keyboard = new Scanner(System.in);
	private final static int ARRAY_SIZE = 100;
	private Listing[] inventory;
	private int size;
	
	/**
	 * Constructor - creates and empty inventory array of default size
	 */
	public HousingInventory()
	{
		this.inventory = new Listing[ARRAY_SIZE];
	}
	
	/**
	 * Constructor - creates an inventory array from an input file
	 * 
	 * @param fileInput A formated file of real estate listings
	 */
	public HousingInventory(ListingFileReader fileInput)
	{
		this();
	 	this.size = fileInput.readInventory(this.inventory);
	}
	
	/**
	 * @return The count of Listings that are in the housing inventory
	 */
	public int getCount()
	{
		return this.size;
	}
	
	/**
	 * Unsorted list of house from housing inventory User created, needs to be fixed
	 */
	public void getInventory() {
		System.out.println("Entire housing inventory:\n");
		
		System.out.println("Property ID\tPrice\t\tYear\tBeds\tBaths\tSqFt\tAcres");
		System.out.println("-----------\t--------\t----\t----\t-----\t----\t-----");
		int i = 0; 
		boolean isValid = false;
		while(isValid != true) {
			System.out.println(inventory[i].toString());
		i++;
		if(i==32) {
			isValid = true;
		}
		}	
	}
	/**
	 * Gets the housing inventory by year sorted
	 */	
	public void getInventorySortedByYear() {
		System.out.println("Entire inventory sorted by year:\n");
		System.out.println("Property ID\tPrice\t\tYear\tBeds\tBaths\tSqFt\tAcres");
		System.out.println("-----------\t--------\t----\t----\t-----\t----\t-----");
		Listing[] yearListing = new Listing[32]; //New array with 32 Elements
		yearListing = Arrays.copyOf(inventory, 32-1); //Copies inventory array into another array so we can sort it properly
		
		Listing temp;
		int max;
		
		for(int i =0;i<yearListing.length-1;i++) {
			max = indexOfLargestElement(yearListing,yearListing.length-i);
			temp = yearListing[max];
			yearListing[max]=yearListing[yearListing.length-i-1];
			yearListing[yearListing.length-i-1] = temp;
		}	
		int i = 0; 
		boolean isValid = false;
		while(isValid != true) {
		System.out.println(yearListing[i].toString());
		i++;
		if(i==31) {
			isValid = true;
		}
		}
	}
	/**
	 * Gets the housing inventory by number of bedrooms
	 */
	public void getInventoryByBedrooms(int minBedrooms) {
		System.out.println("Homes with 4 or more bedrooms:");
		System.out.println("Property ID\tPrice\t\tYear\tBeds\tBaths\tSqFt\tAcres");
		System.out.println("-----------\t--------\t----\t----\t-----\t----\t-----");	
		int inventoryCount =0;
		int houseWithRooms =0;
		
		for(int i =0;i<inventory.length-68;i++) {
			if(inventory[i].getHouse().getBedrooms()>= minBedrooms) {
				houseWithRooms++;
			}
		}
		Listing[] homesWithBedrooms = new Listing[houseWithRooms];
		int houseWithRoomsCount=0;
		for(int i1 =0;i1<inventory.length-68;i1++) {
			if(inventory[i1].getHouse().getBedrooms()>=minBedrooms) {
				homesWithBedrooms[houseWithRoomsCount] = inventory[i1];
				houseWithRoomsCount++;
			}
		}	
		for(int i=0;i<=houseWithRooms-1;i++) {
			System.out.println(homesWithBedrooms[i].toString());
		}
	}
	/**
	 * Looks for homes that are maxPrice or below
	 * @param maxPrice
	 */
	public void getInventoryByPrice(double maxPrice) { 
		int inventoryCount = 0;
		int homesMaxPrice=0;
		System.out.println("Homes listed at $150k and below:");
		System.out.println("Property ID\tPrice\t\tYear\tBeds\tBaths\tSqFt\tAcres");
		System.out.println("-----------\t--------\t----\t----\t-----\t----\t-----");
		
		for(int i =0;i<inventory.length-68;i++) {
			if(inventory[i].getPrice()<= maxPrice) {
				homesMaxPrice++;
			}
		}
		Listing[] homesUnderPrice = new Listing[homesMaxPrice];
		int priceCount=0;
		for(int i1 =0;i1<inventory.length-68;i1++) {
			if(inventory[i1].getPrice()<=maxPrice) {
				homesUnderPrice[priceCount] = inventory[i1];
				priceCount++;
			}
		}
		for(int i=0;i<=homesMaxPrice-1;i++) {
			System.out.println(homesUnderPrice[i].toString());
		}
	}
	/**
	 * Gets the housing inventory by lot size
	 */
	public void getInventoryByLotSize(double minAcreage) { //This method does not work correctly, please check
		int homesWithMinAcreage = 0;
		System.out.println("\nProperties with >= 0.25 acres");
		System.out.println("------------------------------");
		for(int i =0;i<inventory.length-68;i++) {
			if(((double)inventory[i].getLot().getLotSizeSqFt()/(double)inventory[i].getLot().getFtToAcres())>= minAcreage) {
				homesWithMinAcreage++;
			}
		}
		Listing[] homesWithMinAcreageArray = new Listing[homesWithMinAcreage];
		int acreCount = 0;
		for(int i1 =0;i1<32;i1++) {
			if(((double)inventory[i1].getLot().getLotSizeSqFt()/(double)inventory[i1].getLot().getFtToAcres())>=minAcreage) {
				homesWithMinAcreageArray[acreCount] = inventory[i1];
				acreCount++;
			}
		}
		for(int i=0;i<=acreCount-1;i++) {
			System.out.println(homesWithMinAcreageArray[i].getLot().toString()+"\n"); //Please check before turning in, probabily isnt working
		}
	}
	/**
	 * Gets the listing based off user inputed property ID
	 * 
	 */
	public void getListing(String input) {
		boolean isValid = false;
		boolean good = false;
		int i=0;
		while(isValid != true) {
			if(inventory[i].getPropertyId().contentEquals(input)) {
				good = true;
				isValid = true;
			}
			if(good==true) {
				System.out.println("Property ID\tPrice\t\tYear\tBeds\tBaths\tSqFt\tAcres");
				System.out.println("-----------\t--------\t----\t----\t-----\t----\t-----");
				System.out.println(inventory[i].toString());
			}
			i++;
			if(i==32) {
				isValid = true;
				System.out.println("\nProperty Not Found");
			}
		}	
			}
	/**
	 * Method used to find the largest element in an array, found in textbook
	 * @param array
	 * @param size
	 * @return index
	 */
	public static int indexOfLargestElement(Listing[] array, int size) {
		int index = 0;
		for(int i=1;i<size;i++) {
			if(array[i].getHouse().getYearBuilt()>array[index].getHouse().getYearBuilt()) {
				index = i;
			}
		}
		return index;
	}
	}