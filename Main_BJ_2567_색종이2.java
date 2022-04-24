package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2567_색종이2 {

	static int[][] map = new int[100 + 2][100 + 2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int result = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken().trim());
			int y = Integer.parseInt(st.nextToken().trim());
			for (int xx = x; xx < x + 10; xx++) {
				for (int yy = y; yy < y + 10; yy++) {
					map[xx][yy]++;
				}
			}

		}

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (map[i][j] != 0) {
					if (check(i, j) == 1)
						result++;
					else if (check(i, j) == 2)
						result += 2;
				}
			}
		}
		System.out.println(result);
	}

	private static int check(int x, int y) {
		int cnt = 0;
		if (map[x - 1][y] == 0) cnt++;
		if (map[x + 1][y] == 0) cnt++;
		if (map[x][y - 1] == 0) cnt++;
		if (map[x][y + 1] == 0) cnt++;
		return cnt;
	}

}
