package binary_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bj_1991_HashMap {
    
    static Map<String, List<String>> map = new HashMap<>();

    private static void preOrder(String s)
    {
        if(s.equals("."))return;
        System.out.print(s);
        preOrder(map.get(s).get(0));
        preOrder(map.get(s).get(1));
    }

    private static void inOrder(String s)
    {
        if(s.equals("."))return;
        inOrder(map.get(s).get(0));
        System.out.print(s);
        inOrder(map.get(s).get(1));
    }

    private static void postOrder(String s)
    {
        if(s.equals("."))return;
        postOrder(map.get(s).get(0));
        postOrder(map.get(s).get(1));
        System.out.print(s);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n;i++)
        {
            String[]s = br.readLine().split(" ");
            List<String> tmp = new ArrayList<>();
            tmp.add(s[1]); tmp.add(s[2]);
            map.put(s[0], tmp);
        }
        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }
}