import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_2512_예산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long M = Long.parseLong(br.readLine());
		int[] cost = new int[N];
		
		long sum = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
			max = Math.max(max, cost[i]);
		}
		
		if(sum <= M) System.out.println(max);
		else {
			long left = 0;
			long right = M;
			long result = 0;
			
			while(left<=right) {
				long mid = (left+right)/2;
				
				long all = 0;
				for (int i = 0; i < N; i++) {
					if(cost[i] <= mid) all += cost[i];
					else all += mid;
				}
				if(all > M) right = mid-1;
				else {
					left = mid+1;
					result = mid;
				}
			}
			System.out.println(result);
		}
		
	}

}
