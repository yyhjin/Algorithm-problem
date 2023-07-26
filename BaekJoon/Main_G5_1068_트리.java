import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_1068_트리 {

	static int N;
	static int[] parent, child;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[N];  // 부모 누군지
		child = new int[N];  // 자식의 수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if(parent[i] == -1) continue;
			child[parent[i]]++;
		}
		
		int r = Integer.parseInt(br.readLine());
		if(parent[r] >= 0) child[parent[r]]--;
		dfs(r);
		
		int leaf = 0;
		for (int i = 0; i < N; i++) {
			if(child[i] == 0) leaf++;
		}
		
		System.out.println(leaf);
	}

	private static void dfs(int remove) {
		child[remove] = -1;
		for (int i = 0; i < N; i++) {
			if(parent[i]==remove) dfs(i);
		}
	}

}

/*
2
-1 0
1 (루트노드 단 하나만 남음)
정답 : 1

9
-1 0 0 5 2 4 4 6 6
4
정답 : 2 (루트 노드에 연결된 1 and 2 가 리프 노드가 됨)

*/