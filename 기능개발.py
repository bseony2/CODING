
def solution(progresses, speeds):
    time = []
    answer = []
    for i in range(len(progresses)):
        if((100 - progresses[i]) % speeds[i] == 0) : time.append((100 - progresses[i]) // speeds[i])
        else : time.append((100 - progresses[i]) // speeds[i] + 1)
    time2 = time.copy()
    while(len(time)>0):
        num = 0
        key = time[0]
        for i in range(len(time)):
            if(key>=time[i]) : 
                num+=1
                del time2[0]
            else:break
        
        answer.append(num)
        time = time2.copy()

    return answer

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
print(solution(progresses, speeds))