def solution(skill, skill_trees):
    answer = 0
    
    if(len(skill) == 1) : return len(skill_trees)
    for skillSet in skill_trees : 
        set = list(skill)
        key = set.pop(0)
        for value in skillSet : 
            if(value in set) : 
                break
            if(value == key) : key = set.pop(0)
            if(len(set) == 0) : break
        else : answer += 1
    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))