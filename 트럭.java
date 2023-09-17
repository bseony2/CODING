import java.io.*;
import java.util.*;

public class 트럭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의 수
		int W = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중

		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();

		int time = 0;
		int totalWeight = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < W; i++) {
			bridge.add(0);
		}

		while (!bridge.isEmpty()) {
			time++;
			totalWeight -= bridge.poll();

			if (trucks.isEmpty())
				continue;

			if (trucks.peek() + totalWeight <= L) {
				totalWeight += trucks.peek();
				bridge.offer(trucks.poll());
			} else if (trucks.peek() + totalWeight > L) {
				bridge.offer(0);
			}
		}
		System.out.println(time);
	}
}
