import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {

	static int N, p1, p2;
	static int[][] map;
	static boolean[] v;
	static int count = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		dfs(p1, 0);
		
		System.out.println(count);
	}

	private static void dfs(int n, int cnt) {		
		if(n==p2) {
			count = cnt;
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			if(map[n][i]==1 && !v[i]) {
				v[i] = true;
				dfs(i, cnt+1);
			}
		}
	}

}
