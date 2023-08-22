import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S3_17952_과제는_끝나지_않아 {

	public static class Node {
		int score;
		int time;
		
		public Node(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Node> stack = new Stack<>();
		
		Node cur = new Node(0,0);
		int total = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int work = Integer.parseInt(st.nextToken());
			
			if(work == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				Node next = new Node(A, T);
				
				if(cur.score == 0)
					cur = next;
				else {
					stack.push(cur);
					cur = next;
				}
			}
			
			cur.time--;
			if(cur.time == 0) {
				total += cur.score;
				if(!stack.isEmpty()) {
					cur = stack.pop();
				}
			}
		}
		
		System.out.println(total);
	}

}
