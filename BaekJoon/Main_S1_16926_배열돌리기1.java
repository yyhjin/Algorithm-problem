import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 };  // 하 우 상 좌
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			rotate();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

	}

	private static void rotate() {
		int x = Math.min(N, M);
		
		for (int i = 0; i < x/2; i++) {
			int r = i;
			int c = i;
			int d = 0;
			
			int cur = 0;
			int prev = map[i][i];
			while(d<4) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!(nr>=0+i && nc>=0+i && nr<N-i && nc<M-i)) {
					d++;
					continue;
				}
				
				cur = map[nr][nc];
				map[nr][nc] = prev;
				prev = cur;
				r = nr;
				c = nc;
			}	
		}
	}

}
