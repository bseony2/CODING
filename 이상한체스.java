import java.io.*;
import java.util.*;

public class 이상한체스
{
	static boolean[][] area;
	static int[][] initMap;
	static int N, M;
	static final int ENEMY = 6;
	static List<int[]> units = new ArrayList<>();
	static int[] directions;
	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, 1, 0, -1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		init();

		dfs(0, initMap);
		
		System.out.println(ans);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		initMap = new int[N][M];
		area = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				initMap[i][j] = value;
				if (ENEMY == value) {
					area[i][j] = true;
				} else if (isOurUnit(value)) {
					units.add(new int[] { i, j, value });
				}
			}
		}
	}
	
	static void dfs(int depth, int[][] originMap) {
		if(depth == units.size()) {
			count(originMap);
			return;
		}

		int[] unit = units.get(depth);
		int r = unit[0];
		int c = unit[1];
		int kind = unit[2];
		
		switch(kind) {
			case 1: {
				int[][] map = mapcopy(originMap);
				setRoad(r, c, 0, map);
				dfs(depth+1, map);
				
				int[][] map2 = mapcopy(originMap);
				setRoad(r, c, 1, map2);
				dfs(depth+1, map2);
				
				int[][] map3 = mapcopy(originMap);
				setRoad(r, c, 2, map3);
				dfs(depth+1, map3);
				
				int[][] map4 = mapcopy(originMap);
				setRoad(r, c, 3, map4);
				dfs(depth+1, map4);
				break;
			}
			case 2: {
				int[][] map = mapcopy(originMap);
				setRoad(r, c, 1, map);
				setRoad(r, c, 3, map);
				dfs(depth+1, map);
				
				int[][] map2 = mapcopy(originMap);
				setRoad(r, c, 0, map2);
				setRoad(r, c, 2, map2);
				dfs(depth+1, map2);
				break;
			}
			case 3: {
				int[][] map = mapcopy(originMap);
				setRoad(r, c, 0, map);
				setRoad(r, c, 1, map);
				dfs(depth+1, map);
				
				int[][] map2 = mapcopy(originMap);
				setRoad(r, c, 1, map2);
				setRoad(r, c, 2, map2);
				dfs(depth+1, map2);
				
				int[][] map3 = mapcopy(originMap);
				setRoad(r, c, 3, map3);
				setRoad(r, c, 2, map3);
				dfs(depth+1, map3);
				
				int[][] map4 = mapcopy(originMap);
				setRoad(r, c, 3, map4);
				setRoad(r, c, 0, map4);
				dfs(depth+1, map4);
				break;
			}
			case 4: {
				int[][] map = mapcopy(originMap);
				setRoad(r, c, 0, map);
				setRoad(r, c, 1, map);
				setRoad(r, c, 2, map);
				dfs(depth+1, map);
				
				int[][] map2 = mapcopy(originMap);
				setRoad(r, c, 1, map2);
				setRoad(r, c, 2, map2);
				setRoad(r, c, 3, map2);
				dfs(depth+1, map2);
				
				int[][] map3 = mapcopy(originMap);
				setRoad(r, c, 3, map3);
				setRoad(r, c, 2, map3);
				setRoad(r, c, 0, map3);
				dfs(depth+1, map3);
				
				int[][] map4 = mapcopy(originMap);
				setRoad(r, c, 3, map4);
				setRoad(r, c, 0, map4);
				setRoad(r, c, 1, map4);
				dfs(depth+1, map4);
				break;
			}
			case 5: {
				int[][] map = mapcopy(originMap);
				setRoad(r, c, 0, map);
				setRoad(r, c, 1, map);
				setRoad(r, c, 2, map);
				setRoad(r, c, 3, map);
				dfs(depth+1, map);
				break;
			}
		}
	}
	
	private static int[][] mapcopy(int[][] origin) {
		int[][] result = new int[N][M];
		
		for(int i=0; i<N; i++) {
			result[i] = origin[i].clone();
		}
		return result;
	}
	
	static int[][] setRoad(int r, int c, int d, int[][] map) {
		while (isValidPoint(r, c) && map[r][c] != ENEMY) {
			map[r][c] = -1;
			r += dr[d];
			c += dc[d];
		}
		return map;
	}
	
	private static void count(int[][] map) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		
		ans = ans < cnt ? ans : cnt;
	}

	static boolean isOurUnit(int v) {
		return 1 <= v && v < 6;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}
