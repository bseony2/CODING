import sys
input = sys.stdin.readline
n = int(input())
amount = 0

while(n>0):
    if(n%5 ==0) : 
        amount += n//5
        n=0
    else : 
        n-=3
        amount +=1

if(n==0) : print(amount)
else: print(-1)