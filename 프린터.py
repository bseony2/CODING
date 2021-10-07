from collections import deque

def solution(priorities, location):
    answer = 0
    queue = deque(priorities)
    while(True) : 
        maxValue = max(queue)
        select = queue.popleft()
        if(location == 0 and maxValue == select) : return answer + 1
        elif(maxValue == select and location != 0) : #다른거 하나 빠져나갈 때
            answer = answer + 1
            location = location - 1
        else : 
            queue.append(select)
            if(location == 0) : location = len(queue) - 1
            else : location = location - 1

print(solution([2, 4, 5, 3, 3, 4,  2, 1], 4))


# def solution(priorities, location):
#     answer = 0
#     closeMaxValue = max(priorities) #키값 바로 다음으로 큰 값(키값의 동일값을 제외하고 키값 바로 이전에 프린트 될 값)
#     keyValue = priorities[location] #뽑으려는 값
#     if(closeMaxValue == keyValue) : return priorities[:location].count(keyValue) + 1 #이미 가장 큰 값이면 자기보다 앞에 있는 동일 우선순위 다음으로 출력

#     for i in range(len(priorities)) : 
#         if(priorities[i] > keyValue) : answer += 1
#         if keyValue < priorities[i] <= closeMaxValue : 
#             closeMaxValue = priorities[i]
#             index = i # closeMaxValue의 인데스
    
#     if(index < location) : return answer + priorities[index:location].count(keyValue) + 1 #closeMaxValue가 location 보다 앞에 있을 경우
#     else : return answer + priorities[:location].count(keyValue) + priorities[index:].count(keyValue) + 1