import java.io.*;
public class 회문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String s = br.readLine();
			System.out.println(check(s, 0, s.length()-1, 0));
		}
	}
	
	private static int check(String s, int left, int right, int depth) {
		while(left < right) {
			
			// 반대편끼리 같으면 넘
			if(s.charAt(left) == s.charAt(right)) {
				left += 1;
				right -= 1;
				continue;
			}
			
			// 아래부터는 반대편끼리 같지 않을 경우 (return depth이기 때문에 여기서 그냥 depth += 1)
			depth += 1;
			
			// depth가 2일 경우 무조건 일반 문자열이기 때문에depth == 1 조건을 붙인다
			// 오른쪽 숫자 하나 재꼈을 경우 회문이면 일단 진
			if(depth == 1 && check(s, left, right-1, 1) == 1) {
				right -= 1;
				continue;
			}
			
			// 쪽 숫자 하나 재꼈을 경우 회문이면 일단 진
			if(depth == 1 && check(s, left+1, right, 1) == 1) {
				left += 1;
				continue;
			}
			
			return 2;
		}
		return depth;
	}
}
