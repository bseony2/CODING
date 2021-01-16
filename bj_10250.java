import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bj_10250 { 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int floor=0; int room = 0;
        for(int i=0; i<t; i++)
        {
            String[] tmp = br.readLine().split(" ");
            int h = Integer.parseInt(tmp[0]);
            int n = Integer.parseInt(tmp[2]);

            floor = (n%h ==0 ? h : n%h);
            room = (n%h ==0 ? n/h : n/h +1);
            System.out.println(floor*100 + room);
        }
        
    }
}
