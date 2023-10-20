import java.io.*;
import java.util.*;
public class 선긋기 {

	static PriorityQueue<int[]> queue = 
        new PriorityQueue<int[]>((a, b) -> {
		    if(a[0] != b[0]) return a[0] - b[0];
		    return a[1] - b[1];
	    });
	public static void main(String[] args) throws IOException {
		init();
		int[] init = queue.poll();
		int max = init[1];
		int ans = init[1] - init[0];
		
		while(!queue.isEmpty()) {
			int[] point = queue.poll();
			if(point[1] <= max) {
				continue;
			}
			else if(point[0] < max) {
				ans += point[1] - max;
			}
			else {
				ans += point[1] - point[0];
			}
			max = point[1];
		}
		System.out.println(ans);
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			queue.add(new int[] {x, y});
		}
	}

}
