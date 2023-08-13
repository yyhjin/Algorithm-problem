package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형_방 {

	static int N;
	static int[][] map, cnt;
	static int max, tempCnt;
	static int[] dr = { 0, 1, 0, -1};
	static int[] dc = { 1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = -1;
			int roomNo = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tempCnt = 0;
					dfs(i, j);
					
					if(tempCnt > max) {
						max = tempCnt;
						roomNo = map[i][j];
					}
					if(tempCnt == max) {
						roomNo = Math.min(roomNo, map[i][j]);
					}
				}
			}
			
			sb.append("#"+t+" "+roomNo+" "+max+"\n");
		}

		System.out.println(sb);
	}
	
	private static void dfs(int r, int c) {		
		tempCnt++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(nr>=0 && nc>=0 && nr<N && nc<N) || map[nr][nc] != map[r][c]+1)
				continue;
			
			dfs(nr, nc);
		}
	}

}
