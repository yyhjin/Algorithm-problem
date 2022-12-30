import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	static int N, min;
	static int[][] costs, dist;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			t++;
			
			costs = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = INF;
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					costs[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();	
			System.out.println("Problem "+t+": "+dist[N-1][N-1]);
		}

	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return costs[o1[0]][o1[1]] - costs[o2[0]][o2[1]];
			}
		});
		
		pq.add(new int[] {0,0});
		dist[0][0] = costs[0][0];
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
						
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N)
						|| dist[nr][nc] <= dist[cr][cc]+costs[nr][nc])
					continue;
				
				pq.add(new int[] {nr, nc});
				dist[nr][nc] = dist[cr][cc]+costs[nr][nc];
			}
		}
		
	}

}
