/*
* File name: HouseFinderApp.java
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

import java.util.Scanner;

/**
 * Driver class to display menu, process user input and display responses.
 *
 * @author Karl Schmitt
 *
 */
public class HouseFinderApp
{
	public static void main(String[] args)
	{
		// Load input file into HousingInventory
		HousingInventory homes = new HousingInventory(new ListingFileReader());

		// For initial setup testing purposes only
		// Remove once you're ready to begin coding
		// vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
//		if (homes != null && homes.getCount() > 0)
//			System.out.println("SUCCESS:  " + homes.getCount() + " records read from file.");
//		else
//			System.out.println("FAILURE:  0 records read from file.");
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		/*
		 * 	START CODING HERE
		 * 
		 * 	- Display Menu - Done
		 * 	- Process User Input - Done
		 * 	- etc
		 * 
		 */
		Scanner keyboard = new Scanner(System.in);
		boolean isValid = false;
		while(isValid !=true) {
		System.out.println("Welcome to your local FSBO - Lets find your next home\n");
		System.out.println("(1) Display the entire housing inventory");
		System.out.println("(2) Display the entire housing inventory - sorted by year built");
		System.out.println("(3) Display homes with 4 or more bedrooms");
		System.out.println("(4) Display homes listed at $150k and below");
		System.out.println("(5) Output a list of properties with >= 0.25 acres");
		System.out.println("(6) Find home by property id");
		System.out.println("(7) Quit\n");
		System.out.print("Enter your choice (1-7): ");
	
		switch(keyboard.next()) {
		case "1":
			homes.getInventory();
			System.out.println("\n");
			break;
		case "2":
			homes.getInventorySortedByYear();
			System.out.println("\n");
			break;
		case "3":
			homes.getInventoryByBedrooms(4);
			System.out.println("\n");
			break;
		case "4":
			homes.getInventoryByPrice(150000);
			System.out.println("\n");
			break;
		case "5":
			homes.getInventoryByLotSize(.25);
			System.out.println("\n");
			break;
		case "6":
			System.out.print("Please enter property id: ");
			String input = keyboard.next();
			homes.getListing(input);
			System.out.println("\n");
			break;
		case "7":
			System.out.println("Quitting application.");
			System.exit(1);
			isValid = true;
			break;
		default:
			System.out.println();
			System.out.println("Invalid Choice, please try again\n");
		}
		}
		keyboard.close();
	}
	
}
