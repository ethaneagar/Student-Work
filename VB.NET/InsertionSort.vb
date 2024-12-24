' simple example of an insertion sort on an array

Imports System

Module Program

    ' Function Description
    ' - performs insertion sort on an array
    ' - builds the sorted array one item at a time by inserting elements
    ' Arguments:
    ' - unsortedArray - integer array to sort
    ' Return Value:
    ' - array passed by reference
    Public Function InsertionSort(ByRef unsortedArray As Integer())
        Dim arrItem, currentItem, insertItem As Integer
        ' outer loop controlling the number of sort passes
        For arrItem = 0 To (unsortedArray.Length - 1)
            ' get current element
            currentItem = unsortedArray(arrItem)
            ' the position of the division of unsorted vs sorted
            insertItem = arrItem - 1

            While (insertItem >= 0 AndAlso (unsortedArray(insertItem) > currentItem))
                ' move insertItem to the right
                unsortedArray(insertItem + 1) = unsortedArray(insertItem)
                'move backward through the list to check the next insertion
                insertItem -= 1
            End While
            ' insert currentItem to the right
            unsortedArray(insertItem + 1) = currentItem
        Next ' end for each array item
    End Function ' insertion sort

    ' main entry point
    Sub Main(args As String())

        Dim arrToSort(20) As Integer
        Dim strOutput As String

        ' populate array with random values
        For index As Integer = 0 To arrToSort.Length - 1
            arrToSort(index) = CInt(Math.Ceiling(Rnd() * 100)) + 1
        Next

        Console.WriteLine(vbCrLf & "Array prior to sort: ")
        strOutput = ""
        'output unsorted array
        For index = 0 To arrToSort.Length - 1
            strOutput = strOutput & arrToSort(index) & " "
        Next ' end of for
        Console.WriteLine(strOutput)

        ' perform insertion sort
        InsertionSort(arrToSort)

        Console.WriteLine(vbCrLf & "Array after sort: ")
        strOutput = ""
        'output sorted array
        For index = 0 To arrToSort.Length - 1
            strOutput = strOutput & arrToSort(index) & " "
        Next
        Console.WriteLine(strOutput)
    End Sub
End Module
