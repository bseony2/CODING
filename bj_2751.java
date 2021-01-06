import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;

public class bj_2751 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<N;i++)
            arr.add(Integer.parseInt(br.readLine()));

        Collections.sort(arr);

        for(int vale : arr)
        {
            sb.append(vale).append('\n');
        }
        System.out.println(sb);
    }
}