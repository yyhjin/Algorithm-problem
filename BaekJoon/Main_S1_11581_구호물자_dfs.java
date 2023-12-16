import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S1_11581_구호물자_dfs {

	static ArrayList<Integer>[] map;
	static boolean[] v;
	static boolean cycle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		v = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < N; i++) {
			int cnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
		
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i].add(num);
			}
		}
		
		dfs(1);
		
		System.out.println(cycle?"CYCLE":"NO CYCLE");
	}

	public static void dfs(int idx) {	
		if(cycle) return;
		
		v[idx] = true;
		for(int next : map[idx]) {
			if(!v[next]) dfs(next);
			else if(v[next]) cycle = true;
		}
		v[idx] = false;
	}
}
