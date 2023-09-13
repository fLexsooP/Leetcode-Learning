"""
lc 249
You are given a list of string, group them if they are same after using Ceaser Cipher Encrpytion.
Definition of "same", "abc" can right shift 1, get "bcd", here you can shift as many time as you want, the string will be considered as same.

Example:
Input: ["abc", "bcd", "acd", "dfg"]
Output: [["abc", "bcd"], ["acd", "dfg"]]
"""

from collections import defaultdict

def solve(s):
    def getKey(word):
        key = ""
        prevChar = word[0]
        for char in word[1:]:
            diff = (ord(char) - ord(prevChar)) % 26
            key += str(diff)
            prevChar = char
        return key

    d = defaultdict(list)

    for password in s:
        d[getKey(password)].append(password)

    return list(d.values())

input = ["abc", "bcd", "acd", "dfg", "temp", "xyz", "zab", "yab"]
print(solve(input))