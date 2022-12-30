import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int nums[] = new int[N+1];
		
		Arrays.fill(nums, 1);
		nums[0] = 0;
		nums[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			if(nums[i]==0) continue;
			
			for (int j = i+i; j <= N; j+=i) {
				nums[j] = 0;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(nums[i]==1)
				sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}

}
