import java.util.Scanner;

public class bj_9095 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());

        int[] result = new int[12];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for(int i=4;i<12;i++)
        {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }

        for(int i=0;i<T;i++)
            System.out.println(result[Integer.parseInt(scan.nextLine())]);
        scan.close();
    }
}
