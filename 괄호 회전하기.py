def isCorrect(string) : 
    result = False
    stack = []
    for s in string : 
        if(len(stack) != 0) and (stack[-1] == "{" and s == "}" or stack[-1] == "[" and s == "]" or stack[-1] == "(" and s == ")"): 
            stack.pop()
        else : stack.append(s)
    if(len(stack) == 0) : result = True
    return result

def solution(s):
    answer = 0
    for n in range(len(s)) : 
        if(isCorrect(s[n:] +s[:n])) : answer += 1
    return answer
print(solution("[](){}"))
print(solution("}]()[{"))
print(solution("[)(]"))
print(solution("}}}"))