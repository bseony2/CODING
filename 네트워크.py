import sys
input = sys.stdin.readline

def solution(n, computers):
    answer = n
    list =[]
    for _ in range(n):
        list.append(set())
    for i in range(n):
        for j in range(i):
            if(computers[i][j] == 1):
                if(j not in list[i]):
                    list[i].add(j)
                    list[j].add(i)
                    for a in list[i]:
                        list[a].update(list[i])
                    for a in list[j]:
                        list[a].update(list[j])
                    answer -= 1
                else : 
                    list[i].update(list[j])
                    list[j].update(list[i])

    return answer

print(solution(5, [[1, 0, 0, 0, 0], [0, 1, 1, 1, 0], [0, 1, 1, 0, 1], [0, 1, 0, 1, 0], [0, 0, 1, 0, 1]]))
print(solution(4, [[1, 0, 0, 0], [0, 1, 1, 1], [0, 1, 1, 0], [0, 1, 0, 1]]))
