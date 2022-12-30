import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main_2583_영역구하기 {

	static int M, N, K, count;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Integer> area = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		v = new boolean[M+1][N+1];
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j]++;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]==0 && !v[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count);
		Collections.sort(area);
		for (int i = 0; i < area.size(); i++) {
			System.out.print(area.get(i)+" ");
		}		
		
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		v[r][c] = true;
		int rec = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (!(nr>=0 && nr<M && nc>=0 && nc<N) || v[nr][nc] || map[nr][nc]!=0) continue;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
				rec++;
			}
		}
		area.add(rec);
	}

}
