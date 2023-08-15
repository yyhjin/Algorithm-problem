import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_21736_헌내기는_친구가_필요해 {

	static int N, M;
	static int sr, sc;
	static char[][] map;
	static int count;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'I') {
					sr = i;
					sc = j;
				}
			}
		}

		bfs(sr, sc);
		System.out.println(count==0?"TT":count);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		
		q.add(new int[] {r,c});
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<M) || v[nr][nc] || map[nr][nc]=='X')
					continue;
				
				q.add(new int[] {nr,nc});
				v[nr][nc] = true;
				if(map[nr][nc] == 'P') count++;
			}
		}
	}

}
