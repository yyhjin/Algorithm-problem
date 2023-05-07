import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1260_DFS와BFS {

	static int N, M, V;
	static boolean[] visit;
	static ArrayList<Integer>[] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s].add(e);
			map[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(map[i]);;
		}
		
		visit = new boolean[N+1];
		dfs(V);
		sb.setLength(sb.length()-1);
		sb.append("\n");
		bfs();
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}


	private static void dfs(int n) {
		sb.append(n+" ");
		visit[n] = true;
		ArrayList<Integer> arr = map[n];
		
		for(int next : arr) {
			if(visit[next]) continue;
			dfs(next);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[N+1];
		q.add(V);
		visit[V] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			ArrayList<Integer> arr = map[cur];
			
			for(int next : arr) {
				if(!visit[next]) {
					q.add(next);
					visit[next] = true;
				}
			}
		}
	}
}
