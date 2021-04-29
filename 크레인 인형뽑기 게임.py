def solution(board, moves):
    answer = 0
    stack=[]
    n = len(board)
    basket = [[] for row in range(n+1)]
    for row in board[::-1]:
        print(row)
        for i in range(len(row)):
            if(row[i] == 0) : continue
            basket[i+1].append(row[i])
    
    for m in moves:
        if(len(basket[m]) == 0) : continue
        else:
            stack.append(basket[m].pop())
        if(len(stack)>1 and stack[-1] == stack[-2]): 
            del stack[-1]
            del stack[-1]
            answer += 2
    return answer

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[1,5,3,5,1,2,1,4]))