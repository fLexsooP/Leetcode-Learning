'''
2. Racing Results
Unfortunately. the database containing all this years racing results has crashed. The only thing left is a backup of database records and results for each race. We urgently need to extract two pieces of information:
    The winner of the and how many points they got so we can give them a trophy
    A list of racers who did not earn any point this year as they will be possibly relegated

Your program will receive input as a list Of elements in the form Of [race, racer_name, position), where all elements are integers:
    race is a database record number between 2001 and 2000+N where N is the total number of races in the championship.
    racer_name is a database record number between 1001 and 1000+R where R is the total number of racers
    position is a value between 1 (won the race) and R (arrived last).

Points are given according to the racers' position in a race, such that the 1st posit»on is worth 1O points, 2nd is worth 6 points. 3rd 4 points, 4th is 3 points. 5th is 2 points and 6th is worth 1 point. Positions further down earn no points.
In case of an equal number of points at the end of the championship. racers are sorted in record order for the purpose of classification. There are at most 100 racers, and at most 100 races in the championship.

Your program is expected to output two lines:
    one line with the record number Of the winning racer (that is, the racer with the most points). followed by their point total
    one line with all record number of racers having earned zero points. in increasing order

Example:
Here's an example. With two races and three racers. The raw results are:
[2001, 1001, 3]
[2001, 1002, 2]
[2002, 1003, 1]
[2002, 1001, 2]
[2002, 1002, 3]
[2001, 1003, 1]

The two races are coded 2001 and 2002. The racers with records 1001. 1002 and 1003 competed,
Based on the raw results. they have the following points:
Racer 1001: 4+6=10 (3rd and 2nd positions)
Racer 1002: 6+4=10 (2nd and 3rd positions)
Racer 1003: 10+10=20 (1st in both races)

Your program is expected to output the following lines in that case:
1003 20
<empty tine as no racers got points>

'''

from typing import List

def computePoint(position):
    if position == 1:
        return 10
    elif position == 2:
        return 6
    elif position == 3:
        return 4
    elif position == 4:
        return 3
    elif position == 5:
        return 2
    elif position == 6:
        return 1
    else:
        return 0

def sol(raw_data: List[List[int]]) -> None:
    res = ""
    pointsMap = dict()

    for  record in raw_data:
        race, racer, position = record
        points = computePoint(position)
        if racer in pointsMap:
            pointsMap[racer] += points
        else:
            pointsMap[racer] = points

    winning_racer, pointsTotal = max(pointsMap.items(), key=lambda x: x[1])
    relegatedRacer = [x[0] for x in pointsMap.items() if x[1] == 0]
    # delegateRacer = pointsMap

    res += str(winning_racer) + " " + str(pointsTotal) + "\n"
    for x in relegatedRacer:
        res += str(x)
    print(res)

data = [[2001, 1001, 3],
        [2001, 1002, 2],
        [2002, 1003, 1],
        [2002, 1001, 2],
        [2002, 1002, 3],
        [2001, 1003, 1],
        [2002, 1004, 7],
        [2001, 1004, 7]]

sol(data)