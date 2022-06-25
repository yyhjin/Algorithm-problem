import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {

	static int N, M;
	static int[] dist;
	static final int INF = 987654321;
	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	
	public static class Node implements Comparable<Node> {
		int index;
		int weight;
		
		public Node(int index, int weight) {
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Node(end, cost));
			list.get(end).add(new Node(start, cost));
		}
		
		dijkstra(1);

		System.out.println(dist[N]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 시작노드 경로 0으로 설정
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			// 최단거리 노드
			Node cur = pq.poll();
			int curIdx = cur.index;
			int curWeight = cur.weight;
			
			if(dist[curIdx] < curWeight) continue;
			
			for (int i = 0; i < list.get(curIdx).size(); i++) {
				// 현재 최단거리 + 현재 연결된 노드의 비용
				int curCost = dist[curIdx] + list.get(curIdx).get(i).weight;
				
				if(dist[list.get(curIdx).get(i).index] > dist[curIdx] + list.get(curIdx).get(i).weight) {
					dist[list.get(curIdx).get(i).index] = curCost;
					pq.add(new Node(list.get(curIdx).get(i).index, curCost));
				}
			}
		}
		
	}

}
