'''
给定一个二进制字符串binaryString，只由0和1组成。给定一个字符串‍‍‍‌‍‍‍‍‌‌‌‍‍‌‍‍‍‍‌‌数组requests，包含以下两种操作：
    "count:idx"：计算当前binaryString中第idx位前共有多少个1
    "flip"：将整个binaryString翻转，即所有0变为1，所有1变为0
   返回所有count操作的结果
'''

def foo(bstr, req):
    def flip():
        for i in range(len(blist)):
            if blist[i] == "0":
                blist[i] = "1"
            else:
                blist[i] = "0"

    res = []
    blist = list(bstr)

    for r in req:
        if r == "flip":
            flip()
            # print(blist)
        else:
            index = int(r[6:])
            # print(index)
            # TODO: count before index


    return res

bstring = "01101011101001"
requests = ["count:4", "flip", "count:2", "flip", "count:8", "count:5", "flip", "count:10"]
print(foo(bstring, requests))