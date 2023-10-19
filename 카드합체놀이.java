import java.util.*;
import java.io.*;
public class 카드합체놀이 {
	static int n, m;
	static PriorityQueue<Long> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			queue.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0; i<m; i++) {
			long a = queue.poll();
			long b = queue.poll();
			
			long result = a+b;
			queue.add(result);
			queue.add(result);
		}
		
		long ans = 0;
		for(long i : queue) {
			ans += i;
		}
		
		System.out.println(ans);
	}
}
