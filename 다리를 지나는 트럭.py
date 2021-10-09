
def solution(bridge_length, weight, truck_weights):
    answer = 0
    onBridge = []
    truck_weights.reverse()
    while(truck_weights):
        onBridge = list(filter(lambda x: x[1] < bridge_length, onBridge))
        answer = answer + 1
        if( ( sum(map(lambda x : x[0], onBridge)) + truck_weights[-1] <= weight) ) : 
            onBridge.append([truck_weights.pop(), 0])

        for i in onBridge:
            i[1] = i[1] + 1
        
    return answer + bridge_length

print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10]))
print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))
