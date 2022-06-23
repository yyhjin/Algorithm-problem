import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static int N, M, X;
	static int[][] costs, reverse_costs;
	static boolean[] v;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		costs = new int[N+1][N+1];
		reverse_costs = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i==j) continue;
				costs[i][j] = INF;
				reverse_costs[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			costs[A][B] = T;
			reverse_costs[B][A] = T;
		}
		
		int[] back = dijkstra(X, costs);
		int[] go = dijkstra(X, reverse_costs);

		int sum = -1;
		for (int i = 1; i < N+1; i++) {
			if(i==X) continue;
			sum = Math.max(sum, go[i]+back[i]);
		}
		System.out.println(sum);
		
	}

	private static int[] dijkstra(int start, int[][] cost) {
		int[] dijkstra;
		dijkstra = new int[N+1];
		v = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			dijkstra[i] = cost[start][i];
		}
		
		v[start] = true;
		
		for (int i = 1; i < N; i++) {
			int min = INF;
			int minIdx = -1;
			
			// 인접한 노드 중 최소 비용 노드 찾기
			for (int j = 1; j < N+1; j++) {
				if(!v[j] && min > dijkstra[j]) {
					min = dijkstra[j];
					minIdx = j;
				}
			}
			
			// 최소 비용 노드 방문
			v[minIdx] = true;
			
			for (int j = 1; j < N+1; j++) {
				if(!v[j]) {
					dijkstra[j] = Math.min(dijkstra[j], dijkstra[minIdx] + cost[minIdx][j]);
				}
			}
		}
		
		return dijkstra;
	}
}
