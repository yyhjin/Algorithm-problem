import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_11050_이항계수1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = factorial(N) / (factorial(K)*factorial(N-K));
		System.out.println(answer);
	}

	private static int factorial(int n) {
		if(n==0)
			return 1;
		else
			return factorial(n-1)*n;
		
	}

}
