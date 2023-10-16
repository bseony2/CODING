import java.io.*;
import java.util.*;

public class 내려가기 {
	static int N;
	static int[][] board;
	static int[][] max;
	static int[][] min;
	public static void main(String[] args) throws Exception{
		
		init();
		
		for (int i = 1; i < N; i++) {
			
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + board[i][0];
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + board[i][1];
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + board[i][2];
			
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + board[i][0];
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + board[i][1];
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + board[i][2];
		}
		
		int maxResult = Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2]);
		int minResult = Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]);
		
		System.out.println(maxResult+" "+minResult);
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][3];
		max = new int[N][3]; 
		min = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[i][0] = a;
			board[i][1] = b;
			board[i][2] = c;
		}
		
		max[0][0] = board[0][0];
		max[0][1] = board[0][1];
		max[0][2] = board[0][2];
		
		min[0][0] = board[0][0];
		min[0][1] = board[0][1];
		min[0][2] = board[0][2];
	}
}
