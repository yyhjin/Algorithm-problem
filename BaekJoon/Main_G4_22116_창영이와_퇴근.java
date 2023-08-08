import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_22116_창영이와_퇴근 {

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int max;
	
	public static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(max);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		v = new boolean[N][N];
		pq.add(new Node(0,0,0));  // r, c, 바로 전 경사
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			max = Math.max(max, cur.cost);
			v[cr][cc] = true;
			
			if(cr == N-1 && cc == N-1) {
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N) || v[nr][nc]) continue;
				
				int ncost = Math.abs(map[cr][cc]-map[nr][nc]);				
				pq.add(new Node(nr, nc, ncost));
			}
		}
		
	}

}


/*
 * 다익스트라에서 방문 체크는 큐에 넣을 때가 아니라 꺼낼 때 한다.
 * 큐에서 꺼내지기 전까지는 최단 경로를 찾았다고 장담할 수 없기 때문.
 * 큐에서 실제로 꺼내지 않았는데도 방문 체크를 했기 때문에
 * 더 좋은 경로를 뒤늦게 찾아도 방문 체크 때문에 무시된다.
 */

/*
 * 반례 
입력
3
20 15 20
5 10 20
2 1 0

정답
5
*/