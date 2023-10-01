import java.io.*;

public class 점프 {
	static int[][] map;
	static long[][] dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());
		
		int[][] map;
		map = new int[N][N];
		
		long[][] dp;
		dp = new long[N][N];
		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int d = map[i][j];

				if (d == 0)
					continue;

				if (j + d < N) {
					dp[i][j + d] += dp[i][j];
				}

				if (i + d < N) {
					dp[i + d][j] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}

}
