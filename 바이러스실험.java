import java.io.*;
import java.util.*;
public class 바이러스실험 {
	static int N, M, K, turn=0;
	static int[][] nut;
	static List<Integer>[][] virusMap;
	static int[][] nutMap;
	static int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws IOException {
		init();
		
		simulate();
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nut = new int[N][N];
		nutMap = new int[N][N];
		virusMap = new List[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				nutMap[i][j] = Integer.parseInt(st.nextToken());
				nut[i][j] = 5;
				virusMap[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			
			virusMap[r][c].add(age);
		}
	}
	
	static void simulate() {
		while(++turn <= K) {
			grow();
			
			breeding();
			
			addNut();
		}
		
		System.out.print(count());
	}
	
	static void grow() {
		int[][] dead = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(virusMap[i][j].size() == 0) continue;
				
				List<Integer> next = new ArrayList<>();
				Collections.sort(virusMap[i][j]);
				
				for(int virus : virusMap[i][j]) {
					if(virus <= nut[i][j]) {
						nut[i][j] -= virus;
						next.add(virus + 1);
					}
					else {
						dead[i][j] += virus/2;
					}
				}
				virusMap[i][j] = next;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				nut[i][j] += dead[i][j];
			}
		}
		
		
	}
	
	static void breeding() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int virus : virusMap[i][j]) {
					if(virus % 5 != 0) continue;
					
					for(int k=0; k<8; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(isValidPoint(nr, nc)) {
							virusMap[nr][nc].add(1);
						}
					}
				}
			}
		}
	}
	
	static void addNut() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				nut[i][j] += nutMap[i][j];
			}
		}
	}
	
	static int count() {
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result += virusMap[i][j].size();
			}
		}
		return result;
	}
	
	static boolean isValidPoint(int r, int c) {
		return 0<=r && r<N && 0<=c && c<N;
	}
}
