from itertools import permutations
import math

def solution(numbers):
    answer = []
    for i in range(1, len(numbers)+1):              
        array = list(permutations(numbers, i))
        for j in range(len(array)):
            temp = int("".join(map(str, array[j])))
            if(isPrime(temp)):answer.append(temp)
    return len(set(answer))




def isPrime(n):
    if(n==0 or n==1) : return False
    result = True
    for i in range(2, int(math.sqrt(n)+1)):
        if(n%i==0) : return False
    return result




numbers = "352"
print(solution(numbers))