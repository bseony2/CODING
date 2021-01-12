import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class bj_2562 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int index = 0;
        for(int i=0; i<9; i++)
        {
            list.add(scan.nextInt());
            if(list.get(i) > max)
            {
                max = list.get(i);
                index = i+1;
            }
        }
        System.out.println(max);
        System.out.println(index);

        scan.close();
    }
}
