import sys
input = sys.stdin.readline

T = int(input())
result = [0, 0, 0]
while(T>=10):
    if(T>= 300):
        result[0] += T//300
        T -= (T//300) * 300
    elif(T>=60):
        result[1] += T//60
        T -= (T//60) * 60
    else:
        result[2] += T//10
        T -= (T//10) * 10

if(T==0): print(result[0], result[1], result[2])
else:print(-1)