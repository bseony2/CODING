import java.util.*;

/**
 * 보석과 돌
 */
public class 보석과돌 {

    static Set<Character> set;
    static char[] jewel;
    public static void main(String[] args) {
        String jewels = "z";
        String stones = "ZZ";
        int answer = 0;

        jewel = jewels.toCharArray();
        
        for(int i=0; i<stones.length(); i++)
        {
            if( isContain(stones.charAt(i)) )
                answer++;
        }

        System.out.println(answer);
    }

    static public boolean isContain(char c)
    {
        boolean result = false;
        for(int i=0; i<jewel.length; i++)
        {
            if(c == jewel[i])
            {
                result = true;
                break;
            }
        }
        return result;
    }
}