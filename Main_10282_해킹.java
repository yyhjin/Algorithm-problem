import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Gold4

public class Main_10282_해킹 {

	static int T, N, D, C;
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

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			costs = new ArrayList[N+1];
			
			for (int i = 0; i < N+1; i++) {
				costs[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				costs[b].add(new Node(a, s));
			}
			
			dijkstra();
			
			int count = 0;
			int time = 0;
			for (int i = 1; i < N+1; i++) {
				if(dist[i] == INF) continue;
				time = Math.max(time, dist[i]);
				count++;
			}
			System.out.println(count+" "+time);
		}
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		pq.add(new Node(C,0));
		dist[C] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curI = cur.index;
			int curW = cur.weight;
			
			if(dist[curI] < curW) continue;
			
			for (int i = 0; i < costs[curI].size(); i++) {
				int new_cost = dist[curI] + costs[curI].get(i).weight;
				
				if(new_cost < dist[costs[curI].get(i).index]) {
					dist[costs[curI].get(i).index] = new_cost;
					pq.add(new Node(costs[curI].get(i).index, new_cost));
				}
			}
		}
	}

}
