package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		int[][] v = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
					
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (!(nr >= 0 && nr < r && nc >= 0 && nc < c))
					continue;

				if (map[nr][nc] == 0 || v[nr][nc] != 0)
					continue;

				q.offer(new int[] { nr, nc });
				v[nr][nc] = 1;
				map[nr][nc] = map[cr][cc]+1;
			}
		}
		System.out.println(map[r-1][c-1]);
	}
}
