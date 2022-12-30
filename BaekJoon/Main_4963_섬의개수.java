import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

	static int w, h, answer;
	static int[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			v = new boolean[h][w];
			answer = 0;
			
			// 종료
			if (w==0 && h==0) break;
			
			// 1 by 1
			else if (w==1 && h==1) 
				answer = Integer.parseInt(br.readLine());
			
			else {
				for (int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < w; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if(map[i][j] == 1 && !v[i][j]) {
							bfs(i,j);
							answer++;
						}
					}
				}
				
			}
			
			System.out.println(answer);
		}

	}

	// 8방
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nr<h && nc>=0 && nc<w) || v[nr][nc] || map[nr][nc]==0) continue;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
		
	}

}
