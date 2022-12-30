import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {

	static int N, E, V1, V2;
	static int[] dist;
	static final int INF = 999999999;
	static ArrayList<Node>[] costs;
	
	public static class Node implements Comparable<Node> {
		int index;
		int weight;
		
		Node(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());	
		costs = new ArrayList[N+1];
				
		for (int i = 0; i < N+1; i++) {
			costs[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			costs[a].add(new Node(b, c));
			costs[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		
		if(E == 0) {
			System.out.println(-1);
		}
		else {
			int sum = 0;
			
			int StoV1 = dijkstra(1, V1);
			int V1toV2 = dijkstra(V1, V2);
			int V2toE = dijkstra(V2, N);
			
			int StoV2 = dijkstra(1, V2);
			int V2toV1 = dijkstra(V2, V1);
			int V1toE = dijkstra(V1, N);
			
			sum = Math.min(StoV1 + V1toV2 + V2toE, StoV2 + V2toV1 + V1toE);
			
			if(sum > INF)
				System.out.println(-1);
			else
				System.out.println(sum);
		}
		
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);

		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int curI = current.index;
			int curW = current.weight;
			
			if(dist[curI] < curW) continue;
			
			for (int i = 0; i < costs[curI].size(); i++) {
				int cost = costs[curI].get(i).weight + dist[curI];
				
				if(cost < dist[costs[curI].get(i).index]) {
					dist[costs[curI].get(i).index] = cost;
					pq.add(new Node(costs[curI].get(i).index, cost));
				}
			}
		}
		
		return dist[end];
	}

}
