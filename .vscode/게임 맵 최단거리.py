from collections import deque
def solution(maps):
    answer = -1

    m = len(maps)
    n = len(maps[0])

    distance = [[float('inf') for _ in range(n)] for _ in range(m)]
    distance[0][0] = 1
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]  #아래, 왼쪽, 위, 오른쪽

    queue = deque([(0, 0)])
    while(queue) : 
        y, x = queue.popleft()
        for i in range(4) : 
            ny = y + dy[i]; nx = x + dx[i]
            if(ny == m and nx == n) : return distance[y][n] + 1
            if( 0 <= ny < m and 0 <= nx < n and maps[ny][nx] != 0 ) : 
                if( distance[ny][nx] -1 > distance[y][x] ) : 
                    queue.append((ny, nx))
                    distance[ny][nx] = distance[y][x] + 1
    if(distance[m-1][n-1] < float('inf')) : 
        answer = distance[m-1][n-1]

    return answer

print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
