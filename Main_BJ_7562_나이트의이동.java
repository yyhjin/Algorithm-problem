package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7562_나이트의이동 {
	static int T, L;
	static int cr, cc,  er, ec;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine());
			map = new int[L][L];
			v = new boolean[L][L];
			st = new StringTokenizer(br.readLine());
			cr = Integer.parseInt(st.nextToken());
			cc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			bfs();
			System.out.println(map[er][ec]);
		}

	}

	private static void bfs() {
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {cr, cc});
		map[cr][cc] = 0;
		v[cr][cc] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cur_r = cur[0];
			int cur_c = cur[1];
			
			for (int d = 0; d < 8; d++) {
				int nr = cur_r + dr[d];
				int nc = cur_c + dc[d];

				if (!(nr >= 0 && nr < L && nc >= 0 && nc < L) || v[nr][nc]) 
					continue;

				v[nr][nc] = true;
				map[nr][nc] = map[cur_r][cur_c] + 1;
				q.offer(new int[] { nr, nc });
				if(nr==er && nc==ec) return;
			}
		}
		
	}

}
