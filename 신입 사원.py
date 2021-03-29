import sys
input = sys.stdin.readline

def solution() :
    n = int(input())
    if(n==1) : return 1
    list = []
    for i in range(n):
        a, b = map(int, input().split(' '))
        list.append([a, b])
    list.sort()
    min_score = list[0][1]
    result = 1
    for i in range(1, len(list)):
        if(list[i][1] < min_score) :
            result += 1
            min_score = list[i][1]
    return result

T = int(input())
for i in range(T):
    print(solution())


