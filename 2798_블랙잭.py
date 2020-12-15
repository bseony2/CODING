import sys
input = sys.stdin.readline

n, m = map(int, input().split(' '))
card = list(map(int, input().split(' ')))

result = 0

for a in range(n-2):
    if result == m : break
    for b in range(a+1, n - 1):
        if result == m : break
        for c in range(b + 1, n):
            if card[a] + card[b] + card[c] <= m:
                result = max(result, card[a] + card[b] + card[c])
            if result == m : break

print(result)