from typing import ValuesView


def solution(expression):
    answer = 0

    ex = ['*', '+', '-']
    start = 0
    exp = []
    for index, value in enumerate(expression):
        if value in ex : 
            exp.append(expression[start:index])
            exp.append(expression[index])
            start = index + 1
        elif index + 1 == len(expression) : exp.append(expression[start:])
        else : continue

    for i in ex : 
        if i not in expression : ex.remove(i)

    print(ex)

    return answer

solution("50*6-3*2")