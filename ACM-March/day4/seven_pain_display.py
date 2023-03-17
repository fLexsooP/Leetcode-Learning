# Parsing
# each block is w:3 h:5, so that the block list is 3*5
def parse_label_three(block: list):
    NUMBER_0 = [1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1]
    # NUMBER_1 = []
    NUMBER_2 = [1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1]
    NUMBER_3 = [1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1]
    NUMBER_4 = [1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1]
    NUMBER_5 = [1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1]
    NUMBER_6 = [1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1]
    NUMBER_7 = [1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1]
    NUMBER_8 = [1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1]
    NUMBER_9 = [1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1]
    PLUS = [0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0]
    MINUS = [0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0]
    MULTIPLY = [0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0]
    # DOT = []
    
    character = []
    for i in range(5):
        for j in range(3):
            if block[i][j] == '#':
                character.append(1)
            else:
                character.append(0)
    
    if character == NUMBER_0:
        return '0'     
    elif character == NUMBER_2:
        return '2'
    elif character == NUMBER_3:
        return '3'
    elif character == NUMBER_4:
        return '4'
    elif character == NUMBER_5:
        return '5'
    elif character == NUMBER_6:
        return '6'
    elif character == NUMBER_7:
        return '7'
    elif character == NUMBER_8:
        return '8'
    elif character == NUMBER_9:
        return '9'
    elif character == PLUS:
        return '+'
    elif character == MINUS:
        return '-'
    elif character == MULTIPLY:
        return '*'
    else:
        return None
                
def parse_label_two(block: list):
    NUMBER_1 = [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
    DOT = [0, 0, 0, 0, 0, 0, 0, 0, 0, 1]
    character = []
    for i in range(5):
        for j in range(2):
            if block[i][j] == '#':
                character.append(1)
            else:
                character.append(0)
    if character == NUMBER_1:
        return '1'     
    elif character == DOT:
        return '.'
    else:
        return None
    

    
# l1 = [[' ', ' ', ' '],
#       ['#', ' ', '#'],
#       [' ', '#', ' '],
#       ['#', ' ', '#'],
#       [' ', ' ', ' ']]
# l2 = [[' ', ' '],
#       [' ', ' '],
#       [' ', ' '],
#       [' ', ' '],
#       [' ', '#']]
# print(parse_label_three(l1))
# print(parse_label_two(l2))


# File Open

n = 0
block = []

with open('./seven_pain_display.txt') as data:
    lines = data.readlines()
    n = int(lines[0].strip())
    
# for i in range(n):
    i = 0
    line_start = 1 + i * 6
    line_end = line_start + 5
    cur_index = 0
    for l in lines[line_start:line_end]:
        block.append(l[cur_index:cur_index + 3])
        cur_index += 5
            
        
    print(block)
            
        
# print(n)