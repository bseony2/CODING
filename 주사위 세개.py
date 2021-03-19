list = list(map(int, input().split(' ')))
result = []
for i in list :
    if(len(result) == 0) : 
        result.append([i, 1])
        continue
    
    for j in range(len(result)):

        if(i == result[j][0]) : 
            result[j][1] += 1
            break
        if(j==len(result)-1) : result.append([i, 1])

result.sort()

if(len(result) == 3):
    print(result[-1][0] * 100)
elif(len(result) == 2) :
    if(result[0][1] == 2) : print(1000+ result[0][0] * 100)
    else:print(1000+ result[1][0] * 100)
else : print(10000 + result[0][0] * 1000)
