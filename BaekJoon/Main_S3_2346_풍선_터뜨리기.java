import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_S3_2346_풍선_터뜨리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Deque<Balloon> dq = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dq.add(new Balloon(i, Integer.parseInt(st.nextToken())));
		}
		
		while(true) {
			Balloon cur = dq.pollFirst();
			sb.append(cur.idx+" ");
			
			if(dq.isEmpty()) break;
			
			if(cur.count > 0) {
				for (int i = 0; i < cur.count-1; i++) {
					dq.addLast(dq.pollFirst());
				}
			}
			else {
				for (int i = 0; i > cur.count; i--) {
					dq.addFirst(dq.pollLast());
				}				
			}
		}
		
		System.out.println(sb);
	}
	
	public static class Balloon {
		int idx;
		int count;

		public Balloon(int idx, int count) {
			this.idx = idx;
			this.count = count;
		}
	}

}
