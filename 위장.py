import sys
input = sys.stdin.readline

def solution(clothes):
    match = {}
    for x in clothes:
        if x[1] in match:
            match[x[1]] = match[x[1]] + 1
        else : match[x[1]] = 1

    answer = 1
    list = []
    for a in match.values():
        answer *= (a+1)
    return answer-1

clothes = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
solution(clothes)