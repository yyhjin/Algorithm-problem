import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int N;
	static int[] player, choice;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int S, L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		player = new int[N+1];
		choice = new int[N/2];
		for (int i = 1; i <= N; i++) {
			player[i] = i;
		}
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,1);
		System.out.println(min);
	}

	private static void combi(int cnt, int start) {
		if (cnt==N/2) {
			int[] other = new int[N/2];
			int idx = 0;
			S = 0;
			L = 0;
			
			loop:
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < N/2; j++) {
					if (choice[j] == player[i]) continue loop;
				}
				other[idx] = i;
				idx++;
			}
			
			scoreS(choice, 0, 0, new int[2]);
			scoreL(other, 0, 0, new int[2]);
			
			int dif = 0;
			if (S >= L)
				dif = S - L;
			else
				dif = L - S;
			
			min = Math.min(min, dif);
			return;
		}
		for (int i = start; i < N+1; i++) {
			choice[cnt] = i;
			combi(cnt+1, i+1);
			choice[cnt] = 0;
		}
		
	}

	private static void scoreS(int[] choice, int cnt, int start, int[] c) {
		if (cnt==2) {
			int x = c[0];
			int y = c[1];
			
			int score = map[x][y] + map[y][x];
			
			S += score;
			return;
		}
		for (int i = start; i < N/2; i++) {
			c[cnt] = choice[i];
			scoreS(choice, cnt+1, i+1, c);
			c[cnt] = 0;
		}
		
	}
	
	private static void scoreL(int[] other, int cnt, int start, int[] c) {
		if (cnt==2) {
			int x = c[0];
			int y = c[1];
			
			int score = map[x][y] + map[y][x];
			L += score;
			
			return;
		}
		for (int i = start; i < N/2; i++) {
			c[cnt] = other[i];
			scoreL(other, cnt+1, i+1, c);
			c[cnt] = 0;
		}
		
	}

}
