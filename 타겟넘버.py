import collections

def solution(numbers, target):
    answer = 0
    stack = collections.deque([(0, 0)])
    while stack:
        num, idx = stack.popleft()

        if idx == len(numbers):
            if num == target:
                answer += 1
        else:
            number = numbers[idx]
            stack.append((num+number, idx + 1))
            stack.append((num-number, idx + 1))

    return answer
