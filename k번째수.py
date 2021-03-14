def solution(array, commands):
    answer = []
    for temp in commands:
        temp_array = array[temp[0]-1:temp[1]]
        temp_array.sort()
        answer.append(temp_array[temp[2]-1])
    return answer


