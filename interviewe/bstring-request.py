'''
给定一个二进制字符串binaryString，只由0和1组成。给定一个字符串‍‍‍‌‍‍‍‍‌‌‌‍‍‌‍‍‍‍‌‌数组requests，包含以下两种操作：
    "count:idx"：计算当前binaryString中第idx位前共有多少个1
    "flip"：将整个binaryString翻转，即所有0变为1，所有1变为0
   返回所有count操作的结果
'''

def foo(bstr, req):
    n = len(bstr)
    count_1 = [0] * (n + 1)
    res = []

    for i in range(n):
        if bstr[i] == "1":
            count_1[i + 1] = count_1[i] + 1
        else:
            count_1[i + 1] = count_1[i]

    isFlip = False
    # print(count_1)
    for r in req:
        if r == "flip":
            isFlip = not isFlip
        else:
            index = int(r[6:])
            if isFlip:
                res.append(index - count_1[index-1])
            else:
                res.append(count_1[index-1])


    return res

bstring = "1111010"
requests = ["count:4", "count:6", "flip", "count:1", "flip", "count:2"]
print(foo(bstring, requests))