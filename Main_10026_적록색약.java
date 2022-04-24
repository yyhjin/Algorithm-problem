package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] v, v2;	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new boolean[N][N];
		v2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					char alpha = map[i][j];
					dfs(i,j,alpha);
					count++;
				}
			}
		}
		
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v2[i][j]) {
					char alpha = map[i][j];
					dfs2(i,j,alpha);
					count2++;
				}
			}
		}

		System.out.println(count+" "+count2);
	}

	
	private static void dfs(int r, int c, char s) {
		v[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (!(nr>=0 && nr<N && nc>=0 && nc<N) || map[nr][nc]!=s || v[nr][nc])
				continue;
			
			dfs(nr, nc, s);
		}
		
	}

	private static void dfs2(int r, int c, char s) {
		v2[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (s=='R' || s=='G') {
				if (!(nr>=0 && nr<N && nc>=0 && nc<N) || map[nr][nc]=='B' || v2[nr][nc])
					continue;
			}
			
			else {
				if (!(nr>=0 && nr<N && nc>=0 && nc<N) || map[nr][nc]!='B' || v2[nr][nc])
					continue;
			}
			
			dfs2(nr, nc, s);
		}
		
	}
}
