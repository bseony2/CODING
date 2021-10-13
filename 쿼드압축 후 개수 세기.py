def process(array, topY, topX, bottomY, bottomX) : 
    flag = array[topY][topX]
    isDone = False
    for i in range(topY, bottomY) : 
        for j in range(topX, bottomX) : 
            if(array[i][j] != flag) : 
                process(array, int(topY), int(topX), int((topY + bottomY)/2), int((topX + bottomX)/2)) 
                process(array, int(topY), int((topX + bottomX)/2), int((topY + bottomY)/2), int(bottomX)) # 2244 => 2334
                process(array, int((topY + bottomY)/2), int(topX), int(bottomY), int((topX + bottomX)/2)) # 4, 0, 8, 4       (2042) => 3041
                process(array, int((topY + bottomY)/2), int((topX + bottomX)/2), int(bottomY), int(bottomX)) # 4, 4, 8, 8
                isDone = True
                break
        if(isDone) : break
    else : 
        if(flag == 0) : 
            answer[0] += 1
        else : 
            answer[1] += 1


def solution(array) : 
    global answer
    answer = [0, 0]
    process(array, 0, 0, len(array), len(array))
    return answer
print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))