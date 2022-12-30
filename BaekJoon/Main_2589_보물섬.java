import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {

	static int H, W;
	static char[][] map;
	static int max = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		
		for (int i = 0; i < H; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				map[i][j] = c[j];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j]=='L')
					bfs(i, j);
			}
		}
		
		System.out.println(max);
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[H][W];
		int[][] distance = new int[H][W];
		
		q.add(new int[] {r,c});
		v[r][c] = true;
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nr<H && nc>=0 && nc<W) || v[nr][nc] || map[nr][nc]=='W')
					continue;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
				distance[nr][nc] = distance[cr][cc]+1;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				max = Math.max(max, distance[i][j]);
			}
		}
		
	}

}
