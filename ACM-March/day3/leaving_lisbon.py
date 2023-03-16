
start = ""
end = ""
flights = {}

with open('./leaving_lisbon.txt') as data:
    lines = data.readlines()
    differences = []
    
    for index in range(len(lines)):
        words = lines[index].split(' ')
        words[-1] = words[-1].strip()
        if index == 0:
            start = words[-1]
        elif index == 1:
            end = words[-1]
        elif index == 2:
            continue
        else:
            flights[words[0]] = words[1]
            
# print(start)
# print(end)
# print(flights)

elusiveness = 0
cur = start
while cur != end:
    next = flights[cur]
    if len(next) > len(cur):
        elusiveness += 5
    elif len(next) < len(cur):
        elusiveness -= 2
    cur = next

print(elusiveness)
