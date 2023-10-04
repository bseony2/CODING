import java.io.*;
import java.util.*;
public class 댄스파티 {

	static int N;
	static List<Integer> postMen = new ArrayList<>();
	static List<Integer> negMen = new ArrayList<>();
	static List<Integer> postWomen = new ArrayList<>();
	static List<Integer> negWomen = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			if (height < 0) {
				negMen.add(height * -1);
			} else {
				postMen.add(height);
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			if (height < 0) {
				negWomen.add(height * -1);
			} else {
				postWomen.add(height);
			}
		}

		compare(postMen, negWomen);
		compare(postWomen, negMen);

		System.out.println(ans);
	}

	// tall이 키큰 이성을 원하는 사람, small이 키작은 이성을 원하는 사
	static void compare(List<Integer> tall, List<Integer> small) {
		Collections.sort(tall);
		Collections.sort(small);

		int tallIndex = 0;
		int smallIndex = 0;
		while (tallIndex < tall.size() && smallIndex < small.size()) {
			int tallHeight = tall.get(tallIndex);
			int smallHeight = small.get(smallIndex);

			if (tallHeight < smallHeight) {
				ans += 1;
				tallIndex += 1;
			}
			smallIndex += 1;
		}
	}
}
