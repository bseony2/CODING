def solution(nums):
    answer = 0
    length = len(nums) // 2
    nums.sort()
    last = 0
    
    for value in nums :
        if(value != last and answer < length):
            answer +=1
            last = value
            
    return answer