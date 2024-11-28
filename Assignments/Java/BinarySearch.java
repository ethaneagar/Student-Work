// simple example of a binary search within an array

import java.util.Scanner;

// Function Description:
// - performs binary search through an array
// - start in the middle, only search first half or second half of array 
// - use for large, sorted arrays
// Arguments:
// - searchArray - integer array to search through
// - searchFor - integer value to search for
// Return Value:
// - When match is found, index is returned, otherwise -1 is returned
public static int binarySearch(int[] searchArray, int searchFor) {
	int low = 0;						
	int high = searchArray.length - 1;			
	
	// while index is below highest value of array
	while (high >= low) {
		int middle = (low + high)/2;
		if (searchFor < searchArray[middle]) {
			// start moving down
			high = middle - 1;
		}							
		else if (searchFor == searchArray[middle]) {
			// found
			return middle;
		}
		else {
		  	// start moving up
		   	low = middle + 1;
		}
	} // end while
	
	// otherwise not found
	return -1;  	
} 
		
// main entry point
public static void main(String[] args) {
	// init vars
	Scanner userInput = new Scanner(System.in);
	int[] arrayToCheck = new int[100];
	
	// get user input
	System.out.println("Enter values to search for (binary) between 0 and 99: ");
	int userValue = userInput.nextInt();
	
	// populate array with random values
	for (int i = 0; i < arrayToCheck.length; i++) {
		arrayToCheck[i] = (int)(Math.random() * 100);
	} // end of for
	
	// perform binary search
	int foundResult = binarySearch(arrayToCheck, userValue);
	
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
