import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_B1_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		// 최대공약수
		BigInteger gcd = a.gcd(b);
		
		//최소공배수
		int lcm = a.intValue()*b.intValue() / gcd.intValue();
		
		System.out.println(gcd);
		System.out.println(lcm);

	}

}
