import java.io.*;
import java.util.*;
public class 카약과강풍 {

	static int N, S, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[] teams = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < S; i++) {
			int team = Integer.parseInt(st.nextToken()) - 1;
			teams[team] -= 1;
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int team = Integer.parseInt(st.nextToken()) - 1;
			teams[team] += 1;
		}

		for (int i = 0; i < N; i++) {
			if (teams[i] == -1) {
				if (isValid(i - 1) && teams[i - 1] == 1) {
					teams[i] = 0;
					teams[i - 1] = 0;
				} else if (isValid(i + 1) && teams[i + 1] == 1) {
					teams[i] = 0;
					teams[i + 1] = 0;
				}
			}
		}

		System.out.println(Arrays.stream(teams).filter(value -> value == -1).count());

	}

	static boolean isValid(int v) {
		return 0 <= v && v < N;
	}
}
