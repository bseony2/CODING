import java.io.*;
import java.util.*;
public class 격자밟기 {

	static char[][] originMap = new char[5][5];
	static int ans = 0;
	static int[] dr = new int[]{-1, 0, 1, 0};
	static int[] dc = new int[]{0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		init();

		backtracking(0, 0, 4, 4, originMap);

		System.out.println(ans);
	}

	static void init() throws IOException {
		for (int i = 0; i < 5; i++) {
			Arrays.fill(originMap[i], '.');
		}
		originMap[0][0] = 'A';
		originMap[4][4] = 'B';

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			originMap[r][c] = 'x';

		}
	}

	static void backtracking(int Ar, int Ac, int Br, int Bc,
			char[][] originMap) {
		originMap[Ar][Ac] = 'x';
		originMap[Br][Bc] = 'x';

		if (Ar == Br && Ac == Bc) {
			check(originMap);
			return;
		}

		if (!isMovAble(originMap, Ar, Ac) || !isMovAble(originMap, Br, Bc)) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int nextAr = Ar + dr[i];
				int nextAc = Ac + dc[i];
				int nextBr = Br + dr[j];
				int nextBc = Bc + dc[j];

				if (canGo(originMap, nextAr, nextAc) && canGo(originMap, nextBr, nextBc)) {
					backtracking(nextAr, nextAc, nextBr, nextBc, copyMap(originMap));
				}
			}
		}
	}

	static char[][] copyMap(char[][] copyMap) {
		char[][] result = new char[5][5];
		for (int i = 0; i < 5; i++) {
			result[i] = copyMap[i].clone();
		}
		return result;
	}

	static void check(char[][] map) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] != 'x')
					return;
			}
		}

		ans += 1;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < 5 && 0 <= c && c < 5;
	}

	static boolean canGo(char[][] map, int r, int c) {
		return isValidPoint(r, c) && map[r][c] != 'x';
	}

	static boolean isMovAble(char[][] map, int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (canGo(map, nr, nc))
				return true;
		}

		return false;
	}

}
