from itertools import combinations

def solution(orders, course):
    answer = []
    for sizeOfCourse in course:
        combie = {}

        for order in orders:
            for set in combinations(sorted(order), sizeOfCourse) :
                if set in combie.keys() : combie[set] = combie.get(set) + 1
                else : combie[set] = 1
        
        if(len(combie.keys())==0) : continue
        else : maxSet = max(combie.values())
        if maxSet < 2 : continue
        for selected in combie.keys():
            if combie[selected] == maxSet : answer.append(''.join(selected))
    return sorted(answer)

print(solution(["XYZ", "XWY", "WXA"], [2,3,5]))