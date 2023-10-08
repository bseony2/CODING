import java.io.*;
import java.util.*;
import java.lang.Math;
public class 숫자를적절하게고르기 {

	static int N;
	static int[] numbers;
	static int ans = Integer.MAX_VALUE;
	static int total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.peek(n -> total += n)
					.toArray();
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int depth, int start, int sum) {
		if(depth == N) {
			int diff = Math.abs(total-2*sum);	// 선택된 N개의 숫자합과 선택되지 않은 N개의 숫자합의 차이 => (total - sum) - sum
			ans = Math.min(ans, diff);			// 차이가 더 적은 값으로 변
			return;
		}
		// 조합(combination) 개념으로코드를 짜지만원시코드의 특성을 이용해 sum을 사용하므로 굳이 isVisited를 사용할 필요가 없
		for(int i = start; i<2*N; i++) {
			dfs(depth + 1, i+1, sum + numbers[i]);
		}
	}

}
