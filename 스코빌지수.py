import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while(True):
        lowest = heapq.heappop(scoville)
        if(lowest >= K): break
        if(len(scoville) <= 0):
            return -1
        heapq.heappush(scoville, lowest + (heapq.heappop(scoville) * 2))
        answer += 1
    return answer

print(solution([1, 2, 3, 9, 10, 12], 7))