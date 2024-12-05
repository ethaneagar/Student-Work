// simple example of a linear search through an array

import java.util.Scanner;

public class LinearSearch {

	// Function Description:
	// - performs linear search through an array
	// - start at the beginning and search one index at a time 
	// - use for unsorted arrays, hopefully small arrays
	// Arguments:
	// - searchArray - integer array to search through
	// - searchFor - integer value to search for
	// Return Value:
	// - When match is found, index is returned, otherwise -1 is returned
	public static int linearSearch(int[] searchArray, int searchFor) {
		for (int index = 0; index < searchArray.length; index++) {
			// if found
			if (searchFor == searchArray[index]) {
		      		return index;
		    	} // end if
		} // end for
		// otherwise
	  	return -1;
	} // end function
	
	// main entry point
	static void main(String[] args) 
	{
		  // init vars
		  Scanner userInput = new Scanner(System.in);
		  int[] arrayToCheck = new int[100];
		
		  // get user input
		  System.out.println("Enter values to search for (linear) between 0 and 99: ");
		  int userValue = userInput.nextInt();
		  
		  // populate array with random values
		  for (int i = 0; i < arrayToCheck.length; i++) {
			  arrayToCheck[i] = (int)(Math.random() * 100);
		  } // end of for
		
		  // perform linear search
		  int foundResult = linearSearch(arrayToCheck, userValue);
	
		  // display results
		  if (foundResult != -1) {
			System.out.println(userValue + " was found at location " + foundResult);
		  }
		  else {
			System.out.println(userValue + " was not found in the array");			
		  }
	
	  	// cleanup
		userInput.close();
	}
}
