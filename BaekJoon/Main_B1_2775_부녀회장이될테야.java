import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[15][15];
		
		for (int i = 1; i < 15; i++) {
			dp[0][i] = i;
		}
		
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				int cnt = 0;
				for (int k = 1; k <= j; k++) {
					cnt += dp[i-1][k];					
				}
				dp[i][j] = cnt;
			}
		}
		
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]+"\n");
		}
		
		System.out.println(sb);
	}

}
