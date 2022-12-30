import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 987654321;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i==j) continue;
				map[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				if(i==k) continue;
				for (int j = 1; j < N+1; j++) {
					if(j==k || j==i) continue;
					if(map[i][j] > map[i][k]+map[k][j])
						map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		
		int min = INF;
		for (int i = 1; i < N+1; i++) {
			int sum = 0;
			for (int j = 1; j < N+1; j++) {
				sum += map[i][j];
			}
			map[i][0] = sum;
			min = Math.min(min, sum);
		}
		
		loop:
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][0] == min) {
					System.out.println(i);
					break loop;
				}
			}
		}

	}

}
