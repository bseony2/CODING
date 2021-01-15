import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class bj_2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        long A = Long.parseLong(tmp[0]);
        long B = Long.parseLong(tmp[1]);
        long V = Long.parseLong(tmp[2]);
        long ans = 1 + (((V-A)%(A-B) == 0 ? (V-A)/(A-B) : ((V-A)/(A-B)) + 1));
        System.out.println(ans);
    }
}