def solution(price, money, count):
    answer = (sum(range(count+1))) * price - money if (sum(range(count+1))) * price > money else 0
    return answer



# def solution(price, money, count):
#     answer = 0
#     total_price = (sum(range(count+1))) * price

#     if money < total_price : answer = total_price - money
#     else : answer = 0
#     return answer

# solution(3, 20, 4)
