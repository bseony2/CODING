import java.util.Scanner;

public class bj_6064 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int M, N, x, y, year = 0;
        for(int i=0; i<n;i++)
        {
            M = scan.nextInt(); N = scan.nextInt();
            x = scan.nextInt(); y = scan.nextInt();

            int gcd = 0;
            while(true)
            {
                year++;
                if((year % M) == 0 && (year % N) == 0)
                {
                    gcd = year;
                    break;
                }
            }
            year = (x>y) ? x : y;
            while(true)
            {
                if(((year-x)%M == 0) && ((year-y)%N == 0))
                {
                    System.out.println(year);
                    break;
                }
                year += (x>y) ? M : N;
                if (year> gcd)
                {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
