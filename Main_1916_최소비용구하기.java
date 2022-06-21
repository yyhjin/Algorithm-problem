import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	static int N;
	static int M;
	static int[][] costs;
	static int[] dijkstra;
	static boolean[] v;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		costs = new int[N+1][N+1];
		dijkstra = new int[N+1];
		v = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i==j) continue;
				costs[i][j] = INF;
			}
		}
				
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			costs[start][end] = Math.min(costs[start][end], cost);
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		dijkstra(S);
		System.out.println(dijkstra[E]);
		
	}

	private static void dijkstra(int start) {
		for (int i = 1; i < N+1; i++) {
			dijkstra[i] = costs[start][i];
		}
		
		v[start] = true;
		
		for (int i = 1; i < N; i++) {
			int min = INF;
			int minIdx = 0;
			for (int j = 1; j < N+1; j++) {
				if(!v[j] && dijkstra[j] < min) {
					min = dijkstra[j];
					minIdx = j;
				}
			}
			
			v[minIdx] = true;
			for (int j = 1; j < N+1; j++) {
				dijkstra[j] = Math.min(dijkstra[j], dijkstra[minIdx] + costs[minIdx][j]);
			}
		}
		
		
	}

}
