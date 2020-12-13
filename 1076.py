import sys
input = sys.stdin.readline

dic = {'black':0, 'brown':1, 'red':2, 'orange':3, 'yellow':4, 'green':5, 'blue':6, 'violet':7, 'grey':8, 'white':9}

A = input().strip('\n')
B = input().strip('\n')
C = input().strip('\n')

print((10*dic[A]+dic[B])* 10**dic[C])