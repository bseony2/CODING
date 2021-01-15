import java.util.Scanner;
public class bj_10952 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            int a = scan.nextInt(); int b = scan.nextInt();
            if(a == 0 && b == 0)
                break;
            else
                System.out.println(a+b);
        }
        scan.close();
    }
}
