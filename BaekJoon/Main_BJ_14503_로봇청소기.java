package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14503_로봇청소기 {

	static int N, M, r, c, d;
	static int[][] map;
	static int[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		r  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		d  = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
			
		System.out.println(count);

	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		v[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
					
			for (int i = 0; i < 4; i++) {
				// 왼쪽 방향
				int nr = cr + dr[direction(d)];  
				int nc = cc + dc[direction(d)];				
				
				if (v[nr][nc]!=0 || map[nr][nc]==1) {
					if (i==3) {
						d = (d+3)%4;
						switch(d) {
						case 0:
							if (map[cr+1][cc]==1) return;
							q.offer(new int[] {cr+1, cc});
							break;
						case 1:
							if (map[cr][cc-1]==1) return;
							q.offer(new int[] {cr, cc-1});
							break;
						case 2:
							if (map[cr-1][cc]==1) return;
							q.offer(new int[] {cr-1, cc});
							break;
						case 3:
							if (map[cr][cc+1]==1) return;
							q.offer(new int[] {cr, cc+1});
							break;
						}						
					}
					else {
						d = (d+3)%4;
						continue;
					}
				}
				
				else if (map[nr][nc]==0) {
					d = (d+3)%4;
					q.offer(new int[] {nr, nc});
					count++;
					v[nr][nc] = count;
					break;
					
				}
			}
			
		}
		
	}

	private static int direction(int d) {
		int nd = 0;
		if (d==0) nd = 3;
		else if (d==1) nd = 0;
		else if (d==2) nd = 1;
		else if (d==3) nd = 2;
		return nd;
	}

}
