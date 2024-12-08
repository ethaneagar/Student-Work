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
		for (int pass = 1; pass < unsortedArray.length; pass++) {
			// inner loop controlling the number of comparisons 
			for (int comparisons = 0; comparisons < unsortedArray.length - pass; comparisons++) { 	
				// swap if out of order
				if (unsortedArray[comparisons] > unsortedArray[comparisons+1]) {
		                       int swapItem = unsortedArray[comparisons];
		                       unsortedArray[comparisons] = unsortedArray[comparisons+1];
		                       unsortedArray[comparisons+1] = swapItem;
	                  	} // end if out of order
	            	} // for each comparison
		} // for each pass
	} 
	
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
		
		// perform bubble sort
		bubbleSort(arrayToSort);		
			      
		System.out.println();				
		System.out.println("Array after sort: ");
		System.out.println(Arrays.toString(arrayToSort));
	} // main
}
