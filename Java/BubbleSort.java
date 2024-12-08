// simple example of a bubble sort on an array

import java.util.Scanner;

public class BubbleSort {

	// Function Description:
	// - performs bubble sort on an array
	// - smallest values bubble to the top, largest values sink to the bottom
	// Arguments:
	// - unsortedArray - integer array to sort
	// Return Value:
	// - array passed by reference
	public static void bubbleSort(int[] unsortedArray) {
		// outer loop controlling the number of sort passes
		for (int arrayItem = 1; arrayItem < unsortedArray.length; arrayItem++) {
			// inner loop controlling the number of comparisons 
			for (int compareItem = 0; compareItem < unsortedArray.length - arrayItem; compareItem++) { 	
				// swap if out of order
				if (unsortedArray[compareItem] > unsortedArray[compareItem+1]) {
		                       int swapItem = unsortedArray[compareItem];
		                       unsortedArray[compareItem] = unsortedArray[compareItem+1];
		                       unsortedArray[compareItem+1] = swapItem;
	                  	} // end if out of order
	            	} // end for each comparison
		} // end for each array item
	} // bubble sort
	
	// main entry point
	public static void main(String[] args) {
		int[] arrayToSort = new int[20];
	      
		// populate array with random values
		for (int index = 0; index < arrayToSort.length; index++) 
		{
			arrayToSort[index] = (int)(Math.random() * 100);
		} // end of for	
	        
		System.out.println("Array prior to sort: ");	
		System.out.println(Arrays.toString(arrayToSort));
		
		// perform bubble sort
		bubbleSort(arrayToSort);		
			      
		System.out.println();				
		System.out.println("Array after sort: ");
		System.out.println(Arrays.toString(arrayToSort));
	} // main
}
