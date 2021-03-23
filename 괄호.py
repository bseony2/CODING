def solution(s):
    answer = True
    
    check = 0
    for i in range(len(s)):
        if(s[i] == '('):
            check += 1
        else : check -=1
        if(check<0) :
            answer = False
            break
    if(check != 0): answer = False

    return answer