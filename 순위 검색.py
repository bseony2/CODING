from itertools import combinations

def solution(info, query) : 
    answer =[]
    dic = {}
    
    for i in info : 
        string_list = i.split(' ')
        score = int(string_list[-1])
        string = string_list[:4]

        for n in range(5) : 
            combi = combinations(range(4), n)
            for c in combi : 
                tmpString = string.copy()
                for v in c :
                    tmpString[v] = '-'
                tmpString = ''.join(tmpString)
                if tmpString in dic : 
                    dic[tmpString].append(score)
                else : dic[tmpString] = [score]
    
    for value in dic.values() : 
        value.sort()

    for q in query : 
        stringList = [i for i in q.split(' ') if i != 'and']
        score = int(stringList[-1])
        string = ''.join(stringList[:4])

        if string in dic : 
            data = dic[string]
            left, right = 0, len(data)

            while left != right and left != len(data) : 
                if data[(left + right) // 2] >= score : 
                    right = (left + right) // 2
                else : 
                    left = ((left + right) // 2) + 1
            
            answer.append(len(data) - left)

        else : 
            answer.append(0)
    return answer

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"], ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))


# 가장 출시자의 기대에 부응했을거 같은 코드
# def solution(info, query):
#     data = dict()
#     for a in ['cpp', 'java', 'python', '-']:
#         for b in ['backend', 'frontend', '-']:
#             for c in ['junior', 'senior', '-']:
#                 for d in ['chicken', 'pizza', '-']:
#                     data.setdefault((a, b, c, d), list())
#     for i in info:
#         i = i.split()
#         for a in [i[0], '-']:
#             for b in [i[1], '-']:
#                 for c in [i[2], '-']:
#                     for d in [i[3], '-']:
#                         data[(a, b, c, d)].append(int(i[4]))

#     for k in data:
#         data[k].sort()

#         # print(k, data[k])

#     answer = list()
#     for q in query:
#         q = q.split()

#         pool = data[(q[0], q[2], q[4], q[6])]
#         find = int(q[7])
#         l = 0
#         r = len(pool)
#         mid = 0
#         while l < r:
#             mid = (r+l)//2
#             if pool[mid] >= find:
#                 r = mid
#             else:
#                 l = mid+1
#             # print(l, r, mid, answer)
#         # answer.append((pool, find, mid))
#         answer.append(len(pool)-l)

#     return answer