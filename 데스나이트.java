import java.io.*;
import java.util.*;

public class 데스나이트 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int destR = Integer.parseInt(st.nextToken());
		int destC = Integer.parseInt(st.nextToken());

		boolean[][] isVisited = new boolean[N][N];
		int[][] distance = new int[N][N];
		int[] dr = new int[] { -2, -2, 0, 0, 2, 2 };
		int[] dc = new int[] { -1, 1, -2, 2, -1, 1 };

		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);
		queue.add(c);
		isVisited[r][c] = true;

		boolean isDone = false;
		while (!queue.isEmpty()) {
			int cr = queue.poll();
			int cc = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(!isValidPoint(nr, nc) || isVisited[nr][nc]) continue;
				
				distance[nr][nc] = distance[cr][cc] + 1;
				isVisited[nr][nc] = true;
				queue.add(nr);
				queue.add(nc);
			}
			if(isDone) break;
		}
		System.out.println(isVisited[destR][destC] ? distance[destR][destC] : -1);
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
