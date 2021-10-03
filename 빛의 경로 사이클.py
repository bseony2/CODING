def check_cycle(row, col, d):
    result = 0
    while(visited[row][col][d] == False):
        visited[row][col][d] = True
        board = [[0, 1, 2, 3], [2, 3, 1, 0], [3, 2, 0, 1]]  # S, R, L
        dx = [-1, 1, 0, 0]
        dy = [0, 0, 1, -1]

        nx = row + dx[d]; ny = col + dy[d]
        if (nx == -1) : nx = maxX - 1
        elif (nx == maxX) : nx = 0
        
        if(ny == -1) : ny = maxY - 1
        elif(ny == maxY) : ny = 0

        row, col = nx, ny
        if graph[row][col] == 'S' : d = board[0][d]
        elif graph[row][col] == 'R' : d = board[1][d]
        else : d = board[2][d]
        
        result += 1
    return result

def solution(grid):
    global graph
    graph = grid
    global visited, maxY, maxX
    answer = []
    maxX = len(grid)
    maxY = len(grid[0])
    visited = [[[False for _ in range(4)] for col in range(len(grid[0]))] for row in range(len(grid))]
    for row in range(len(grid)) :
        for col in range(len(grid[0])) :
            for isVist in range(4) : #["UP", "DOWN", "RIGHT", "LEFT"]
                if(visited[row][col][isVist] == False) : answer.append(check_cycle(row, col, isVist))
    return sorted(answer)

print(solution(["R", "R"]))