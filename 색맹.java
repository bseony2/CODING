import java.io.*;
import java.util.*;

public class 색맹 {
	static int N;
	static char[][] map;
	static boolean[][] isVisited;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		init();

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					search(i, j, map[i][j]);
					result += 1;
				}
			}
		}
		System.out.print(result + " ");
		change();
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isVisited[i][j]) {
					search(i, j, map[i][j]);
					result += 1;
				}
			}
		}
		System.out.print(result);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			map[i] = arr;
		}
	}
	
	static void search(int r, int c, char color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r); queue.add(c);
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int cr = queue.poll();
			int cc = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(isValidPoint(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == color) {
					queue.add(nr); queue.add(nc);
					isVisited[nr][nc] = true;
				}
			}
		}
	}
	
	static void change() {
		for(int i=0; i<N; i++) {
			Arrays.fill(isVisited[i], false);
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
	}
	
	static boolean isValidPoint(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}

}
