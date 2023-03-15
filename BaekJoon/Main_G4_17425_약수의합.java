import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_G4_17425_약수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] sum = new int[1000001];  // 해당 수의 약수의 합
		long[] sumsum = new long[1000001];  // 해당 수 이하의 약수의 합을 더한 값
		
		Arrays.fill(sum, 1); // 1은 모든 수의 약수이므로
		
		// 에라토스테네스의 체 - 배수로 체크해줌
		for (int i = 2; i < 1000001; i++) {
			for (int j = 1; i*j < 1000001; j++) {
				sum[i*j] += i;
			}
		}
		
		// 누적합
		for (int i = 1; i < 1000001; i++) {
			sumsum[i] = sumsum[i-1] + sum[i];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(sumsum[N]+"\n");
		}
		System.out.println(sb);
		
	}

}
