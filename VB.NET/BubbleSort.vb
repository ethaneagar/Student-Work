' simple example of a bubble sort on an array

Imports System

Module Program

    ' Function Description
    ' - performs bubble sort on an array
    ' - smallest values bubble to the top, largest values sink to the bottom
    ' Arguments:
    ' - unsortedArray - integer array to sort
    ' Return Value:
    ' - array passed by reference
    Public Function BubbleSort(ByRef unsortedArray As Integer())
        Dim arrItem, compareItem, swapItem As Integer
        ' outer loop controlling the number of sort passes
        For arrItem = 0 To (unsortedArray.Length - 1)
            ' inner loop controlling the number of comparisons 
            For compareItem = 0 To (unsortedArray.Length - 2)
                ' swap if out of order
                If unsortedArray(compareItem) > unsortedArray(compareItem + 1) Then
                    swapItem = unsortedArray(compareItem + 1)
                    unsortedArray(compareItem + 1) = unsortedArray(compareItem)
                    unsortedArray(compareItem) = swapItem
                End If ' end if out of order
            Next ' end for each comparison
        Next ' end for each array item
    End Function ' bubble sort

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

        ' perform bubble sort
        BubbleSort(arrToSort)

        Console.WriteLine(vbCrLf & "Array after sort: ")
        strOutput = ""
        'output sorted array
        For index = 0 To arrToSort.Length - 1
            strOutput = strOutput & arrToSort(index) & " "
        Next
        Console.WriteLine(strOutput)
    End Sub
End Module
