import sys
input = sys.stdin.readline

n = int(input())
count = 1
stack = []
result = []

for i in range(1, n+1):
    data = int(input())
    while count <=data:
        stack.append(count)
        count += 1
        result.append('+')
    if stack[-1] == data:
        result.append('-')
        stack.pop()
    else : 
        print('NO')
        sys.exit()

for i in result:
    print(i)