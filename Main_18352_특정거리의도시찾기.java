import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18352_특정거리의도시찾기 {

	static int N, M, K, X;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		costs = new ArrayList[N+1];	
		
		for (int i = 0; i < N+1; i++) {
			costs[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			costs[a].add(new Node(b, 1));
		}
		
		boolean check = false;
		dijkstra(X);
		for (int i = 1; i < N+1; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				check = true;
			}
		}
		if(!check) System.out.println(-1);
	}


	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curI = cur.index;
			int curW = cur.weight;
			
			if(dist[curI] < curW) continue;
			
			for (int i = 0; i < costs[curI].size(); i++) {
				int cost = dist[curI] + costs[curI].get(i).weight;
				if(cost < dist[costs[curI].get(i).index]) {
					dist[costs[curI].get(i).index] = cost;
					pq.add(new Node(costs[curI].get(i).index, cost));	
				}
			}
		}
				
	}

}
