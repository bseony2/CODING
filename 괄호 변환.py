def isCorrectString(string) : #균형잡힌 괄호 문자열
    left = 0; right = 0;
    if string[0] == ')' or string[-1] == '(': return False
    for s in string : 
        if s == '(' : left = left + 1
        else : right = right + 1
        if right > left : return False
    if right == left : return True

def isBalancedString(string) : 
    if string.count('(') == string.count(')') : return True
    else : return False

def reversString(string) :
    answer =''
    for s in string :
        if s == '(' : answer += (')')
        else : answer += ('(')
    return answer

def construct(string) : 
    if string == '' or None: return ''
    answer = ''
    for s in range(1, len(string) + 1) : 
        if(isCorrectString(string[:s])) : #u가 올바른 문자열일 경우
            answer += (string[:s])
            return answer + construct(string[s:])
        elif(isBalancedString(string[:s])) : #u가 균형잡힌 문자열일 경우
            #if string[:s] == ')(' : return '()'
            blankString =''
            blankString += ('(') 
            blankString += construct(string[s:])
            blankString += (')')
            blankString += (reversString(string[1:s -1]))
            return blankString
    return answer

def solution(string):
    if(isCorrectString(string)) : return string
    return construct(string)


print(solution("()))((()"))