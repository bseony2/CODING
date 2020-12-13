def solution(k, score):
    answer = 0
    dif = 0

    distance = []

    for i in range(len(score)-1): #각 점수의 차이를 배열로 모아둠
        distance.append(score[i] - score[i+1])

    bug = []
    for i in range(len(distance)):
        if distance.count(distance[i]) >= k :
            if bug.count(distance[i]) != 0 : continue
            bug.append(distance[i])

    if len(bug) == 0 :return 0


    not_bug=[]

    for i in range(len(score)):
        if i == 0 :
            if(score[i] - score[i+1]) not in bug: not_bug.append(score[i])
            continue
        if i == len(score)-1:
            if (score[i-1]-score[i]) not in bug : not_bug.append(score[i])
            continue
        if ((score[i-1]- score[i]) not in bug) and ((score[i]-score[i+1]) not in bug):
            not_bug.append(score[i])


    return answer