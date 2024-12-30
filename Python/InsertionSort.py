# simple example of an insertion sort on an array
import numpy

# Function Description:
# - performs insertion sort on an array
# - builds the sorted array one item at a time by inserting elements
# Arguments:
# - unsortedArray - integer array to sort
# Return Value:
# - array passed by reference
def insertion_sort(unsorted_array):
    # for each item in the array
    for outer_pass in range(1, len(unsorted_array)):
        # get current element
        current_element = unsorted_array[outer_pass]
        # the position of the division of unsorted vs sorted
        insertion = outer_pass - 1

        # while value of insertion is > current_element
        while (insertion >= 0) and (current_element < unsorted_array[insertion]):
            # move insertion to the right
            unsorted_array[insertion + 1] = unsorted_array[insertion]
            # move backward through the list to check the next insertion
            insertion -= 1

        # insert currentItem to the right
        unsorted_array[insertion + 1] = current_element

# test function / main entry point

# populate array with random values
array_to_sort = numpy.random.randint(0, 100, size=20)

print("Array prior to sort: ")
print(array_to_sort)

insertion_sort(array_to_sort)

print("Array after sort: ")
print(array_to_sort)
