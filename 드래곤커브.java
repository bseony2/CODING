import java.io.*;
import java.util.*;
public class 드래곤커브 {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dr = new int[] {0, -1, 0, 1};
	static int[] dc = new int[] {1, 0, -1, 0};
	static boolean[][] map = new boolean[101][101];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			List<Integer> direction = getDirection(d, g);
			
			drow(r, c, direction);
			
		}
		int ans = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					ans += 1;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static List<Integer> getDirection(int d, int g) {
		List<Integer> result = new ArrayList<>();
		result.add(d);
		for(int i=0; i<g; i++) {
			List<Integer> newList = curve(result);
			result.addAll(newList);
		}
		return result;
	}

	static List<Integer> curve(List<Integer> origin) {
		List<Integer> result = new ArrayList<>();
		for(int i=origin.size()-1; i>=0; i--) {
			result.add((origin.get(i) + 1) % 4);
		}
		return result;
	}
	
	static void drow(int r, int c, List<Integer> direction) {
		map[r][c] = true;
		for(int d : direction) {
			r += dr[d];
			c += dc[d];
			
			map[r][c] = true;
		}
	}
	
}
