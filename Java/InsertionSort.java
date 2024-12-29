// simple example of an insertion sort

import java.util.Arrays;

public class InsertionSort {

	// Function Description:
	// - performs insertion sort on an array
	// - builds the sorted array one item at a time by inserting elements
	// - Note: I prefer not having to use a break from approach in the while loop
	// Arguments:
	// - unsortedArray - integer array to sort
	// Return Value:
	// - array passed by reference
	static void insertionSort(int[] unsortedArray) {
		// outer loop controlling the number of sort passes
		for (int arrayItem = 1; arrayItem < unsortedArray.length; arrayItem++) {
			// get current element
			int currentItem = unsortedArray[arrayItem];
			// the position of the division of unsorted vs sorted
			int insertItem = arrayItem - 1;

			// while value of insertItem is > currentItem
			while ((insertItem >= 0 && unsortedArray[insertItem] > currentItem)) {
				// move insertItem to the right
				unsortedArray[insertItem + 1] = unsortedArray[insertItem];
				// move backward through the list to check the next insertion
				--insertItem;
			}
			// insert currentItem to the right
			unsortedArray[insertItem + 1] = currentItem;
		} // for each arrayItem
	} // insertion sort

	// main entry point
	public static void main(String[] args) {
		int[] arrayToSort = new int[20];
		
		// populate array with random values
		for (int i = 0; i < arrayToSort.length; i++) 
		{
			arrayToSort[i] = (int)(Math.random() * 100);
		} // end of for	
			
	   	System.out.println("Array prior to sort: ");	
	   	System.out.println(Arrays.toString(arrayToSort));

	   	// perform insertion sort
	   	insertionSort(arrayToSort);		
										
		System.out.println();				
		System.out.println("Array after sort: ");
		System.out.println(Arrays.toString(arrayToSort));
	} // main	
