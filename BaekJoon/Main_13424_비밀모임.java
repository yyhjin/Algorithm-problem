import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_13424_비밀모임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int INF = 987654321;
		int N, M;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
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
				int c = Integer.parseInt(st.nextToken());
				
				map[a][b] = c;
				map[b][a] = c;
			}
			
			int K = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int k = 1; k < N+1; k++) {
				for (int i = 1; i < N+1; i++) {
					if(k==i) continue;
					for (int j = 1; j < N+1; j++) {
						if(i==j || i==k) continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			int min = INF;
			int[] arr = new int[N+1];
			for (Integer i: list) {
				for (int j = 1; j < N+1; j++) {
					arr[j] += map[i][j];
				}
			}
						
			for (int i = 1; i < N+1; i++) {
				min = Math.min(min, arr[i]);
			}
			
			for (int i = 1; i < N+1; i++) {
				if(arr[i]==min) {
					System.out.println(i);
					break;
				}
			}
		
		}

	}

}
