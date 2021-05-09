def solution(n):
    answer = ''
    while n :
        if n%3 == 0 : answer = '4'+answer
        elif n%3 == 1 :answer = '1' + answer
        else : answer = '2'+answer
        n = n//3 - (n%3 == 0)
    return answer
print(solution(6))