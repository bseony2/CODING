from itertools import combinations

def solution(relation):
    answer = []
    tuple = list(range(len(relation[0])))
    for i in range(1, len(tuple) + 1) : 
        for combi in combinations(tuple, i) : 
            temp = []
            for rel in relation : 
                current_key = [rel[c] for c in combi]
                if current_key in temp : 
                    break
                else : 
                    temp.append(current_key)
            else : # for else를 사용하여 유일성이 확인되어있음, 최소성 확인 필요
                for ck in answer :
                    if(set(ck).issubset(set(combi))) : break
                else : answer.append(combi)
    return len(answer)