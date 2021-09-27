from typing import ValuesView
from itertools import permutations
from collections import deque


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

    for case in permutations(ex):
        stack_1 = deque(exp); stack_2 = deque([]);
        for c in case : 
            while stack_1 : 
                select = stack_1.popleft()
                if select == c : #연산해야 되면 스택1에서 바로 숫자 꺼내서 스택2의 탑과 계산해서 스
                    pre = stack_2.pop()
                    post = stack_1.popleft()
                    if c=='-' : stack_2.append(int(pre) - int(post))
                    elif c=='+' : stack_2.append(int(pre) + int(post))
                    else : stack_2.append(int(pre) * int(post))
                else : stack_2.append(select)
            stack_1, stack_2 = stack_2, stack_1
        answer = max(answer, int(stack_1[0]), -int(stack_1[0]))

    return answer

solution("100-200*300-500+20")