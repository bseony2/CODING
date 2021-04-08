import copy

def solution(board):
    board2 = copy.deepcopy(board)
    answer = 0

    for row in range(1, len(board)):
        for col in range(1, len(board[0])):
            if(board[row][col]) >= 1:
                board[row][col] = min(board[row-1][col], board[row-1][col-1], board[row][col-1]) + 1
                # if board[row][col] >answer : answer = board[row][col]
    for row in range(1, len(board)):
        for col in range(1, len(board[0])):
            if board[row][col] > answer : answer = board[row][col]
    return answer**2
print(solution([[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]))