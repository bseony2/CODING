import java.util.Scanner;
import java.math.BigInteger;
public class bj_10757 {
	public static void main(String[] arg) {

		Scanner scan = new Scanner(System.in);
		
		BigInteger a = new BigInteger(scan.next());
		BigInteger b = new BigInteger(scan.next());
		
		a = a.add(b);
		
		System.out.println(a.toString());
        scan.close();
	}
}