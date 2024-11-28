
# function: intToString 
def intToString(integer, base):
    # function: string representation of a number
    returnStr = []
    numBase = len(base)
    
    # while integer is not 0
    while integer:
        # start consuming the integer and get the remainder
        integer, remainder = divmod(integer, numBase)
        # lookup the remainder inside the base
        returnStr.append(base[remainder])
        # reverse the return string
        returnStr.reverse()
        # cleanup and return
        return ''.join(returnStr)

  # test function
  expectEqual(intToString(1230,base10), '123O')
  expectEqual(intToString(31337,base10), '31337')
  expectEqual(intToString(123,base2), 'llllOll')
