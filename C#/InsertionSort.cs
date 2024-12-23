using System;

namespace Sorting
{
    internal class InsertionSort
    {
        // Function Description:
        // - performs insertion sort on an array
        // - builds the sorted array one item at a time by inserting elements
        // - Note: I prefer not having to use a break from approach in the while loop
        // Arguments:
        // - unsortedArray - integer array to sort
        // Return Value:
        // - array passed by reference
        public static void insertionSort(int[] unsortedArray)
        {
            // outer loop controlling the number of sort passes
            for (int arrayItem = 1; arrayItem < unsortedArray.Length; ++arrayItem)
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
        static void Main(string[] args)
        {
            int[] arrayToSort = new int[20];

            // populate array with random values
            Random randNum = new Random();
            for (int index = 0; index < arrayToSort.Length; index++)
            {
                arrayToSort[index] = randNum.Next(0, 100);
            } // end of for	

            Console.WriteLine("\nArray prior to sort: ");
            foreach (var item in arrayToSort)
            {
                Console.Write(item.ToString() + " ");
            }

            // perform insertion sort
            insertionSort(arrayToSort);

            Console.WriteLine("\n\nArray after sort: ");
            foreach (var item in arrayToSort)
            {
                Console.Write(item.ToString() + " ");
            }

            // prevent fast closure / pending keystroke closure
            Console.ReadKey();

        }
    }
}
