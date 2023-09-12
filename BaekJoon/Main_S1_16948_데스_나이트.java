import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_16948_데스_나이트 {

	static int N;
	static int er, ec;
	static int[][] cnt;
	static boolean[][] v;
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 987654321;

		N = Integer.parseInt(br.readLine());
		cnt = new int[N][N];
		v = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(cnt[i], INF);
		}
		
		bfs(sr, sc);
		System.out.println(cnt[er][ec]>=INF?-1:cnt[er][ec]);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		v[r][c] = true;
		cnt[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 6; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N) || v[nr][nc])
					continue;
				
				cnt[nr][nc] = Math.min(cnt[nr][nc], cnt[cr][cc]+1);
				if(nr == er && nc == ec) break;
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
	}

}
