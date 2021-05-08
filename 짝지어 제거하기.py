def solution(s):
    answer = 1
    stack = []

    for d in s:
        if(stack):
            if stack[-1] == d:
                stack.pop()
            else : stack.append(d)
        else: stack.append(d)

    if(stack): answer = 0

    return answer

print(solution('cdcd'))