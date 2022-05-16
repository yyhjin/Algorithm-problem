import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_참고 {

	static int N, M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static boolean[] v;
	
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
				else if(map[i][j]==2)
					chicken.add(new int[] {i,j});
			}
		}
		v = new boolean[chicken.size()];
		
		combi(0,0);
		System.out.println(min);
	}

	private static void combi(int cnt, int start) {
		if (cnt==M) {
			int sum = 0;
			
			for (int i = 0; i < house.size(); i++) {
				int[] curh = house.get(i);
				int hr = curh[0];
				int hc = curh[1];
				
				int minD = Integer.MAX_VALUE;
				
				for (int j = 0; j < chicken.size(); j++) {
					if(!v[j]) continue;
					
					int[] curc = chicken.get(j);
					int cr = curc[0];
					int cc = curc[1];
					int distance = Math.abs(hr-cr) + Math.abs(hc-cc);
					minD = Math.min(minD, distance);
					
				}

				sum += minD;
			}
			min = Math.min(min, sum);			
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				combi(cnt+1, i+1);
				v[i] = false;
			}
			
		}
		
	}

}