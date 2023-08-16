import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_24445_알고리즘_수업_너비_우선_탐색2 {

	static int N, M, R, cnt;
	static int[] order;
	static boolean[] v;
	static ArrayList<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		order = new int[N+1];
		v = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			graph[s].add(e);
			graph[e].add(s);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}
		
		bfs();
		
		for (int i = 1; i <= N; i++) {
			sb.append(order[i]+"\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		v[R] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			order[cur] = ++cnt;
			
			ArrayList<Integer> arr = graph[cur];
			for(int next : arr) {
				if(v[next]) continue;
				v[next] = true;
				q.add(next);
			}
		}
		
	}

}
