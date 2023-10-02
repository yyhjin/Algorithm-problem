import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_23841_데칼코마니 {

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
		
		// 좌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				if(map[i][j] == '.') continue;
				map[i][M-1-j] = map[i][j];
			}
		}
		// 우
		for (int i = 0; i < N; i++) {
			for (int j = M-1; j >= M/2; j--) {
				if(map[i][j] == '.') continue;
				map[i][M-1-j] = map[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
