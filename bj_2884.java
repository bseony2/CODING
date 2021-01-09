import java.util.Scanner;

public class bj_2884 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int m = scan.nextInt();

        if(m<45)
        {
            h -=1;
            m = 15+m;
            if(h == -1)
                h = 23;
        }
        else
            m -= 45;
        System.out.println(h + " " + m);

        scan.close();
    }
}