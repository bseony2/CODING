import java.util.*;
import java.io.*;

public class 정육면체굴리기 {

	static int[] dr = new int[] { 0, 0, -1, 1 };
	static int[] dc = new int[] { 1, -1, 0, 0 };
	static int[] dice = new int[] { 0, 0, 0, 0, 0, 0 };
	static int N, M, K;
	static int diceR, diceC;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		init();

		simulate();

		System.out.println(sb.toString());
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		diceR = Integer.parseInt(st.nextToken());
		diceC = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
	}

	static void simulate() {
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken()) - 1;
			int nr = diceR + dr[d];
			int nc = diceC + dc[d];

			if (!isValidPoint(nr, nc))
				continue;

			diceR = nr;
			diceC = nc;
			roll(d);
			sb.append(dice[0]).append("\n");

			if (map[diceR][diceC] == 0) {
				map[diceR][diceC] = dice[5];
			} else if (map[diceR][diceC] != 0) {
				dice[5] = map[diceR][diceC];
				map[diceR][diceC] = 0;
			}
		}
	}

	static void roll(int d) {
		int[] newDice = new int[6];

		if (d == 0) {
			newDice[0] = dice[4];
			newDice[1] = dice[1];
			newDice[2] = dice[0];
			newDice[3] = dice[3];
			newDice[4] = dice[5];
			newDice[5] = dice[2];
		} else if (d == 1) {
			newDice[0] = dice[2];
			newDice[1] = dice[1];
			newDice[2] = dice[5];
			newDice[3] = dice[3];
			newDice[4] = dice[0];
			newDice[5] = dice[4];
		} else if (d == 2) {
			newDice[0] = dice[1];
			newDice[1] = dice[5];
			newDice[2] = dice[2];
			newDice[3] = dice[0];
			newDice[4] = dice[4];
			newDice[5] = dice[3];
		} else if (d == 3) {
			newDice[0] = dice[3];
			newDice[1] = dice[0];
			newDice[2] = dice[2];
			newDice[3] = dice[5];
			newDice[4] = dice[4];
			newDice[5] = dice[1];
		}

		dice = newDice;
	}

	static boolean isValidPoint(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}
