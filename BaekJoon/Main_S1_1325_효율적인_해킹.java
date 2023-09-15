import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S1_1325_효율적인_해킹 {

	static int N, M;
	static ArrayList<Integer>[] map;
	static int[] dp;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
		}
		
		for (int i = 1; i <= N; i++) {			
			v = new boolean[N+1];
			dfs(i);
		}
		
		int max = 0;
		for(int num: dp) {
			max = Math.max(max, num);
		}
		
		for(int i = 1; i <= N; i++) {
			if(dp[i] == max)
				sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void dfs(int num) {		
		v[num] = true;
		
		for(int next: map[num]) {
			if(v[next]) continue;
			dp[next]++;
			dfs(next);
		}
	}

}
