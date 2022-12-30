package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2638_치즈 {
	
	static int H, W;
	static int[][] map;
	static boolean[][] v;
	static int count;
	static boolean start;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W][H];
		
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[j][i] = Integer.parseInt(st.nextToken());
				if (map[j][i]==1)
					count++;
			}
		}

		int time = 0;
		while (count > 0) {
			time++;
			bfs();
		}
		
		System.out.println(time);
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void bfs() {
		v = new boolean[W][H];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		v[0][0]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (!(nr>=0 && nr<W && nc>=0 && nc<H) || v[nr][nc])
					continue;
				
				if (map[nr][nc]==0) {
					q.add(new int[] {nr, nc});
					cnt++;
				}
				v[nr][nc]=true;

			}
			if (cnt>=2) {
				count--;
				map[cr][cc]=0;
			}
		}	
	}

}
