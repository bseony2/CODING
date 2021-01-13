import java.util.Scanner;
public class bj_2231 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int tmp = n, tmp2;
        int num = String.valueOf(n).length();
        int find = 0;

        tmp = n - num*9;

        for(int i=(n-num*9); i<n;i++)
        {
            tmp = i; tmp2 = i;
            while(true)
            {
                tmp += tmp2%10;
                tmp2 = tmp2/10;
                if(tmp2/10 == 0)
                {
                    tmp += tmp2%10;
                    break;
                }
            }
            if(n == tmp)
            {
                find = i;
                break;
            }
        }
        System.out.println(find);
        scan.close();
    }
}
