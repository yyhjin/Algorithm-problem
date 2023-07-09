import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S1_6588_골드바흐의_추측 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] prime = new boolean[1000001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		for (int i = 2; i < 1000001; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < 1000001; j+=i) {
				prime[j] = false;
			}
		}
		
		int n = 0;
		loop:
		while((n = Integer.parseInt(br.readLine())) != 0) {
			for (int i = 3; i < 1000001; i++) {
				if(prime[i] && prime[n-i]) {
					sb.append(n + " = " + i + " + " + (n-i) + "\n");
					continue loop;
				}
			}
			sb.append("Goldbach's conjecture is wrong.\n");
		}
		
		System.out.println(sb);
	}

}
