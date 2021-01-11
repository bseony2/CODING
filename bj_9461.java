import java.util.Scanner;

public class bj_9461 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for(int i= 4; i<101;i++)
            dp[i] = dp[i-2] + dp[i-3];
        
        int N = scan.nextInt();
        for(int i=0; i<N;i++)
        {
            System.out.println(dp[scan.nextInt()]);
        }
        scan.close();
    }
}