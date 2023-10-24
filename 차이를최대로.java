import java.io.*;
import java.util.*;
public class 차이를최대로 {

	static int N;
	static int[] input;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		dfs(0, new boolean[N], new int[N]);

		System.out.println(ans);
	}

	static void dfs(int depth, boolean[] isVisited, int[] result) {
		if (depth == N) {
			int val = cal(result);
			ans = Math.max(ans, val);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isVisited[i]) continue;

			isVisited[i] = true;
			result[depth] = input[i];
			dfs(depth + 1, isVisited, result);
			isVisited[i] = false;
		}
	}

	static int cal(int[] arr) {
		int result = 0;

		for (int i = 0; i < N - 1; i++) {
			result += Math.abs(arr[i] - arr[i + 1]);
		}

		return result;
	}
}
