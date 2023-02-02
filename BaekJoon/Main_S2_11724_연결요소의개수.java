import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_11724_연결요소의개수 {

	static int N, M;
	static int[][] map;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(map[i][j] == 1 && !v[i]) {
					v[i] = true;
					count++;
					dfs(i);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!v[i]) count++;
		}
		
		System.out.println(count);
	}
	
	private static void dfs(int n) {
		for (int i = 1; i <= N; i++) {
			if(map[n][i] == 1 && !v[i]) {
				v[i] = true;
				dfs(i);
			}
		}
	}

}
