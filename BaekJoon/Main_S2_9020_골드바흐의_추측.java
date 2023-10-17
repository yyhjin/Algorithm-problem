import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S2_9020_골드바흐의_추측 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[100000];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < 100000; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < 100000; j+=i) {
				prime[j] = false;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int a = 0;
			for (int i = 2; i <= n/2; i++) {
				if(prime[i] && prime[n-i]) {
					a = i;
				}
			}
			sb.append(a+" "+(n-a)+"\n");
		}
		
		System.out.println(sb);
	}

}
