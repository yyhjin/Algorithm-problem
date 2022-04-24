import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int N, M, max;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0);
		System.out.println(max);
		
	}

	// 조합으로 벽 세울 곳 3군데 정함
	private static void combi(int cnt, int start) {
		if(cnt==3) {
			// 바이러스를 퍼트릴 배열
			int[][] cp = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				cp[i] = Arrays.copyOf(map[i], M);
			}
			
			// 바이러스 퍼트림
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==2) {
						cp = bfs(i,j, cp);
					}
				}		
			}
			
			// 안전 영역 개수 세기
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cp[i][j]==0) count++;
				}
			}
			
			// 안전지대 최대값으로 갱신
			max = Math.max(max, count);
			return;
		}
		for (int i = start; i < N*M; i++) {
			int r = i/M;
			int c = i%M;
			
			if(map[r][c]==0) {
				map[r][c] = 3;
				combi(cnt+1, start+1);
				map[r][c] = 0;
			}
			
		}
		
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static int[][] bfs(int r, int c, int[][] copy) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nr<N && nc>=0 && nc<M) || v[nr][nc] || copy[nr][nc]!=0)
					continue;
				
				copy[nr][nc] = 2;
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
				
			}
		}
		return copy;
		
	}

}
