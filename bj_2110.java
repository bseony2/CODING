import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;

public class bj_2110 {

    public static void main(String[] args) throws IOException{
        //입력 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);
        ArrayList<Integer> house = new ArrayList<Integer>();
        for(int i=0; i<n; i++)
            house.add(Integer.parseInt(br.readLine()));
        Collections.sort(house);

        //변수 설정
        int min = 1;
        int max = house.get(n-1) - house.get(0);
        int result = 0;

        while(min<=max)
        {
            int gap = (min + max)/2;
            int start = house.get(0);
            int count = 1;

            for(int i=0; i<n;i++)
            {
                if(house.get(i) - start >= gap)
                {
                    count++;
                    start = house.get(i);
                }
            }

            if(count>= c)
            {
                result = gap;
                min = gap+1;
            }
            else
                max = gap-1;
        }
        System.out.println(result);

    }
}