import java.util.Scanner;

public class bj_11021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a, b =0;
        for(int i=0; i<n;i++)
        {
            a = scan.nextInt();b=scan.nextInt();
            System.out.print("Case #"+(i+1)+": ");
            System.out.println(a+b);
        }
        scan.close();
    }
}
