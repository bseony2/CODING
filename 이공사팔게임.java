import java.io.*;
import java.util.*;
import java.lang.Math;

public class 이공사팔게임 {
	static int N;
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] initMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				initMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, initMap);

		System.out.println(ans);
	}

	static public void dfs(int depth, int[][] map) {
		if (depth == 5) {
			ans = Math.max(ans, count(map));
			return;
		}

		for (int i = 0; i < 4; i++) {
			dfs(depth + 1, move(mapcopy(map), i));
		}
	}

	static int[][] move(int[][] map, int d) {
		switch (d) {
		case 0: {
			moveUp(map);
			break;
		}
		case 1: {
			moveRight(map);
			break;
		}
		case 2: {
			moveDown(map);
			break;
		}
		case 3: {
			moveLeft(map);
			break;
		}
		}
		return map;
	}

	static void moveUp(int[][] map) {
		boolean[][] isDup = new boolean[N][N];
		for (int c = 0; c < N; c++) {
			for (int r = 1; r < N; r++) {
				if (map[r][c] != 0) {
					int cr = r;
					while (true) {
						int nr = cr - 1;
						if (nr < 0)
							break;

						if (map[nr][c] == 0) {
							map[nr][c] = map[cr][c];
							map[cr][c] = 0;
							cr -= 1;
						} else {
							if (map[nr][c] == map[cr][c] && !isDup[nr][c]) {
								isDup[nr][c] = true;
								map[nr][c] *= 2;
								map[cr][c] = 0;
							}
							break;
						}
					}
				}
			}
		}
	}

	static void moveRight(int[][] map) {
		boolean[][] isDup = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = N - 2; c >= 0; c--) {
				if (map[r][c] != 0) {
					int cc = c;
					while (true) {
						int nc = cc + 1;
						if (nc == N)
							break;

						if (map[r][nc] == 0) {
							map[r][nc] = map[r][cc];
							map[r][cc] = 0;
							cc += 1;
						} else {
							if (map[r][nc] == map[r][cc] && !isDup[r][nc]) {
								isDup[r][nc] = true;
								map[r][nc] *= 2;
								map[r][cc] = 0;
							}
							break;
						}
					}
				}
			}
		}
	}

	static void moveDown(int[][] map) {
		boolean[][] isDup = new boolean[N][N];
		for (int c = 0; c < N; c++) {
			for (int r = N - 2; r >= 0; r--) {
				if (map[r][c] != 0) {
					int cr = r;
					while (true) {
						int nr = cr + 1;
						if (nr == N)
							break;

						if (map[nr][c] == 0) {
							map[nr][c] = map[cr][c];
							map[cr][c] = 0;
							cr += 1;
						} else {
							if (map[nr][c] == map[cr][c] && !isDup[nr][c]) {
								isDup[nr][c] = true;
								map[nr][c] *= 2;
								map[cr][c] = 0;
							}
							break;
						}
					}
				}
			}
		}
	}

	static void moveLeft(int[][] map) {
		boolean[][] isDup = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 1; c < N; c++) {
				if (map[r][c] != 0) {
					int cc = c;
					while (true) {
						int nc = cc - 1;
						if (nc == -1)
							break;

						if (map[r][nc] == 0) {
							map[r][nc] = map[r][cc];
							map[r][cc] = 0;
							cc -= 1;
						} else {
							if (map[r][nc] == map[r][cc] && !isDup[r][nc]) {
								isDup[r][nc] = true;
								map[r][nc] *= 2;
								map[r][cc] = 0;
							}
							break;
						}
					}
				}
			}
		}
	}

	static int[][] mapcopy(int[][] origin) {
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			result[i] = origin[i].clone();
		}
		return result;
	}

	static int count(int[][] map) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result, map[i][j]);
			}
		}
		return result;
	}

}
