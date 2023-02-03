import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_S2_11725_트리의부모찾기 {
	static int N;
	static boolean[] v;
	static int[] parent;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		v = new boolean[N+1];
		tree = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		v[1] = true;
		dfs(1);
		
		for (int i = 2; i < N+1; i++) {
			sb.append(parent[i]+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}

	private static void dfs(int num) {
		for (int child : tree[num]) {
			if(!v[child]) {
				parent[child] = num;
				v[child] = true;
				dfs(child);
			}
		}
	}

}
