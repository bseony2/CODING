//BOJ : 11403
import java.util.*;
import java.io.*;

public class 경로찾기 {

	static int N;
	static int[][] map;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		init();

		bfs();

		print();
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				if (value == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			int r = point[0];
			int c = point[1];

			for (int i = 0; i < N; i++) {
				if (map[i][r] == 1 && map[i][c] == 0) {
					map[i][c] = 1;
					queue.add(new int[] { i, c });
				}
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
