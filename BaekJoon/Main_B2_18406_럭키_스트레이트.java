import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_18406_럭키_스트레이트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < N.length()/2; i++) {
			sum1 += N.charAt(i)-'0';
		}
		for (int i = N.length()/2; i < N.length(); i++) {
			sum2 += N.charAt(i)-'0';
		}
		
		System.out.println(sum1==sum2?"LUCKY":"READY");
	}

}
