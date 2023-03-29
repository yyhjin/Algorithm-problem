import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_2630_색종이만들기 {

	static int N;
	static int[][] map;
	static int blue, white;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private static void divide(int r, int c, int n) {
		int w = 0;
		int b = 0;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(map[i][j] == 1) b++;
				else w++;
			}
		}
		
		if(w == n*n) {
			white++;
			return;
		}
		else if(b == n*n) {
			blue++;
			return;
		}
		else {
			divide(r, c, n/2);
			divide(r, c+(n/2), n/2);
			divide(r+(n/2), c, n/2);
			divide(r+(n/2), c+(n/2), n/2);
		}
	}

}
