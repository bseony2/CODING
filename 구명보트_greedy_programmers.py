def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    
    higher_index = len(people) - 1
    lower_index = 0

    while(higher_index >= lower_index) :
        answer += 1
        if(people[higher_index] + people[lower_index] <= limit) : 
            higher_index -= 1
            lower_index += 1
        else : 
            higher_index -= 1
    return answer

print(solution([70, 50, 80, 50], 100))