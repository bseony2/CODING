from collections import deque

def solution(n, edge):
    graph = [[] for row in range(n+1)] # 그래프로 만들기
    for e in edge:
        graph[e[0]].append(e[1]);graph[e[1]].append(e[0])

    result = [-1 for _ in range(n+1)] # 1번 노드와의 거리를 표현하는 배열
    result[1] = 0

    need_visit = deque()
    need_visit.append(1)
    while(need_visit):
        node = need_visit.popleft()
        
        for i in graph[node]:
            if result[i]==-1 : 
                result[i] = result[node] + 1
                need_visit.append(i)
    
    answer = result.count(max(result))
    return answer
# -------------------------------------------------------







#시간 초과 난 코드
# def solution(n, edge):
#     graph = [[0 for col in range(n+1)] for row in range(n+1)] # 그래프로 만들기
#     for e in edge:
#         graph[e[0]][e[1]], graph[e[1]][e[0]] = 1, 1

#     result = [None for _ in range(n+1)] # 1번 노드와의 거리를 표현하는 배열
#     for i in range(2, n+1):
#         if(graph[1][i] == 1) : result[i] = 1

#     visited = [] #한번 들린 노드는 탐색할 필요 없음
#     for i in range(2, n+1): #각 노드들 탐색해야 함
#         select = 20001 #이번에 탐색을 할 노드
#         for i in range(2, n+1) :  #현 상황에서 노드 1과 거리가 가장 짧은(들리지 않은 노드 중) 노드 선택
#             if(result[i] == None) : continue
#             if(select ==20001 and i in visited):
#                 continue
#             elif(select == 20001 and i not in visited):
#                 select = i
#                 continue
#             if(i not in visited and result[select]>result[i]) : select = i
        
#         visited.append(select)
#         node = graph[select]
#         for i in range(2, n+1):
#             if(result[i] == None and node[i] == 1) : result[i] = result[select] + 1
    
#     for i in range(len(result)):
#         if(result[i] == None) : result[i] = 0
#     answer = result.count(max(result))
#     return answer

# 느려서 실패한 코드 2  
# from collections import deque

# def solution(n, edge):
#     graph = [[] for row in range(n+1)] # 그래프로 만들기
#     for e in edge:
#         graph[e[0]].append(e[1]);graph[e[1]].append(e[0])

#     result = [-1 for _ in range(n+1)] # 1번 노드와의 거리를 표현하는 배열
#     result[1] = 0

#     visited = [] # 탐색을 했던 코드
#     need_visit = deque()
#     need_visit.append(1)
#     while(need_visit):
#         node = need_visit.popleft()
#         if(node in visited) : continue
#         visited.append(node)
#         need_visit.extend(graph[node])
        
#         for i in graph[node]:
#             if result[i]==-1 : result[i] = result[node] + 1
    
#     answer = result.count(max(result))
#     return answer


#----------------------------------------------------------
# 상범이 코드
# from collections import deque

# def solution(n,vertex):
#     def bfs():
#         de = deque()
#         de.append(1)

#         while de :
#             x = de.popleft()
#             for i in a[x]:
#                 if ch[i]==-1:
#                     ch[i]=ch[x]+1
#                     de.append(i)

#     a=[[] for i in range(n+1)]
#     ch=[-1]*(n+1)

#     for i,j in vertex:
#         a[i].append(j)
#         a[j].append(i)
    
#     ch[1]=0
#     bfs()
#     return ch.count(max(ch))

# print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))