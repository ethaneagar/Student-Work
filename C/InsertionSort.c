// simple example of an insertion sort on an array

#include <stdio.h>

// Function Description:
// - performs insertion sort on an array
// - builds the sorted array one item at a time by inserting elements
// - Note: I prefer not having to use a break from approach in the while loop
// Arguments:
// - unsortedArray - integer array to sort
// - unsortedSize - size_t length of the array
// Return Value:
// - array passed by reference
static void insertionSort(int *unsortedArray, size_t unsortedSize)
{
	// outer loop controlling the number of sort passes
	for (int arrayItem = 1; arrayItem < unsortedSize; ++arrayItem)
	{
		// get current element
		int currentItem = unsortedArray[arrayItem];
		// the position of the division of unsorted vs sorted
		int insertItem = arrayItem - 1;

		// while value of insertItem is > currentItem
		while ((insertItem >= 0 && unsortedArray[insertItem] > currentItem))
		{
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

	// perform insertion sort
	insertionSort(&arrayToSort, (sizeof(arrayToSort) / sizeof(*arrayToSort)));

	printf("\n\nArray after sort: \n");
	for (int index = 0; index < arraySize; index++)
	{
		printf("%d%s", arrayToSort[index], " ");
	}

	printf("\n");
} // main
