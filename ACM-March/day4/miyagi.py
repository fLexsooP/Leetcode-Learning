
iw = 4
ih = 2
top_block = ""
bot_block = ""
pw = 2000
ph = 1000
graph = []

with open('./miyagi.txt') as data:
    lines = data.readlines()
    top_block = lines[1].strip()
    bot_block = lines[2].strip()
    for line in lines[4:]:
        graph.append(line.strip())

# print(top_block)
# print(bot_block)
# print(graph)

top_dist = []
bot_dist = []

def find_all_occurrence(str, sub_str):
    res = []
    start_index = 0
    while True:
        index = str.find(sub_str, start_index)
        if index == -1:
            break
        res.append(index)
        start_index = index + 1
    return res
    

for line in graph:
    top_dist.append(find_all_occurrence(line, top_block))
    bot_dist.append(find_all_occurrence(line, bot_block))
    
# print(top_dist)
# print(bot_dist)

count = 0

for i in range(len(top_dist) - 1):
    for num in top_dist[i]:
        if num in bot_dist[i+1]:
            count += 1
            
print(count)