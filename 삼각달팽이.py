def solution(n):
    if n == 1 : return [1]
    matrix = [[0 for _ in range(n)] for _ in range(n)] 
    answer =[]
    v = 1
    i, j = 0, 0
    while v < (n**2 + n + 2) / 2 :
        while(matrix[i][j] == 0) : 
            matrix[i][j] = v
            v += 1
            if(i == n - 1 or matrix[i+1][j] != 0) : break
            i += 1
        j += 1
        while(matrix[i][j] == 0) : 
            matrix[i][j] = v
            v += 1
            if(j == n - 1 or matrix[i][j+1] != 0) : break
            j += 1
        i -= 1
        j -= 1
        while(matrix[i][j] == 0) :
            matrix[i][j] = v
            i -= 1
            j -= 1
            v += 1
        i += 2
        j += 1
    
    for i in range(n) : 
        for j in range(i + 1) : 
            answer.append(matrix[i][j])

    return answer



print(solution(7)) 