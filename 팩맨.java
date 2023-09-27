import java.util.*;
import java.io.*;

public class 팩맨 {
	static int[][][] map = new int[4][4][8], eggs = new int[4][4][8];
	static int packmanR, packmanC;
	static int[] dr = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] dead = new int[4][4];
	static int T, M, turn = 0;
	static List<int[]> totalMove = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		init();

		simulate();

		System.out.println(count());
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		packmanR = Integer.parseInt(st.nextToken()) - 1;
		packmanC = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			map[r][c][d] += 1;
		}
		perm(0, new int[3]);
	}

	static void perm(int depth, int[] result) {
		if (depth == 3) {
			totalMove.add(result.clone());
			return;
		}

		for (int i = 0; i < 8; i += 2) {
			result[depth] = i;
			perm(depth + 1, result);
		}
	}

	static void simulate() {

		while (++turn <= T) {
			copyMonster();

			monsterMove();

			packManMove();

			deadBodyRemove();

			monsterBorn();
		}
	}

	static void copyMonster() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 8; d++) {
					eggs[i][j][d] = map[i][j][d];
				}
			}
		}
	}

	static void monsterMove() {
		int[][][] newMap = new int[4][4][8];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 8; d++) {
					boolean isMove = false;
					if (map[i][j][d] == 0)
						continue;

					for (int k = 0; k < 8; k++) {
						int nd = (d + k) % 8;
						int nr = i + dr[nd];
						int nc = j + dc[nd];

						if (!isValidPoint(nr, nc) || dead[nr][nc] > 0 || isPackMan(nr, nc))
							continue;

						newMap[nr][nc][nd] += map[i][j][d];
						isMove = true;
						break;
					}
					
					if(!isMove) newMap[i][j][d] += map[i][j][d];

				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 8; d++) {
					map[i][j][d] = newMap[i][j][d];
				}
			}
		}
	}

	static void packManMove() {
		int[] selectedMove = selectPackmanMove();

		for (int d : selectedMove) {
			int nr = packmanR + dr[d];
			int nc = packmanC + dc[d];

			if (getMonsterNum(nr, nc) > 0) {
				dead[nr][nc] = 3;
				eatMonster(nr, nc);
			}

			packmanR = nr;
			packmanC = nc;
		}
	}

	static int[] selectPackmanMove() {
		int[] result = null;
		int monsterNum = -1;

		for (int[] move : totalMove) {
			int num = 0;
			boolean isMoveAble = true;
			int r = packmanR;
			int c = packmanC;
			boolean[][] isVisited = new boolean[4][4];

			for (int d : move) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!isValidPoint(nr, nc)) {
					isMoveAble = false;
					break;
				}

				if (!isVisited[nr][nc]) {
					num += getMonsterNum(nr, nc);
				}

				r = nr;
				c = nc;
				isVisited[nr][nc] = true;
			}

			if (!isMoveAble)
				continue;

			if (num > monsterNum) {
				monsterNum = num;
				result = move;
			}
		}

		return result;
	}

	static int getMonsterNum(int r, int c) {
		return Arrays.stream(map[r][c]).sum();
	}

	static void eatMonster(int r, int c) {
		Arrays.fill(map[r][c], 0);
	}

	static void deadBodyRemove() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (dead[i][j] > 0)
					dead[i][j] -= 1;
			}
		}
	}

	static void monsterBorn() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 8; d++) {
					map[i][j][d] += eggs[i][j][d];
					eggs[i][j][d] = 0;
				}
			}
		}
	}

	static int count() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < 8; d++) {
					result += map[i][j][d];
				}
			}
		}
		return result;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < 4 && 0 <= c && c < 4;
	}

	static boolean isPackMan(int r, int c) {
		return r == packmanR && c == packmanC;
	}
}
