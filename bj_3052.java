import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class bj_3052 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int tmp;
        for(int i=0; i<10; i++)
        {
            tmp = scan.nextInt();
            if (list.contains(tmp%42))
                continue;
            list.add(tmp%42);
        }
        System.out.println(list.size());

        scan.close();
    }
}
