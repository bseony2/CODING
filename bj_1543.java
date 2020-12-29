package baekjoon;

import java.util.Scanner;

public class bj_1543 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String dic = scan.nextLine();
        String word = scan.nextLine();
        int result = 0;

        for(int i = 0; word.length() <= dic.length() - i; i++)
        {
            if(dic.substring(i, i + word.length()).equals(word))
            {
                result++;
                i = i + word.length() - 1;
            }
            else continue;
        }

        System.out.println(result);
    }
}


