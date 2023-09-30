import java.io.*;

public class 극장좌석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int ans = 1;

		int beforeSeat = 0;
		for (int i = 0; i < M; i++) {
			int vipSeatnum = Integer.parseInt(br.readLine());
			ans *= dp[vipSeatnum - beforeSeat - 1];
			beforeSeat = vipSeatnum;
		}
		ans *= dp[N - beforeSeat];

		System.out.println(ans);
	}
}
