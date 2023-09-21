import java.util.*;
import java.io.*;

public class 디버깅 {
	static int N, M, H;
	static int[][] web;
	static List<int[]> weakPoints = new ArrayList<>();
	static final int RIGHT = 1;
	static final int LEFT = 2;
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		init();

		if (check()) {
			ans = 0;
		}
		for (int i = 0; i <= 3; i++) {
			if (ans != -1)
				break;
			comb(0, 0, i, new boolean[weakPoints.size()]);
		}

		System.out.println(ans);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		web = new int[H][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			web[a][b] = 1;
			web[a][b + 1] = 2;
		}

		for (int i = 0; i < web.length; i++) {
			for (int j = 0; j < web[0].length - 1; j++) {
				if (!existLine(i, j) && !existLine(i, j + 1)) {
					weakPoints.add(new int[] { i, j });
				}
			}
		}
	}

	static void comb(int depth, int start, int max, boolean[] isVisited) {
		if (ans != -1) {
			return;
		}
		if (depth == max) {
			if (check()) {
				ans = max;
			}
			return;
		}

		for (int i = start; i < isVisited.length; i++) {
			if (isVisited[i]) {
				continue;
			}

			int[] point = weakPoints.get(i);
			int r = point[0];
			int c = point[1];
			if (existLine(r, c) || existLine(r, c + 1))
				continue;

			isVisited[i] = true;
			web[r][c] = RIGHT;
			web[r][c + 1] = LEFT;

			comb(depth + 1, i + 1, max, isVisited);

			isVisited[i] = false;
			web[r][c] = 0;
			web[r][c + 1] = 0;
		}
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			if (!isRight(i)) {
				return false;
			}
		}

		return true;
	}

	static boolean isRight(int num) {
		int r = H - 1;
		int c = num;

		while (r != -1) {
			if (existLine(r, c)) {
				if (web[r][c] == RIGHT) {
					c += 1;
				} else {
					c -= 1;
				}
			}
			r -= 1;
		}

		return c == num;
	}

	static boolean existLine(int r, int c) {
		return web[r][c] > 0;
	}
}
