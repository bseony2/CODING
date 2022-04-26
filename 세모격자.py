def solution(grid) : 
	global graph
	global height
	global width
	answer = 0
	graph = []
	height = len(grid)
	width  = 2*height - 1

	for i in grid : 
		temp = list(i)
		temp.extend([False]*(width-len(i)))
		graph.append(temp)
	
	for i in range(height) : 
		result = move(i, 0, 'l', True)
		answer = max(result, answer)

		result = move(i, i * 2, 'r', True)
		answer = max(result, answer)
	for i in range(0, width, 2) : 
		result = move(height - 1, i, 'd', True)
		answer = max(result, answer)
	return answer

def move(y, x, way, triangle) : #x, y 좌표, 들어온 방향, 삼각형 형태(true면 정상 False면 거꾸로 된 삼각형)
	possible = True
	result = 0
	while(possible) : 
		result += 1
		if(triangle) : 
			if(graph[y][x] == 'R') : #해당 삼각형이 빨간색
				if(way == 'r') : #오른쪽 방향에서 들어옴 => 왼쪽으로 이동
					ny, nx, way = moveLeft(y, x)
				elif(way == 'l') : #왼쪽 방향에서 들어옴 => 우측, 아래로 이동
					ny, nx , way = moveDown(y, x)
				else : #아래쪽 방향에서 들어옴 => 우측으로 이동
					ny, nx , way = moveRight(y, x)

			else : #해당 삼각형이 파란색
				if(way == 'r') : #오른쪽 방향에서 들어옴 => 오른쪽 아래
					ny, nx , way = moveDown(y, x)
				elif(way == 'l') : #왼쪽 방향에서 들어옴 => 오른쪽
					ny, nx, way = moveRight(y, x)
				else : #아래쪽 방향에서 들어옴 => 왼쪽
					ny, nx, way = moveLeft(y, x)

		else : #거꾸로 된 삼각형
			if(graph[y][x] == 'R') : #해당 삼각형이 빨간색
				if(way == 'r') : #오른쪽 방향에서 들어옴 => 왼쪽 위
					ny, nx, way = moveUp(y, x)
				elif(way == 'l') : #왼쪽 방향에서 들어옴 => 오른쪽
					ny, nx, way = moveRight(y, x)
				else : #위쪽 방향에서 들어옴 => 왼쪽
					ny, nx, way = moveLeft(y, x)

			else : #해당 삼각형이 파란색
				if(way == 'r') : #오른쪽 방향에서 들어옴 => 왼쪽
					ny, nx, way = moveLeft(y, x)
				elif(way == 'l') : #왼쪽 방향에서 들어옴 => 왼쪽 위
					ny, nx, way = moveUp(y, x)
				else : #위쪽 방향에서 들어옴 => 오른쪽
					ny, nx, way = moveRight(y, x)
		if( ny == -1 or ny == height or nx == -1 or nx == width or graph[ny][nx] == False ) : #출구 찾아서 나가는 경우
			possible = False
		else : 
			y, x = ny, nx
			triangle = not triangle
	return result

def moveUp(y, x) : 
	return y - 1, x - 1, 'd'
def moveDown(y, x) : 
	return y + 1, x + 1, 'u'
def moveRight(y, x) : 
	return y, x + 1, 'l'
def moveLeft(y, x) : 
	return y, x-1, 'r'
print(solution(["R", "RRR", "RBBBB", "BRRRBRR"]))