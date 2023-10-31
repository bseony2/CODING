import java.io.*;
import java.util.*;

public class 다각형그리기 {
    static int N;
    static int[] flag;
    static int T;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            int[] temp = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!check(temp) && !check(reverseArr(temp)))
                continue;

            ans += 1;
            sb.append(input).append("\n");
        }

        System.out.println(ans);
        System.out.println(sb.toString());
    }

    static int[] reverseArr(int[] origin) {
        int[] result = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            int value = origin[N - 1 - i];
            int next = (value + 2) % 4;
            next = next == 0 ? 4 : next;
            result[i] = next;
        }
        return result;
    }

    static boolean check(int[] arr) {

        int[] longArr = makeArrDouble(arr);

        for (int i = 0; i < N; i++) {
            if (longArr[i] == flag[0]) {
                if (isSame(longArr, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[] makeArrDouble(int[] arr) {
        int[] result = new int[arr.length * 2];
        System.arraycopy(arr, 0, result, 0, N);
        System.arraycopy(arr, 0, result, N, N);

        return result;
    }

    static boolean isSame(int[] arr, int index) {
        for (int i = 0; i < N; i++) {
            if (arr[i + index] != flag[i])
                return false;
        }
        return true;
    }
}
