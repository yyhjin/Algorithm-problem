import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1613_역사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][]	map = new int[N+1][N+1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = -1;
			map[b][a] = 1;
		}
		
		for (int k = 1; k < N+1; k++) {  // 경유
			for (int i = 1; i < N+1; i++) {  // 출발
				if(i==k) continue;
				for (int j = 1; j < N+1; j++) {  // 도착
					if(j==k || j==i) continue;
					if(map[i][k]==1 && map[k][j]==1) map[i][j] = 1;
					else if(map[i][k]==-1 && map[k][j]==-1) map[i][j] = -1;
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(map[a][b]+"\n");
		}

		System.out.println(sb);
	}

}
