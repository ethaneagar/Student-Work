using System;

namespace Sorting
{
    internal class BubbleSort
    {
        // Function Description:
        // - performs bubble sort on an array
        // - smallest values bubble to the top, largest values sink to the bottom
        // Arguments:
        // - unsortedArray - integer array to sort
        // Return Value:
        // - array passed by reference
        static void bubbleSort(int[] unsortedArray)
        {
            // outer loop controlling the number of sort passes
            for (int arrayItem = 0; arrayItem < unsortedArray.Length; arrayItem++)
            {
                // inner loop controlling the number of comparisons 
                for (int compareItem = 0; compareItem < unsortedArray.Length - 1 - arrayItem; compareItem++)
                {
                    // swap if out of order
                    if (unsortedArray[compareItem] > unsortedArray[compareItem + 1])
                    {
                        int swapItem = unsortedArray[compareItem + 1];
                        unsortedArray[compareItem + 1] = unsortedArray[compareItem];
                        unsortedArray[compareItem] = swapItem;
                    } // end if out of order
                } // end for each comparison
            } // end for each array item
        } // bubble sort

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

            // perform bubble sort
            bubbleSort(arrayToSort);

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
