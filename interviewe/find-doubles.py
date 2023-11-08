'''
1. Find Doubles
    Given a list of N integers. not necessarily un.que, f.r•.d all elements
    of the list for which there exists exactly one element of the list
    is twice that number. The integers range from O to 1000.
    The Est has no more than 100000 elements.
    Your code should find the appropriate values and pont them to
    STDOUT •n sorted order.
Examples:
1 2 3 4 5 6 7 8 9 0 8 -> 0 1 2 3
(8 is 4*2. but 8 is present t•mce; O fts own double. so it •s part Of the result)

7 17 11 1 23 -> <blank>
(nothing ts exactly twice another element)

1 1 2 -> 1 1
(1 and 1 both have their double 2 present. and 2 is present in the list only once)
'''

from typing import List


def sol(values: List[int]) -> List[int]:
    res = []
    validSet = set()
    for val in values:
        if val % 2 == 0:
            candVal = val // 2
            if candVal not in validSet:
                validSet.add(candVal)
            else:
                validSet.remove(candVal)

    for val in values:
        if val in validSet:
            res.append(val)

    return res

nums1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8]
nums2 = [7, 17, 11, 1, 23]
nums3 = [1, 1, 2]

print(f"result1: {sol(nums1)}\n")
print(f"result2: {sol(nums2)}\n")
print(f"result3: {sol(nums3)}\n")
