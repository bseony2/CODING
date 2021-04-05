def solution(n, results):
    winner = {}; loser = {}
    for i in range(1, n+1): #이긴 사람, 진사람 분류 winner[i]가 value들을 이김 & loser[i]가 values들에게 짐
        winner[i], loser[i] = set(), set()

    for r in results:
        winner[r[0]].add(r[1])
        loser[r[1]].add(r[0])

    for i in range(1, n+1):
        for j in winner[i]:
            loser[j].update(loser[i])
        for j in loser[i]:
            winner[j].update(winner[i])

    answer=0
    for i in range(1, n+1):
        if(len(winner[i]) + len(loser[i]) == n-1): answer += 1
    return answer



print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))