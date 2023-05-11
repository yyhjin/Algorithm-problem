import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				int num = Integer.parseInt(st.nextToken());
				tri[i][j] = num;
			}
		}

		int max = 0;
		dp[0][0] = tri[0][0];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + tri[i][j];
				max = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(max);
	}

}
