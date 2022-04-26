# if __name__ == '__main__':
def solution(n, put) : 
    n = int(input())
    arr = map(int, input().split())
    max = float('-inf')
    result = float('-inf')
    for a in arr : 
        if a > max : max, result = a, max
        if result < a < max : result = a
    return result

print(solution(5, '2 3 6 6 5'))