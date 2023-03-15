
with open('./parsing_people.txt') as data:
    lines = data.readlines()
    count = 0
    max = 0
    for line in lines[1:]:
        words = line.split(' ')

        word = words[1]
        if word == "entered":
            count += 1
            if count > max:
                max = count
        else:
            count -= 1

    print(str(max))