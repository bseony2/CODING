import java.io.*;
import java.util.*;

public class A와B {
	static String S;
	static StringBuilder T;
	public static void main(String[] args) throws IOException {
		init();
		
		while(S.length() != T.length()) {
			char word = T.charAt(T.length()-1);
			if(word == 'A') {
				T.delete(T.length()-1, T.length());
			}
			else {
				T.delete(T.length()-1, T.length());
				T.reverse();
			}
		}
		
		System.out.println(S.equals(T.toString()) ? 1 : 0);
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = new StringBuilder(br.readLine());
	}

}
