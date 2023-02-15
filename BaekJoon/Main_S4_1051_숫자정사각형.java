import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S4_1051_숫자정사각형 {

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
		
		int max = 0;
		int possibleSize = Math.min(N, M);
		for (int k = 1; k <= possibleSize; k++) {  // 정사각형 크기
			for (int i = 0; i <= N-k; i++) {  // 행
				for (int j = 0; j <= M-k; j++) {  // 열
					if(map[i][j] == map[i][j+k-1] 
							&& map[i][j+k-1] == map[i+k-1][j]
									&& map[i+k-1][j] == map[i+k-1][j+k-1])
					{
						max = Math.max(max, k*k);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
