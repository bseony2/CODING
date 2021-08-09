def solution(scores):
    answer =""
    for person in range(len(scores)) :
        score = [i[person] for i in scores]
        if(score[person] == max(score) or score[person] ==min(score)) and score.count(score[person]) == 1:
            del score[person]

        if sum(score)/len(score) < 50 : answer += 'F'
        elif sum(score)/len(score) < 70 : answer += 'D'
        elif sum(score)/len(score) < 80 : answer += 'C'
        elif sum(score)/len(score) < 90 : answer += 'B'
        else : answer += 'A'
    return answer
print(solution([[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]))
