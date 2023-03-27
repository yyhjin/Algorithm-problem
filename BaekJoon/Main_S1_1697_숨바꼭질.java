import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 {

	static int N, K;
	static int[] map;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[200001];
		v = new boolean[200001];
		
		bfs();
		System.out.println(map[K]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		v[N] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
						
			if(cur-1>=0 && cur-1<200001 && !v[cur-1]) {
				map[cur-1] = map[cur]+1;
				q.add(cur-1);
				v[cur-1] = true;
			}
			if(cur+1>=0 && cur+1<200001 && !v[cur+1]) {
				map[cur+1] = map[cur]+1;
				q.add(cur+1);
				v[cur+1] = true;
			}
			if(cur*2>=0 && cur*2<200001 && !v[cur*2]) {
				map[cur*2] = map[cur]+1;
				q.add(cur*2);
				v[cur*2] = true;
			}
		}
		
	}

}
