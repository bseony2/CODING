import java.util.Scanner;
public class bj_2231 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int tmp = n, tmp2;
        int num = 1; //자릿수
        int find = 0;
        while(true)
        {
            if(tmp/10 == 0)
                break;
            tmp = tmp/10;
            num++;
        }
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
        if(find>0)
            System.out.println(find);
        else
            System.out.println(0);
        scan.close();
    }
}
