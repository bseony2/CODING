n = int(input())
result = []
for _ in range(n) : 
    line = input().split(' ')
    for i in range(1, len(line)) :
        line[i] = int(line[i])
    if line[0] == 'insert' : 
        result.insert(line[1], line[2])
    elif line[0] == 'append' : 
        result.append(line[1])
    elif line[0] == 'print' : 
        print(result)
    elif line[0] == 'remove' : 
        result.remove(line[1])
    elif line[0] == 'sort' : 
        result.sort()
    elif line[0] == 'pop' : 
        result.pop()
    elif line[0] == 'reverse' : 
        result.reverse()