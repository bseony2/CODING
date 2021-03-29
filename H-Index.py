def solution(citations):
    citations.sort()
    l = len(citations)
    for i in range(l):
        if citations[i] >= l-i:
            return l-i
    return 0




# c = [4,2,1 , 5, 7]	

# c.sort(reverse =True)

# print(c)
# temp = 0
# temp2 =[]
# for i in c:
#     if temp > i :
#         print(temp)
#     elif temp ==i :
#         print(temp)
#     temp+=1
# print(temp)