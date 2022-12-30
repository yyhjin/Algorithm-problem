import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Gold4

public class Main_2665_미로만들기 {

	static int N;
	static int[][] map, dist;
	static final int INF = 999999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		
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
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		dist[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N)
						|| dist[nr][nc] <= dist[cr][cc]) continue;
				
				// 길이 있을 때
				if(map[nr][nc]==1) {
					dist[nr][nc] = dist[cr][cc];
					q.add(new int[] {nr, nc});
				}
				// 길이 없을 때
				else {
					dist[nr][nc] = dist[cr][cc] + 1;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}

}
