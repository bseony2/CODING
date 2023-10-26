import java.util.*;
import java.io.*;

public class 회전초밥 {
	static int n, d, k, c;
	static int[] sushi;
	static int[] ate;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		d = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		c = Integer.valueOf(st.nextToken());
		sushi = new int[n];
		ate = new int[d + 1];
		
		for(int i = 0; i < n; i++) {
			sushi[i] = Integer.valueOf(br.readLine());
		}
		
		int count = 0;
		for(int i = 0; i < k; i++) {
			if(ate[sushi[i]] == 0) {
				count++;
			}
			
			ate[sushi[i]]++;
		}

		int maxLen = count;
		for(int i = 1; i < n; i++) {
			
			if(maxLen <= count) {
				if(ate[c] == 0) { // 아직 쿠폰초밥을 안먹은 상태
					maxLen = count + 1;
				}
				else { // 아직 쿠폰초밥을 먹은 상태
					maxLen = count;
				}
			}
			
			int end = (i + k - 1) % n;
			if(ate[sushi[end]] == 0) {
				count++;
			}
			ate[sushi[end]]++;
			
			ate[sushi[i - 1]]--;
			if(ate[sushi[i - 1]] == 0) {
				count--;
			}
		}
		
		System.out.println(maxLen);
	}
}
