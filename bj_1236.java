import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 


public class bj_1236 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 초기화 단계
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        char[][] castle = new char[N][M];
        for(int i=0; i<N; i++)
        {
            castle[i] = br.readLine().toCharArray();
        }
        int row = N;
        int column = M;

        //행으로 계산 했을 시 필요한 경비원 row
        for(int i=0; i<N; i++)
        {
            boolean guard = false;
            for(int j=0; j<M; j++)
            {
                if(castle[i][j] == 'X')
                {
                    guard = true;
                    break;
                }
            }
            if(guard == true)
                row--;
        }

        //열로 계산 했을 경우 필요한 경비원 column
        for(int i=0; i<M; i++)
        {
            boolean guard = false;
            for(int j=0; j<N; j++)
            {
                if(castle[j][i] == 'X')
                {
                    guard = true;
                    break;
                }
            }
            if(guard == true)
                column--;
        }
        sc.close();
        System.out.println(Math.max(row, column));
    }
    
}
