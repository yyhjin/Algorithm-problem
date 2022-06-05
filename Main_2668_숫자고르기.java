import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2668_숫자고르기 {

	static int N;
	static int[] nums;
	static boolean[] v;
	static boolean cycle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N+1];
		v = new boolean[N+1];
		boolean[] choice = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			cycle = false;
			Arrays.fill(v, false);
			dfs(i, i);
			
			if(cycle) {
				for (int j = 1; j <= N; j++) {
					if(v[j] && !choice[j]) {
						count++;
						choice[j] = true;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(choice[i])
				sb.append(i+"\n");
		}
		System.out.println(count);
		System.out.println(sb);
	}

	private static void dfs(int start, int current) {		
		if(!v[current]) {
			v[current] = true;
			dfs(start, nums[current]);
		}
		
		else if(start==current)
			cycle = true;
	}

}
