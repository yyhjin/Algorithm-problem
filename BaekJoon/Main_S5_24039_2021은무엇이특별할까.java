import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_S5_24039_2021은무엇이특별할까 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[10001];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		// 에라토스테네스의 체
		for (int i = 2; i < 10001; i++) {
			if(!prime[i]) continue;
			for (int j = i+i; j < 10001; j+=i) {
				prime[j] = false;
			}
		}

		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i < 10001; i++) {
			if(prime[i]) primes.add(i);
		}
		
		for (int i = 1; i < primes.size(); i++) {
			int cur = primes.get(i-1) * primes.get(i);
			if(cur>N) {
				System.out.println(cur);
				break;
			}
		}
	}

}
