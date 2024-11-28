# simple example of a Binary Search within an array of random numbers

	public static int binarySearch(int[] haystack, int needle) 
	{

		   int low = 0;						
		   int high = haystack.length - 1;			
		   
		   // while index is below highest value of array 'haystack'
		   while (high >= low) 
		   {
			   int middle = (low + high)/2;
			   if (needle < haystack[middle]) 
			   {
				   // start moving down
				   high = middle - 1;
			   }							
			   else if (needle == haystack[middle]) 
			   {
				   return middle;
			   }
			   else 
			   {
				   // start moving up
				   low = middle + 1;
			   }

		   } // end while
			
		   // otherwise not found
		   return -1;  	
	} 
					
	
	
	// main entry point
	public static void main(String[] args) 
	{
	  // init vars
	  Scanner userInput = new Scanner(System.in);
	  int[] arrayToCheck = new int[100];

	  // get user input
	  System.out.println("Enter values to search for (binary) between 0 and 99: ");
	  int userValue = userInput.nextInt();
	  
	  // populate array with random values
	  for (int i = 0; i < arrayToCheck.length; i++) 
	  {
	    arrayToCheck[i] = (int)(Math.random() * 100);
	  } // end of for

	  // perform BinarySearch
	  int foundResult = binarySearch(arrayToCheck, userValue);

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
	
