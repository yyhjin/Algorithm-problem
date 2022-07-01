import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Gold4

public class Main_1261_알고스팟 {

	static int M, N;
	static int[][] map, wall;
	static boolean[][] v;
	static final int INF = 999999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		wall = new int[N+1][M+1];
		v = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j-1)-'0';
				wall[i][j] = INF;
			}
		}
		
		bfs();
		System.out.println(wall[N][M]);

	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static void bfs() {
		// 벽 부순 횟수가 작은 것부터
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return wall[o1[0]][o1[1]] - wall[o2[0]][o2[1]];
			}
		});
		
		pq.add(new int[] {1,1});
		wall[1][1] = 0;
		v[1][1] = true;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			// 횟수 작은 것부터 꺼내므로 먼저 도달했을 때 break 해도 됨
			if(cr==N && cc==M) break;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>0 && nc>0 && nr<=N && nc<=M) || v[nr][nc]) continue;
				
				// 빈 방일때
				if(map[nr][nc] == 0) {
					wall[nr][nc] = wall[cr][cc];
					pq.add(new int[] {nr, nc});
					v[nr][nc] = true;
				}
				// 벽일때
				else {
					wall[nr][nc] = wall[cr][cc] + 1;
					pq.add(new int[] {nr, nc});
					v[nr][nc] = true;
				}
				
			}
		}
		
		
	}

}
