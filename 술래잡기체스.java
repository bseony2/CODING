import java.io.*;
import java.util.*;
import java.lang.Math;
public class 술래잡기체스 {

	static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
	static int[][] initMap = new int[4][4];
	static int[] initD = new int[17];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		init();

		simulate(0, 0, 0, initMap, initD);

		System.out.println(ans);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int value = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;

				initD[value] = d;
				initMap[i][j] = value;
			}
		}
	}

	static void simulate(int r, int c, int score, int[][] map,
			int[] directions) {
		int thief = map[r][c];
		map[r][c] = -1;
		score += thief;
		ans = Math.max(ans, score);
		directions[0] = directions[thief];

		thievesMove(map, directions);

		int d = directions[0];
		for (int i = 1; i < 4; i++) {
			int nr = r + dr[d] * i;
			int nc = c + dc[d] * i;

			if (isValidPoint(nr, nc) && map[nr][nc] > 0) {
				int[][] newMap = copymap(map);
				newMap[r][c] = 0;
				int[] newDirections = directions.clone();
				simulate(nr, nc, score, newMap, newDirections);
				directions[0] = d;
			}
		}

	}

	static void thievesMove(int[][] map, int[] directions) {
		for (int i = 1; i <= 16; i++) {
			int[] point = find(map, i);
			if (point[0] == -1)
				continue;
			int r = point[0];
			int c = point[1];

			for (int j = 0; j < 8; j++, directions[i] = (directions[i] + 1)
					% 8) {
				int nr = r + dr[directions[i]];
				int nc = c + dc[directions[i]];

				if (isValidPoint(nr, nc) && map[nr][nc] >= 0) {
					int next = map[nr][nc];
					map[nr][nc] = i;
					map[r][c] = next;
					break;
				}
			}
		}
	}

	static int[][] copymap(int[][] origin) {
		int[][] result = new int[4][4];

		for (int i = 0; i < 4; i++) {
			result[i] = origin[i].clone();
		}

		return result;
	}

	static int[] find(int[][] map, int index) {
		int[] result = new int[]{-1, -1};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == index) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < 4 && 0 <= c && c < 4;
	}
}
