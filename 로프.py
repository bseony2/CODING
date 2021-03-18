import sys
input = sys.stdin.readline

n = int(input())
rope = []
for i in range(n):
    rope.append(int(input()))
rope.sort(reverse = True)

for i in range(n):
    rope[i] = rope[i] * (i+1)
print(max(rope))














# import sys
# input = sys.stdin.readline

# n = int(input())
# rope = []
# for i in range(n):
#     rope.append(int(input()))
# rope.sort(reverse = True)

# result = 0
# for i in range(n):
#     power = rope[i] * (i+1)
#     if(power > result):
#         result = power
# print(result)
