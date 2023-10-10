// BOJ:6118
import java.io.*;
import java.util.*;

public class 숨바꼭질 {

	static int N, M;
	static int[] distance;
	static boolean[] isVisited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		init();

		bfs();

		int max = Arrays.stream(distance).max().getAsInt();

		int num = 0;

		int target = Integer.MAX_VALUE;

		for (int i = 2; i <= N; i++) {
			if (distance[i] == max) {
				num += 1;
				target = Math.min(target, i);
			}
		}

		System.out.println(target + " " + distance[target] + " " + num);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		isVisited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		isVisited[1] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : list[now]) {
				if (isVisited[next])
					continue;

				distance[next] = distance[now] + 1;
				queue.add(next);
				isVisited[next] = true;
			}
		}
	}
}
