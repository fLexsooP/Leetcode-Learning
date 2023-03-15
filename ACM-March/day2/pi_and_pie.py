import heapq

def calc_pi_diff(r, a):
    PI = 3.141592653589793
    return abs(a / (r * r) - PI)

with open('./pi_and_pie.txt') as data:
    lines = data.readlines()
    differences = []
    
    for line in lines[1:]:
        words = line.split(' ')
        words[-1] = words[-1].strip()
        
        rad = int(words[0])
        area = float(words[1])
        difference = calc_pi_diff(rad, area)
        heapq.heappush(differences, (difference, rad))
        
    product = 1
    for _ in range(5):
        product *= heapq.heappop(differences)[1]
        
    print(product)