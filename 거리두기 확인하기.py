from collections import deque

def bfs(place):
    start =[]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for row in range(5) : 
        for col in range(5) : 
            if place[row][col] == 'P' : start.append([row, col])

    for s in start : 
        distance = [[0]*5 for i in range(5)]
        visited = [[0]*5 for i in range(5)]
        visited[s[0]][s[1]] = 1
        queue = deque([s])

        while queue : 
            y, x = queue.popleft()

            for i in range(4) : 
                nx = x + dx[i]; ny = y + dy[i]
                #유요한 좌표 + 방문 안 한
                if 0 <= nx <5 and 0 <= ny < 5  and visited[ny][nx]==0 :
                    
                    if place[ny][nx] == 'O' and visited[ny][nx] == 0: 
                        distance[ny][nx] = distance[y][x] + 1
                        visited[ny][nx] = 1
                        if distance[ny][nx] <= 1 : queue.append([ny, nx])
                    if place[ny][nx] == 'P' and distance[ny][nx] <= 2: return 0

    
    return 1



def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    
    return answer
    
    


print(solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]))