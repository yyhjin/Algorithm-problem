import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1956_운동 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 987654321;

		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V + 1][V + 1];

		for (int i = 1; i < V + 1; i++) {
			for (int j = 1; j < V + 1; j++) {
				if (i == j)
					continue;
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;

		}

		for (int k = 1; k < V + 1; k++) {
			for (int i = 1; i < V + 1; i++) {
				if(i==k) continue;
				for (int j = 1; j < V + 1; j++) {
					if(j==k || j==i) continue;
					if(map[i][j] > map[i][k] + map[k][j])
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int min = INF;
		for (int i = 1; i < V+1; i++) {
			for (int j = 1; j < V+1; j++) {
				if(i==j || map[i][j]==INF || map[j][i] == INF) continue;
				min = Math.min(min, map[i][j]+map[j][i]);
			}
		}

		if(min==INF) min = -1;
		System.out.println(min);
		
	}

}
