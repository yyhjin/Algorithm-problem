import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) map[i][j] = 0;
				else
					map[i][j] = 99999999;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				if (i==k) continue;
				for (int j = 1; j < N+1; j++) {
					if (j==i || j==k) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (map[i][j] >= 99999999)
					sb.append("0 ");
				else
					sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
