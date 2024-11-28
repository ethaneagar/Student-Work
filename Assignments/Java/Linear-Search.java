# simple example of a Linear Search from a random array

import java.util.Scanner;

// function: Linear Search
public static int LinearSearch(int[] haystack, int needle)
{
	for (int i = 0; i < haystack.length; i++)
	{
		// if found
		if (needle == haystack[i]) 
		{
	      		return i;
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
	  System.out.println("Enter values to search for between 0 and 99: ");
	  int userValue = userInput.nextInt();
	  
	  // populate array with random values
	  for (int i = 0; i < arrayToCheck.length; i++) 
	  {
		  arrayToCheck[i] = (int)(Math.random() * 100);
	  } // end of for
	
	  // perform LinearSearch
	  int foundResult = LinearSearch(arrayToCheck, userValue);

	  // display results
	  if (foundResult != -1) 
	  {
		System.out.println(userValue + " was found at location " + foundResult);
	  }
	  else
	  {
		System.out.println(userValue + " was not found in the array");			
	  }

  	// cleanup
	userInput.close();
}
