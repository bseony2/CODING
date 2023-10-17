import java.io.*;
import java.util.*;

public class 루프탈출 {
	static int n;
	static int[] dir;

	public static void main(String[] args) throws IOException {
		init();

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			if (!isLoop(i))
				ans += 1;
		}
		System.out.println(ans);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dir = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dir[i] = Integer.parseInt(br.readLine());
		}
	}

	static boolean isLoop(int v) {
		boolean[] isVisited = new boolean[n + 1];
		isVisited[v] = true;

		while (true) {
			int next = dir[v];
			if (next == 0)
				return false;
			if (isVisited[next] == true)
				return true;
			
			isVisited[next] = true;
			v = next;
		}
	}
}
