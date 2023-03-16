
start = ""
end = ""
n = 0
# Initialize the flights dictionary
flights = {city: {} for city in [start, end]}

with open('./leaving_lisbon_v2.txt') as data:
    lines = data.readlines()
    differences = []
    
    for index in range(len(lines)):
        words = lines[index].split(' ')
        words[-1] = words[-1].strip()
        # print(words)
        if index == 0:
            start = words[-1]
        elif index == 1:
            end = words[-1]
        elif index == 2:
            n = int(words[-1])
        else:
            u = words[0]
            v = words[1]
            w = sum(x * int(t) for x, t in zip([60, 1], words[2].split(":")))
            d = sum(x * int(t) for x, t in zip([60, 1], words[3].split(":")))
            print(f'{u:20}{v:20}{w:5}{d:5}')


print(start)
print(end)
print(n)
print(flights)

