package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1012_유기농배추 {

	static int M, N, K;
	static int[][] map;
	static boolean[][] v;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			v = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[b][a] = 1;
			}

			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);

		}

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		v[r][c] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int cr = p[0];
			int cc = p[1];

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (!(nr >= 0 && nr < N && nc >= 0 && nc < M) || v[nr][nc] || map[nr][nc]==0)
					continue;

				q.offer(new int[] { nr, nc });
				v[nr][nc] = true;
			}
		}

	}

}
