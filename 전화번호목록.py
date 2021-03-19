
from itertools import combinations as c
def solution(phoneBook):
    answer = True
    sortedPB = sorted(phoneBook, key= len)
    for (a,b) in c( sortedPB,2):
        if a == b[:len(a)]:
            answer = False
            break
    return answer



#  def solution(phone_book):
#     answer = True
#     hash_map = {}
#     for phone_number in phone_book:
#         hash_map[phone_number] = 1
#     for phone_number in phone_book:
#         temp = ""
#         for number in phone_number:
#             temp += number
#             if temp in hash_map and temp != phone_number:
#                 answer = False
#                 break
#         if(answer==False) : break
#     return answer

print(solution(["119", "1195524421", "97674223"]))