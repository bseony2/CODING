import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class bj_1668 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> dock = new ArrayList<Integer>();

        for(int i=0; i<N; i++)
            dock.add(Integer.parseInt(scan.nextLine()));

        int tmp = 0;
        int result = 0;

        for(int i = 0; i<dock.size();i++)
        {
            if(tmp<dock.get(i))
            {
                result++;
                tmp = dock.get(i);
            }
        }
        System.out.println(result);

        Collections.reverse(dock);
        tmp = 0;
        result = 0;

        for(int i = 0; i<dock.size();i++)
        {
            if(tmp<dock.get(i))
            {
                result++;
                tmp = dock.get(i);
            }
        }
        System.out.println(result);
    }
}

