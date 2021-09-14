def solution(rows, columns, queries):
    answer = []
    table = []

    for i in range(rows):
        table.append([col for col in range(1+(i*columns), 1 + ((i+1)*columns))])

    
    for query in queries:
        
        query = [x-1 for x in query]
        x1, y1, x2, y2 = query[:4]
        temp = table[x1][y2]
        minimum = temp

        for r in range(y2, y1, -1):
            table[x1][r] = table[x1][r-1]
            minimum = min(minimum, table[x1][r])
        
        for r in range(x1, x2) :
            table[r][y1] = table[r+1][y1]
            minimum = min(minimum, table[r][y1])
        
        for r in range(y1, y2) :
            table[x2][r] = table[x2][r+1]
            minimum = min(minimum, table[x2][r])

        for r in range(x2, x1 + 1, -1) : 
            table[r][y2] = table[r-1][y2]
            minimum = min(minimum, table[r][y2])

        table[x1 + 1][y2] = temp

        answer.append(minimum)

    return answer


print(solution(6, 6, [[2,2,5,4],[3,3,6,6],[5,1,6,3]]))