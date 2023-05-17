import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[1001];
		
		int end_idx = 0;
		int start_idx = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a] = b;
			end_idx = Math.max(end_idx, a);
			start_idx = Math.min(start_idx, a);
		}
		
		int sum = 0;
		int max_val = map[start_idx];
		int max_idx = start_idx;
		for (int i = start_idx; i <= end_idx; i++) {
			if(map[i] == 0) continue;
			
			if(max_val <= map[i]) {
				sum += max_val * (i-max_idx);
				max_val = map[i];
				max_idx = i;
			}
		}
		
		int prev_val = map[end_idx];
		int prev_idx = end_idx;
		for (int i = end_idx; i >= max_idx; i--) {
			if(map[i] == 0) continue;
			
			if(prev_val <= map[i]) {
				sum += prev_val * (prev_idx-i);
				prev_val = map[i];
				prev_idx = i;
			}
		}
	
		sum += max_val;
		
		System.out.println(sum);
	}

}
