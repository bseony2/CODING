import heapq

graph ={
    'A':{'B':8, 'C':1, 'D':2},
    'B':{},
    'C':{'B':5, 'D':2},
    'D':{'E':3, 'F':5},
    'E':{'F':1},
    'F':{'A':5}
}

def dijkstra(graph, start):
    distances = {node:float('inf') for node in graph}
    distances[start] = 0
    queue = []

    heapq.heappush(queue, [distances[start], start])

    while(queue):


        
        current_distance, current_node = heapq.heappop(queue)

        if (distances[current_node] < current_distance) : continue

        for adjacent, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[adjacent] :
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])

# all in https://velog.io/@bseony2/%EC%B5%9C%EB%8B%A8%EA%B2%BD%EB%A1%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BCdijkstra%ED%8C%8C%EC%9D%B4%EC%8D%AC