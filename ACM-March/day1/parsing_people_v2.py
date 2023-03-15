def count_frankie(words:list) -> int:
    count = 0
    for word in words[:-3]:
        if word != "and":
            count += 1
    if words[-3] == "entered":
        return count
    else:
        return -count


def count_claire(words:list) -> int:
    count = int(words[0])
    if words[-1] == "in":
        return count
    else:
        return -count

def count_hank(words:list) -> int:
    count = 0
    if words[-2] == "others" or words[-2] == "other":
        count = int(words[-3]) + 1
    else:
        count = 1
    
    if words[-1] == "arrived":
        return count
    else:
        return -count

    """ log format
    Frankie :   name1                       entered/exited the room
                name1 and name2             entered/exited the room
                name1, name2 and name3      entered/exited the room
                
    Claire  :   x   person                  walked in/out
                xx  people                  walked in/out 
                
    Hank    :   name                        arrived/departed
                name and 1 other            arrived/departed
                name and xx others          arrived departed
    """
    
with open('./parsing_people_v2.txt') as data:
    lines = data.readlines()
    people_count = 0
    max = 0
    for line in lines[1:]:
        words = line.split(' ')
        words[-1] = words[-1].strip()
        last_word = words[-1]
        
        print(words)
        
        # split into each log
        if last_word == "room": # case Frankie
            people_count += count_frankie(words)
            if people_count > max:
                max = people_count
        elif last_word == "in" or last_word == "out": # case Claire
            people_count += count_claire(words)
            if people_count > max:
                max = people_count
        else: # case Hank
            people_count += count_hank(words)
            if people_count > max:
                max = people_count
            
    print(max)
