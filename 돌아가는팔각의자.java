import java.util.*;
import java.io.*;
import java.lang.Math;

public class 돌아가는팔각의자 {
	static int[][] chairs = new int[4][8];
	static Queue<int[]> q = new LinkedList<>();
	static final int S = 1, N = 0;
	static int[] turnDir = new int[4];

	public static void main(String[] args) throws IOException {
		init();

		simulate();
		
		print();
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			chairs[i] = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
			
		}

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			q.add(new int[] { num, d });
		}
	}

	static void simulate() {
		while (!q.isEmpty()) {
			Arrays.fill(turnDir, 0);
			setTurnDir(q.poll());
			turn();
		}
	}

	static void setTurnDir(int[] info) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(info);

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int num = current[0];
			int d = current[1];
			turnDir[num] = d;
			
			if(isValidPoint(num-1) && hasNoPlan(num-1) && chairs[num-1][2] != chairs[num][6]) {
				queue.add(new int[] {num-1, d != 1 ? 1 : -1});
			}
			
			if(isValidPoint(num+1) && hasNoPlan(num+1) && chairs[num+1][6] != chairs[num][2]) {
				queue.add(new int[] {num+1, d != 1 ? 1 : -1});
			}
		}
	}

	static void turn() {
		for(int i=0; i<4; i++) {
			if(turnDir[i] == 0) continue;
			
			turn(i, turnDir[i]);
		}
	}
	
	static void turn(int num, int d) {
		if(d == 1) {
			int temp = chairs[num][7];
			for(int i=7; i>=1; i--) {
				chairs[num][i] = chairs[num][i-1];
			}
			chairs[num][0] = temp;
		}
		
		if(d == -1) {
			int temp = chairs[num][0];
			for(int i=0; i<7; i++) {
				chairs[num][i] = chairs[num][i+1];
			}
			chairs[num][7] = temp;
		}
	}
	
	static void print() {
		int result = 0;
		for(int i=0; i<4; i++) {
			if(chairs[i][0] == S) {
				result += Math.pow(2, i);
			}
		}
		System.out.println(result);
	}

	static boolean isValidPoint(int num) {
		return 0 <= num && num < 4;
	}
	
	static boolean hasNoPlan(int num) {
		return turnDir[num] == 0;
	}
}
