import java.io.*;
import java.util.*;
public class k개의벽없애기 {

	static int N, K;
	static int[][] map;
	static List<int[]> walls = new ArrayList<>();	// 격자의 벽 부분을 따로 모아둠
	static int ans = Integer.MAX_VALUE;
	static private final int WALL = 1;
	static private final int BLANK = 0;
	static int startR, startC, endR, endC;	// 시작점과 도착점 위치
	static boolean[][] isVisited;	// bfs에서 사용할 방문여부
	static int[][] distance;		// bfs에서 사용할 거리값
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		init();

		dfs(0, 0, new boolean[walls.size()]);
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		distance = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == WALL)
					walls.add(new int[] { i, j });
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;

		st = new StringTokenizer(br.readLine(), " ");
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
	}

	static void dfs(int depth, int start, boolean[] dfsIsVisited) {
		if (depth == K) {
			bfs();
			// 도착점까지 도달할 수 있었으며 그 거리가 현재 최소거리보다 짧을경우
			if(isVisited[endR][endC] && distance[endR][endC] < ans) {
				ans = distance[endR][endC];
			}
			return;
		}
		// 격자 내의 벽의 개수(walls의 크기) 중에서 K 개를 뽑는 조합을 dfs로 구현
		for (int i = start; i < dfsIsVisited.length; i++) {
			if (!dfsIsVisited[i]) {
				int[] wall = walls.get(i);

				dfsIsVisited[i] = true;
				map[wall[0]][wall[1]] = BLANK;

				dfs(depth + 1, i + 1, dfsIsVisited);

				dfsIsVisited[i] = false;
				map[wall[0]][wall[1]] = WALL;
			}
		}
	}

	static void bfs() {
		for (int i = 0; i < N; i++) {	// 전역설정한 변수들 초기화
			Arrays.fill(isVisited[i], false);
			Arrays.fill(distance[i], 0);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startR);
		queue.add(startC);
		isVisited[startR][startC] = true;

		while (!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();
			if(distance[r][c] == ans) return;
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(canGo(nr, nc)) {
					isVisited[nr][nc] = true;
					distance[nr][nc] = distance[r][c] + 1;
					if(isDestination(nr, nc)) return;
					queue.add(nr); queue.add(nc);
				}
			}
		}

		return;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	static boolean canGo(int r, int c) {
		return isValidPoint(r, c) && !isVisited[r][c] && map[r][c] == BLANK;
	}
	
	static boolean isDestination(int r, int c) {
		return endR == r && endC == c;
	}
}
