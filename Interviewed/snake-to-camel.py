'''
给定一个字符串docString，其中quote用``符号括起来。quote中可能有一个或多个蛇形命名法（用"_"连接）的变量或常量，多个变量间用空格隔开。变量的所有字母小写，常量的所有字母大写。要求将所有变量改为驼峰命名法，常量不改，输出改后的字符串。

例：docString="This is a document includes `first_variable second_camel_varible`. There are also symbols `FIRST_CONSTANT` and `third_variable`."
输出 "This is a document includes `firstVariable secondCamelVarible`. There are also symbols `FIRST_CONSTANT` and `thirdVariable`."
'''

docString="This is a document includes `first_variable second_camel_varible`. There are also symbols `FIRST_CONSTANT` and `third_variable`."

def foo(text):
    def processingCamel(v):
        ans = ""
        for i in range(len(v)):
            if v[i - 1] == "_":
                ans += v[i].upper()
            elif v[i] != "_":
                ans += v[i]
        return ans

    res = ""
    i = 0
    
    while i < len(text):
        if text[i] == "`":
            var = "`"
            j = i + 1

            while text[j] != "`":
                var += text[j]
                j += 1
            var += "`"

            if var == var.upper():
                res += var
            else:
                res += processingCamel(var)
            # print(var)
            i = j + 1

        res += text[i]
        i += 1

    return res

print(foo(docString))