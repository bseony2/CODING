import heapq
def solution(N, road, K):
    answer = 0
    graph = {node : {} for node in range(1, N+1)}
    for r in road:
        if r[1] in graph[r[0]].keys() and graph[r[0]][r[1]] < r[2] : continue
        graph[r[0]][r[1]] = r[2]
        graph[r[1]][r[0]] = r[2]

    distances = {node : float('inf') for node in range(1, N+1)}
    distances[1] = 0
    queue = []

    heapq.heappush(queue, [distances[1], 1])
    while(queue):
        current_distance, current_node = heapq.heappop(queue)

        if (distances[current_node] < current_distance) : continue

        for adjacent, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[adjacent] :
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])
    print(distances)
    for value in distances.values():
        if value <= K : answer+=1
    return answer

print(solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4))
