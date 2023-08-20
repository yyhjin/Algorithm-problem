import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_17086_아기_상어2 {
	
	static int N, M;
	static int[][] map, distance;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		distance = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1)
					bfs(i, j);
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, distance[i][j]);
			}
		}
		
		System.out.println(max);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		
		q.add(new int[] {r,c});
		v[r][c] = true;
		distance[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<M) || v[nr][nc])
					continue;
				
				distance[nr][nc] = Math.min(distance[nr][nc], distance[cr][cc]+1);
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
	}

}
