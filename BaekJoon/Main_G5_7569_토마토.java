import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_7569_토마토 {

	static int M, N, H;
	static int[][][] map;
	static boolean[][][] v;
	static int[][][] time;
	
	// 위 아래 왼 오 앞 뒤
	static int[] dr = { 0, 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 1, -1, 0, 0, 0, 0 };

	public static class Node {
		int r;
		int c;
		int h;
		
		public Node(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		v = new boolean[N][M][H];
		time = new int[N][M][H];
		
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j][h] = num;
				}
			}			
		}
		
		bfs();
		
		int max = -1;
		loop:
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 토마토가 모두 익지 못했을 때
					if(map[i][j][h] == 0) {
						max = -1;
						break loop;
					}
					max = Math.max(max, time[i][j][h]);
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		// 익은 토마토 큐에 넣기
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j][h] == 1 && !v[i][j][h]) {
						v[i][j][h] = true;
						q.add(new Node(i, j, h));
					}
				}
			}
		}
				
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int d = 0; d < 6; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				int nh = cur.h + dh[d];
				
				if(!(nr>=0 && nc>=0 && nh>=0 && nr<N && nc<M && nh<H)
						|| v[nr][nc][nh] || map[nr][nc][nh] != 0)
					continue;
				
				map[nr][nc][nh] = 1;
				time[nr][nc][nh] = time[cur.r][cur.c][cur.h] + 1;
				v[nr][nc][nh] = true;
				q.add(new Node(nr, nc, nh));
			}
		}
		
	}

}
