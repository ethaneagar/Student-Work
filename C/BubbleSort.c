// simple example of a bubble sort on an array

#include <stdio.h>

// Function Description:
	// - performs bubble sort on an array
	// - smallest values bubble to the top, largest values sink to the bottom
	// Arguments:
	// - unsortedArray - integer array to sort
	// - unsortedSize - size_t length of the array
	// Return Value:
	// - array passed by reference
static void bubbleSort(int *unsortedArray, size_t unsortedSize) {

	// outer loop controlling the number of sort passes
	for (int arrayItem = 1; arrayItem < unsortedSize; arrayItem++) {
		// inner loop controlling the number of comparisons 
		for (int compareItem = 0; compareItem < unsortedSize - 1; compareItem++) {
			// swap if out of order
			if (unsortedArray[compareItem] > unsortedArray[compareItem + 1]) {
				int swapItem = unsortedArray[compareItem];
				unsortedArray[compareItem] = unsortedArray[compareItem + 1];
				unsortedArray[compareItem + 1] = swapItem;
			} // end if out of order
		} // end for each comparison
	} // end for each array item
} // bubble sort

// main entry point
int main() {
	int arrayToSort[20];
	int arraySize = sizeof(arrayToSort) / sizeof(arrayToSort[0]);
	srand(time(NULL));


	// populate array with random values
	for (int index = 0; index < arraySize; index++)
	{
		arrayToSort[index] = rand() % 100;
	} // end of for	

	printf("Array prior to sort: \n");
	for (int index = 0; index < arraySize; index++)
	{
		printf("%d%s", arrayToSort[index], " ");
	}

	// perform bubble sort
	bubbleSort(&arrayToSort, (sizeof(arrayToSort)/sizeof(*arrayToSort)));

	printf("\n\nArray after sort: \n");
	for (int index = 0; index < arraySize; index++)
	{
		printf("%d%s", arrayToSort[index], " ");
	}

	printf("\n");
} // main
