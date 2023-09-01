import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_S2_24480_알고리즘_수업_깊이_우선_탐색2 {

	static int N, M, R, count;
	static ArrayList<Integer>[] map;
	static int[] order;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		order = new int[N+1];
		v = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(map[i], Collections.reverseOrder());
		}

		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dfs(int node) {
		if(v[node]) return;
		
		v[node] = true;
		order[node] = ++count;
		
		for(int next: map[node]) {
			dfs(next);
		}
	}

}
