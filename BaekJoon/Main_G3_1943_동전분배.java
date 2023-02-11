import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_G3_1943_동전분배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 3; t++) {
			int N = Integer.parseInt(br.readLine());
			
			HashMap<Integer, Integer> coin = new HashMap<>();
			int[] dp = new int[100001];
			dp[0] = 1;
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sum += a*b;
				coin.put(a, b);	
			}
			
			if(sum%2 == 1) {
				sb.append("0\n");
				continue;
			}
			
			for (int key : coin.keySet()) {
				int value = coin.get(key);
				// 위에서부터 내려오는 이유는?? 만약 1원짜리가 1개만 있다고 할 때
				// 이미 dp[1]이 체크 되었음에도 다음 j에 의해 d[2]가 체크되고... dp[50000]까지 체크되는 불상사가 발생할 수 있기 때문
				for (int i = 50000; i >= key; i--) {
					if (dp[i-key] == 1) {
						for (int j = 0; j < value; j++) {
							if(i+(key*j) >=0) {
								dp[i + (key*j)] = 1;															
							}
						}
					}
				}
			}
			
			sb.append(dp[sum/2]+"\n");
		
		}
		
		System.out.println(sb);
	}

}
