import java.util.*;
public class Solution{
	static StringBuilder sb;
	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		proceed("test.email+james@coding.com");
		proceed("test.e.mail+toto.jane@coding.com");
		proceed("testemail+tom@cod.ing.com");
		
		System.out.println(set.toString());
	}
	
	static public void proceed(String email) {
		int splitPoint = email.indexOf('@');
		sb = new StringBuilder(splitPoint);
		String local = email.substring(0, splitPoint);
		for(int i=0; i<local.length(); i++)
		{
			if(local.charAt(i) == '.')
				continue;
			else if(local.charAt(i) == '+')
				break;
			else
				sb.append(local.charAt(i));
		}
		sb.append("@");
		sb.append(email.substring(splitPoint + 1, email.length()));
		set.add(sb.toString());
	}
	
}