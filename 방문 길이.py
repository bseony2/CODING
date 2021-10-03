def solution(dirs):
    dirs = list(dirs)
    current_coord = [0, 0]
    road = set()

    for dir in dirs:
        if dir == "U" and current_coord[1] < 5:
            road.add((tuple(current_coord), tuple([current_coord[0], current_coord[1]+1])))
            road.add((tuple([current_coord[0], current_coord[1]+1]), tuple(current_coord)))
            current_coord[1] = current_coord[1] + 1
        elif dir == "D" and current_coord[1]>-5:
            road.add((tuple(current_coord),tuple([current_coord[0], current_coord[1]-1])))
            road.add((tuple([current_coord[0], current_coord[1]-1]), tuple(current_coord)))
            current_coord[1] = current_coord[1] - 1
        elif dir == "L" and current_coord[0]>-5:
            road.add((tuple(current_coord),tuple([current_coord[0]-1, current_coord[1]])))
            road.add((tuple([current_coord[0]-1, current_coord[1]]), tuple(current_coord)))
            current_coord[0] = current_coord[0] - 1
        elif dir == "R" and current_coord[0]<5:
            road.add((tuple(current_coord),tuple([current_coord[0]+1, current_coord[1]])))
            road.add((tuple([current_coord[0]+1, current_coord[1]]), tuple(current_coord)))
            current_coord[0] = current_coord[0] + 1
        else : continue

    return len(road)/2

print(solution("ULURRDLLU"))

#
# def solution(dirs):
#     s = set()
#     d = {'U': (0,1), 'D': (0, -1), 'R': (1, 0), 'L': (-1, 0)}
#     x, y = 0, 0
#     for i in dirs:
#         nx, ny = x + d[i][0], y + d[i][1]
#         if -5 <= nx <= 5 and -5 <= ny <= 5:
#             s.add((x,y,nx,ny))
#             s.add((nx,ny,x,y))
#             x, y = nx, ny
#     return len(s)//2