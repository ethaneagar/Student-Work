# simple example of a bubble sort on an array
import numpy

# Function Description:
# - performs bubble sort on an array
# - smallest values bubble to the top, largest values sink to the bottom
# Arguments:
# - unsorted_array - integer array to sort
# Return Value:
# - array passed by reference
def bubble_sort(unsorted_array):
    # for each item in the array
    for outer_pass in range(len(unsorted_array) - 1, 0, -1):
        # for each comparison
        for comparisons in range(outer_pass):
            # swap if out of order
            if unsorted_array[comparisons] > unsorted_array[comparisons + 1]:
                swap = unsorted_array[comparisons]
                unsorted_array[comparisons] = unsorted_array[comparisons + 1]
                unsorted_array[comparisons + 1] = swap

# test function / main entry point

# populate array with random values
array_to_sort = numpy.random.randint(0, 100, size=20)

print("Array prior to sort: ")
print(array_to_sort)

bubble_sort(array_to_sort)

print("Array after sort: ")
print(array_to_sort)
