import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	
	static int N, S, R;
	static int[] nums, sub;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
				
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			R = i;
			sub = new int[R];
			combi(0,0);
		}
		System.out.println(count);
	}

	private static void combi(int cnt, int start) {
		if(cnt==R) {
			int sum = 0;
			for (int i = 0; i < sub.length; i++) {
				sum += sub[i];
			}
			if(sum==S) count++;
			
			return;
		}
		for (int i = start; i < N; i++) {
			sub[cnt] = nums[i];
			combi(cnt+1, i+1);
			
		}
		
	}

}
