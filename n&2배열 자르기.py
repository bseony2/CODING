from collections import deque
def solution(n, left, right):
    answer = deque([])

    while (left <= right) : 
        answer.append(max(int(left / n), left%n) + 1)
        left += 1

    return answer

print(solution(4, 7, 14))