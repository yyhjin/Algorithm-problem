import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_1240_노드사이의거리 {
	static int N, M;
	static int[][] map;
	static boolean[] v;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[a][b] = cost;
			map[b][a] = cost;
		}
		
		for (int i = 0; i < M; i++) {
			v = new boolean[N+1];
			stack.clear();
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			v[a] = true;
			dfs(a, b, 0);
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	
	private static void dfs(int n, int target, int distance) {		
		if(n == target) {
			sb.append(distance+"\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(map[n][i] != 0 && !v[i]) {
				stack.push(map[n][i]);
				v[i] = true;				
				dfs(i, target, distance+map[n][i]);
			}
		}
	}

}
