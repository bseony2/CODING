import java.util.Scanner;

public class bj_1149 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[][] cost = new int[N+1][3];

        for(int i=1; i<N+1;i++) //입력 초기화
        {
            cost[i][0] = scan.nextInt();
            cost[i][1] = scan.nextInt();
            cost[i][2] = scan.nextInt();
        }

        for(int i=2;i<N+1;i++)
        {
            cost[i][0] = cost[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] = cost[i][1] + Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = cost[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);
        }

        scan.close();
        System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));
    }
}
