import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10159_저울 {
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		// 자기 자신도 알 수 있는 것이므로
		for(int i = 1; i < N+1; i++) {
			map[i][i] = 1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}

		for (int k = 1; k < N+1; k++) {  // 경유
			for (int i = 1; i < N+1; i++) {  // 출발
				if(i==k) continue;
				for (int j = 1; j < N+1; j++) {  //도착
					if(i==j || j==k) continue;
					if(map[i][k]==1 && map[k][j]==1)
						map[i][j] = 1;
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(map[i][j]!=1 && map[j][i]!=1)
					map[i][0]++;
			}
			sb.append(map[i][0]+"\n");
		}
		
		System.out.println(sb);
	}

}
