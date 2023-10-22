import java.io.*;
import java.util.*;

public class 문자열복사 {
	static char[] S;
	static char[] T;
	static Map<Character, ArrayList> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		init();

		int ans = 0;
		int TIndex = 0;
		while (TIndex < T.length) {
			char c = T[TIndex];

			ArrayList<Integer> list = map.get(c);
			int max = Integer.MIN_VALUE;
			for (int SIndex : list) {
				int len = getLen(TIndex, SIndex);
				max = Math.max(len, max);
			}

			TIndex += max;
			ans += 1;
		}
		System.out.println(ans);
	}

	static int getLen(int TIndex, int SIndex) {
		int result = 0;

		for (int i = TIndex; i < T.length && SIndex < S.length; i++, SIndex += 1) {
			if (S[SIndex] != T[i])
				break;
			result += 1;
		}
		return result;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine().toCharArray();
		T = br.readLine().toCharArray();

		for (int i = 0; i < S.length; i++) {
			char c = S[i];
			if (!map.containsKey(c)) {
				map.put(c, new ArrayList<Integer>());
			}
			map.get(c).add(i);
		}
	}
}
