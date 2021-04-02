def solution(brown, yellow):

    h = 1

    while(True):
        y = h**2
        b = 4*h+4
        w=h

        while(y <= yellow and b<=brown):
            if(b == brown and y == yellow):return [w+2, h+2]
            b += 2
            y += h
            w+=1
        h+=1

print(solution(24, 24))