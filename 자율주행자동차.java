import java.io.*;
import java.util.*;

public class 자율주행자동차 {
	static int[][] map;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int N, M;
	static Car car;
	public static void main(String[] args) throws IOException {
		init();
		
		simulate();
		
		System.out.println(count());
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		car = new Car(r, c, d);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void simulate() {
		map[car.r][car.c] = -1;
		while(true) {
			int r = -1, c = -1;
			int d = car.d;
			for(int i=0; i<4; i++) {
				d = (d+3)%4;
				int nr = car.r + dr[d];
				int nc = car.c + dc[d];
				
				if(!isVisited(nr, nc) && isRoad(nr, nc)) {
					r = nr;
					c = nc;
					car.d = d;
					break;
				}
			}
			
			if(r != -1) {
				car.r = r;
				car.c = c;
				map[r][c] = -1;
			}
			else if(r == -1) {
				r = car.r + dr[(car.d+2)%4];
				c = car.c + dc[(car.d+2)%4];
				if(isRoad(r, c)) {
					car.r = r;
					car.c = c;
				}
				else {
					return;
				}
			}
		}
	}
	
	static int count() {
		int result = 0;
		
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(isVisited(i, j)) result += 1;
			}
		}
		
		return result;
	}
	
	static boolean isVisited(int r, int c) {
		return map[r][c] == -1;
	}
	
	static boolean isRoad(int r, int c) {
		return map[r][c] <= 0;
	}

	static class Car {
		int r, c, d;
		public Car(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
