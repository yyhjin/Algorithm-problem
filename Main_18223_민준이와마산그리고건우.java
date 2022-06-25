import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_18223_민준이와마산그리고건우 {

	static int V, E, P;
	static int[] dist, path;
	static final int INF = 999999999;
	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	static Stack<Integer> stack = new Stack<>();
	
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
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dist = new int[V+1];
		path = new int[V+1];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < V+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, cost));
			list.get(end).add(new Node(start, cost));
		}
		
		int all = dijkstra(1, V);
		int StoP = dijkstra(1, P);
		int PtoE = dijkstra(P, V);
		//System.out.println(all+" "+StoP+" "+PtoE);
		if(all == StoP + PtoE)
			System.out.println("SAVE HIM");
		else
			System.out.println("GOOD BYE");
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		path[start] = -1;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curI = cur.index;
			int curW = cur.weight;
			
			if(dist[curI] < curW) continue;
			
			for (int i = 0; i < list.get(curI).size(); i++) {
				int cost = dist[curI] + list.get(curI).get(i).weight;
				
				if(cost < dist[list.get(curI).get(i).index]) {
					dist[list.get(curI).get(i).index] = cost;
					pq.add(new Node(list.get(curI).get(i).index, cost));
				}
			}
		}

		return dist[end];
		
	}

}
