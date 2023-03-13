import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G4_1922_네트워크연결 {

	public static class Node implements Comparable<Node> {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] arr = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int sum = 0;
		boolean[] v = new boolean[N+1];
		pq.add(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(v[cur.idx]) continue;
			v[cur.idx] = true;
			sum += cur.cost;
			
			for (int i = 0; i < arr[cur.idx].size(); i++) {
				pq.add(arr[cur.idx].get(i));
			}
		}
		
		System.out.println(sum);
	}

}
