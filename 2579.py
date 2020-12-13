n = int(input())
stair = [0]
for _ in range(n):
    stair.append(int(input()))

if n ==1 : print(stair[1])
else:
    dp = [0] * (n+1)
    dp[1] = stair[1]
    dp[2] = dp[1] + stair[2]

    for i in range(3, n+1):
        dp[i] = max(dp[i-3] + stair[i - 1] + stair[i], dp[i-2] + stair[i])
    print(dp[-1])
    
#런타임 에러는 계단이 하나만 있을 경우를 생각 안 해서;;