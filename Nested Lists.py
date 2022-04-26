if __name__ == '__main__':
    result = []
    arr = []
    lowest = float('inf')
    second_lowest = float('inf')
    for _ in range(int(input())):
        name = input()
        score = float(input())
        arr.append([name, score])
        if(score < lowest) : 
            lowest, second_lowest = score, lowest
        if(lowest < score < second_lowest) : 
            second_lowest = score
    arr.sort(key = lambda x : x[0])
    for stu in arr : 
        if(stu[1] == second_lowest) : 
            print(stu[0])