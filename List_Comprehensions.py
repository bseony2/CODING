# if __name__ == '__main__':
#     x = int(input())
#     y = int(input())
#     z = int(input())
#     n = int(input())
def solution(x, y, z, n) :
    result = []
    for a in range(x + 1):
        for b in range(y + 1):
            for c in range(z + 1) :
                if(sum([a, b, c]) != n) : result.append([a, b, c])
    return result

print(solution(1, 1, 2, 3))