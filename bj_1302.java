import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class bj_1302 {
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        HashMap<String, Integer>map = new HashMap<String, Integer>();

        for(int i = 0; i<N; i++)//책 이름들 받아들이기
        {
            String tmp = scan.nextLine();
            if(map.containsKey(tmp))//이미 책 이름이 있을경우 value +1
                map.replace(tmp, map.get(tmp) + 1);
            else    //처음 입력한 책일경우 맵에 새로 등록
                map.put(tmp, 1);
        }

        int max = 0;
        for(String a : map.keySet()) //최다 판매량을 획득
        {
            max = Math.max(max, map.get(a));
        }

        ArrayList<String>al = new ArrayList<String>();
        for(String a : map.keySet())
        {
            if(map.get(a) == max)
                al.add(a);
        }

        Collections.sort(al);
        System.out.println(al.get(0));
    }
}
