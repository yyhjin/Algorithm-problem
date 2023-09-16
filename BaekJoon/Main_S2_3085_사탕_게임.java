import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S2_3085_사탕_게임 {

	static int N, max;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 아래
				if(i+1 < N) {
					// swap
					char temp = map[i][j];
					map[i][j] = map[i+1][j];
					map[i+1][j] = temp;
					
					rowCount(i);
					rowCount(i+1);
					colCount(j);
					
					// swap
					map[i+1][j] = map[i][j];
					map[i][j] = temp;
				}
				// 오른쪽
				if(j+1 < N) {
					// swap
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					
					rowCount(i);
					colCount(j);
					colCount(j+1);
					
					// swap
					map[i][j+1] = map[i][j];
					map[i][j] = temp;
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void rowCount(int r) {
		int rowMax = 0;
		int count = 1;
		for (int i = 1; i < N; i++) {
			if(map[r][i] == map[r][i-1]) {				
				count++;
				rowMax = Math.max(rowMax, count);
			}
			else {
				rowMax = Math.max(rowMax, count);
				count = 1;
			}
		}
		max = Math.max(max, rowMax);
	}

	static void colCount(int c) {
		int colMax = 0;
		int count = 1;
		for (int i = 1; i < N; i++) {
			if(map[i][c] == map[i-1][c]) {				
				count++;
				colMax = Math.max(colMax, count);
			}
			else {
				colMax = Math.max(colMax, count);
				count = 1;
			}
		}
		max = Math.max(max, colMax);
	}
	
}
