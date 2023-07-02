import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_14940_쉬운_최단거리 {

	static int n, m;
	static int[][] map, distance;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		distance = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], -1);
		}
		
		int er = 0;
		int ec = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					er = i;
					ec = j;
				}
				else if(map[i][j] == 0)
					distance[i][j] = 0;
			}
		}
		
		bfs(er, ec);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(distance[i][j]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[n][m];
		q.add(new int[] {r, c});
		v[r][c] = true;
		distance[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<n && nc<m) || v[nr][nc] || map[nr][nc] == 0)
					continue;
				
				distance[nr][nc] = distance[cr][cc]+1;
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
	}

}
