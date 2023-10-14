import java.io.*;
import java.util.*;

public class 지름길 {
	static int N, D;
	static int[] road;
	static Map<Integer, List<int[]>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		init();

		for (int i = 0; i < D; i++) {
			if (i != 1) {
				road[i + 1] = Math.min(road[i] + 1, road[i + 1]);
			}

			if (!map.containsKey(i))
				continue;

			for (int[] now : map.get(i)) {
				int end = now[0];
				int distance = now[1];

				road[end] = Math.min(road[end], road[i] + distance);
			}
		}
		System.out.println(road[D]);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		road = new int[D + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (e > D)
				continue;

			if (!map.containsKey(s))
				map.put(s, new ArrayList<int[]>());

			map.get(s).add(new int[] { e, d });
		}

		for (int i = 0; i <= D; i++) {
			road[i] = i;
		}
	}
}
