import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj_7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] person = new int[50][2];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n;i++)
        {
            int ans = 1;
            for(int j=0; j<n;j++)
            {
                if((person[i][0]< person[j][0]) && (person[i][1] < person[j][1]))
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
