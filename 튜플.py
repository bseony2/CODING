from collections import deque
def solution(s):

    s.replace(',', '')
    answer = []
    stack_1 = deque(list(s)); temp=[]; s=[]; tmp=""
    while(stack_1) :
        select = stack_1.popleft()
        if select.isdigit() : tmp += select
        elif (select ==',') and (len(tmp)!= 0) :
            temp.append(int(tmp))
            tmp =""
        elif select == "}" :
            if tmp == "" : break
            temp.append(int(tmp))
            s.append(temp)
            temp =[]
            tmp =""
        else : continue
    
    s.sort(key=len)
    for array in s :
        for an in answer:
            array.remove(an)
        answer.append(array[0])

    return answer

print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))


print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))

####################################
#       깔끔한 다른사람 코드       #
###################################
# def solution(s):
#     answer = []

#     s1 = s.lstrip('{').rstrip('}')
#     s2 = s1.split('},{')

#     new_s = []
#     for i in s2:
#         new_s.append(i.split(','))

#     new_s.sort(key = len)

#     for i in new_s:
#         for j in range(len(i)):
#             if int(i[j]) not in answer:
#                 answer.append(int(i[j]))

#     return answer