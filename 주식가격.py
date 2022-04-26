def solution(prices):

    answer = [0 for i in range(len(prices))]
    stack = []

    for n in range(len(prices)) :
        while stack and (prices[stack[-1]] > prices[n]) : 
            top = stack.pop()
            answer[top] = n - top

        stack.append(n)
    
    while(stack) : 
        top = stack.pop()
        answer[top] = n - top
    return answer

print(solution([3]))