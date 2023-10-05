import java.io.*;
public class 종이접기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (check(s, 0, s.length() - 1)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static boolean check(String s, int start, int end) {
		if (start >= end)
			return true;

		int mid = (start + end) / 2;

		for (int i = 0; i < mid - start; i++) {
			if (s.charAt(start + i) == s.charAt(end - i))
				return false;
		}

		return check(s, start, mid - 1) && check(s, mid + 1, end);
	}

}
