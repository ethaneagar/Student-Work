
# function: int_to_string 
def int_to_string(integer, base):
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
  expectEqual(int_to_string(1230,base10), '123O')
  expectEqual(int_to_string(31337,base10), '31337')
  expectEqual(int_to_string(123,base2), 'llllOll')
