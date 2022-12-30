import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static int M, N;
	static int[][] map;
	static int count;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
					cnt++;
				}
			}
		}

		// 토마토가 없을 때
		if(cnt==0) count = -1;
		// 토마토가 이미 다 익어 있을 때
		else if(q.isEmpty())
			count = 0;
		else {
			
			bfs();

			loop: 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						count = -1;
						break loop;
					}
					count = Math.max(count, map[i][j] - 1);
				}
			}
		}
		System.out.println(count);

	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	private static void bfs() {
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int cr = cur[0];
			int cc = cur[1];

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (!(nr >= 0 && nr < N && nc >= 0 && nc < M))
					continue;

				if (map[nr][nc] == 0 || map[nr][nc] > 1) {
					if (map[nr][nc] == 0) {
						q.add(new int[] { nr, nc });
						map[nr][nc] = map[cr][cc] + 1;
					} else if (map[cr][cc] + 1 < map[nr][nc]) {
						map[nr][nc] = map[cr][cc] + 1;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}

	}

}
