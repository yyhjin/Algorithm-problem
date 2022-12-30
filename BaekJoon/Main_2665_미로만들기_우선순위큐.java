import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// Gold4

public class Main_2665_미로만들기_우선순위큐 {

	static int N;
	static int[][] map, dist;
	static boolean[][] v;
	static final int INF = 999999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
				dist[i][j] = INF;
			}
		}
		
		dijkstra();
		System.out.println(dist[N-1][N-1]);

	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static void dijkstra() {
		// 흰 방으로 바꾼 횟수가 적은 것부터
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return dist[o1[0]][o1[1]] - dist[o2[0]][o2[1]];
			}
		});
		q.add(new int[] {0,0});
		dist[0][0] = 0;
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N)
						|| v[nr][nc]) continue;
				
				// 길이 있을 때
				if(map[nr][nc]==1) {
					dist[nr][nc] = dist[cr][cc];
					q.add(new int[] {nr, nc});
					v[nr][nc] = true;
				}
				// 길이 없을 때
				else {
					dist[nr][nc] = dist[cr][cc] + 1;
					q.add(new int[] {nr, nc});
					v[nr][nc] = true;
				}
			}
		}
	}

}
