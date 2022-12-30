import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Silver1

public class Main_1189_컴백홈 {

	static int R, C, K;
	static char[][] map;
	static boolean[][] v;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		v[R-1][0] = true;
		back(0,new int[] {R-1, 0});
		System.out.println(count);
	}

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static void back(int cnt, int[] current) {
		// 시작점도 K에 포함되므로
		if(cnt == K-1) {
			if(current[0] == 0 && current[1] == C-1) 
				count++;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = current[0] + dr[d];
			int nc = current[1] + dc[d];
			
			if(!(nr>=0 && nc>=0 && nr<R && nc<C) || v[nr][nc] || map[nr][nc]=='T') 
				continue;
			
			v[nr][nc] = true;
			back(cnt+1, new int[] {nr, nc});
			v[nr][nc] = false;
			
		}
	}


}
