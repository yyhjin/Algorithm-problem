import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {

	static int n;
	static int sx, sy, ex, ey;
	static ArrayList<Node> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			list = new ArrayList<>();
			
			n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());	
				
				// 시작점(집)
				if (i==0) {
					sx = a;
					sy = b;
				}
				// 도착점(페스티벌)
				else if (i==n+1) {
					ex = a;
					ey = b;
				}
				// 편의점 좌표
				else
					list.add(new Node(a, b));
			}
			
			boolean answer = bfs();
			System.out.println(answer?"happy":"sad");
			
		}

	}
	
	private static boolean bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[] v = new boolean[n];
		q.add(new Node(sx, sy));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			
			if (Math.abs(cx-ex) + Math.abs(cy-ey) <= 1000)
				return true;
			
			for (int i = 0; i < n; i++) {
				if (v[i]) continue;

				int nx = list.get(i).x;
				int ny = list.get(i).y;
				
				int distance = Math.abs(cx-nx) + Math.abs(cy-ny);
				
				if  (distance <= 1000) {
					v[i] = true;
					q.add(new Node(nx, ny));
				}
				
			}
		}
		
		return false;
	}


}

class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
