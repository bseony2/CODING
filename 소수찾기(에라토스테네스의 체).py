import math

# 해당 수의 제곱근까지 나누기를 시도해 소수를 판별하는 함수(하나의 수에 대해 소수인지 판별)
def is_prime_number(n):
    for i in range(2, int(math.sqrt(n))+1):   # 2부터 x의 제곱근까지의 모든 수를 확인하며
        if n % i == 0:  # x가 해당 수로 나누어 떨어진다면
            return False
    return True

#에라토스테네스의 체 사용 (범위가 주어지고 그 범위내의 소수 찾기)
def prime_list(n):
    sieve = [True] * n  # 에라토스테네스의 체 초기화: n개 요소에 True 설정(소수로 간주)
    for i in range(2, math.sqrt(n)+1):  # n의 최대 약수가 sqrt(n) 이하이므로 i=sqrt(n)까지 검사
        if sieve[i] == True:           # i가 소수인 경우 i의 배수들은 소수가 아님
            for j in range(i+i, n, i): # i이후 i의 배수들을 False 바꿈(소수가 아님)
                sieve[j] = False
# 소수 목록 산출
    return [i for i in range(2, n) if sieve[i] == True] #해당 리스트에서 값이 True인 값(소수)만 반환


# 위 코드는 O(n^(1/2))
# 아래는 O(nloglogn)