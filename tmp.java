import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 
 
public class tmp {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String str = new String();
        for(int i=0; i<N; i++){
            str = br.readLine();
            if(map.containsKey(str)){
                map.replace(str, map.get(str)+1);
            }
            else{
                map.put(str, 1);
            }
        }
        int max = 0;
        for(String a : map.keySet()){
            max = Math.max(max, map.get(a));
        }
        
        ArrayList<String> al = new ArrayList<String>(map.keySet());
        Collections.sort(al);
        for(String a : al){
            if(map.get(a)==max){
                System.out.println(a);
                break;
            }
        }
    }
}
