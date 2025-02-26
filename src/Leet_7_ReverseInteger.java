public class Leet_7_ReverseInteger {
	public int reverse(int x) {
		if (Integer.MAX_VALUE == x || Integer.MIN_VALUE == x) {
			return 0;
		}

		String num = x < 0 ? String.valueOf(x * -1) : String.valueOf(x);

		StringBuilder reverse = new StringBuilder();
		for (int i = num.length() - 1; i >= 0; i--) {
			reverse.append(num.charAt(i));
		}

		if (Long.parseLong(reverse.toString()) < Integer.MIN_VALUE || Long.parseLong(reverse.toString()) > Integer.MAX_VALUE) {
			return 0;
		}

		return x < 0 ? Integer.parseInt(reverse.toString()) * -1 : Integer.parseInt(reverse.toString());
	}
}
