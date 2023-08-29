import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_3187_양치기_꿍 {

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int wolf, sheep;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'v') wolf++;
				else if(map[i][j] == 'k') sheep++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'v' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		visit[r][c] = true;
		
		int v = 1;
		int k = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<R && nc<C) || visit[nr][nc] 
						|| map[nr][nc]=='#') continue;
				
				if(map[nr][nc] == 'v') v++;
				else if(map[nr][nc] == 'k') k++;
				visit[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		if(k > v) wolf -= v;
		else if(k <= v) sheep -= k;
	}

}
