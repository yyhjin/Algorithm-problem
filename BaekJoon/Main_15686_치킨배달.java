import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int min = Integer.MAX_VALUE;
	static ArrayList<int[]> house = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					house.add(new int[] {i, j});
			}
		}
		
		combi(0,0);
		System.out.println(min);
	}

	private static void combi(int cnt, int start) {
		if (cnt==M) {
			int sum = 0;
			
			for (int k = 0; k < house.size(); k++) {
				int[] cur = house.get(k);
				int cr = cur[0];
				int cc = cur[1];
				
				int minD = Integer.MAX_VALUE;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==3) {
							int distance = Math.abs(cr-i) + Math.abs(cc-j);
							minD = Math.min(minD, distance);
						}
					}
				}
				sum += minD;
			}
			
			min = Math.min(min, sum);			
			return;
		}
		
		for (int i = start; i < N*N; i++) {
			int r = i/N;
			int c = i%N;
			
			if (map[r][c] == 2) {
				map[r][c] = 3;
				combi(cnt+1, i+1);
				map[r][c] = 2;
			}
		}
		
	}

}