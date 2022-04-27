import sys
input = sys.stdin.readline

answer = 0
n = int(input())
factory = [*map(int, input().strip().split(' '))]



for i in range(len(factory) - 2) : 
    if(factory[i + 1] > factory[i + 2]) : 
        minimum = min(factory[i], factory[i + 1] - factory[i + 2])
        factory[i : i + 2] = [x - minimum for x in factory[i : i + 2]]
        answer += minimum * 5

        minimum = min(factory[i], factory[i + 1], factory[i + 2])
        factory[i : i + 3] = [x - minimum for x in factory[i : i + 3]]
        answer += minimum * 7
    else : 
        minimum = min(factory[i], factory[i + 1], factory[i + 2])
        factory[i : i + 3] = [x - minimum for x in factory[i : i + 3]]
        answer += minimum * 7

        minimum = min(factory[i], factory[i + 1])
        factory[i : i + 2] = [x - minimum for x in factory[i : i + 2]]
        answer += minimum * 5
    answer += factory[i] * 3

minimum = min(factory[-1], factory[-2])
answer += minimum * 5
answer += (factory[-1] - minimum) * 3
answer += (factory[-2] - minimum) * 3

print(answer)