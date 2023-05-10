import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_1912_연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		int[] num = new int[N+1];
		int[] dp = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = -2000;
		Arrays.fill(dp, -2000);
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
