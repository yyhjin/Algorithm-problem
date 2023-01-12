import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int n = 0; n < N-7; n++) {
			for (int m = 0; m < M-7; m++) {
				
				int count1 = 0;
				int count2 = 0;
				
				for (int i = n; i < n+8; i++) {
					if(i >= N) break;
					
					boolean black = true; // 처음이 B
					boolean white = true; // 처음이 W
					
					if(i%2 != 0) {
						black = false;
						white = false;
					}
					
					for (int j = m; j < m+8; j++) {
						if(j >= M) break;
						
						// 처음이 B
						if((black && map[i][j]=='W') || (!black && map[i][j]=='B'))
							count1++;
						
						// 처음이 W
						if((white && map[i][j]=='B') || (!white && map[i][j]=='W'))
							count2++;
						
						black = !black;
						white = !white;
					}
				}
				
				int temp = Math.min(count1, count2);
				min = Math.min(min, temp);
			}
			
		}
		
		System.out.println(min);
		
	}

}
