import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_2210_숫자판점프 {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };	
	static String[][] map;
	static ArrayList<String> arr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new String[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(1, i, j, map[i][j]);
			}
		}

		System.out.println(arr.size());
	}

	private static void dfs(int depth, int r, int c, String str) {
		if(depth == 6) {
			System.out.println(str);
			if(!arr.contains(str)) arr.add(str);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(nr>=0 && nc>=0 && nr<5 && nc<5)) continue;
			dfs(depth+1, nr, nc, str+map[nr][nc]);
		}
	}

}
