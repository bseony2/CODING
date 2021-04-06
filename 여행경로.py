def solution(tickets):
    graph = {}
    for t in tickets:
        d, a = t[0], t[1]
        if(d not in graph.keys()):
            graph[d] =[]
            graph[d].append(a)
        else : graph[d].append(a)
    for g in graph:
        graph[g].sort(reverse = True)
    answer = dfs(graph, "ICN")
    return answer
    
def dfs(graph, start):
    stack = [start]
    answer = []
    print(graph.keys())
    while(stack):
        top = stack[-1]
        if(top not in graph.keys() or len(graph[top]) == 0) : answer.append(stack.pop())
        else : stack.append(graph[top].pop())
    return answer[::-1]


print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))