import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S3_20301_반전_요세푸스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		int cnt = 0;
		boolean rotate = false;  // 기본 시계방향
		while(!dq.isEmpty()) {
			if(!rotate) {
				for (int i = 0; i < K-1; i++) {
					dq.addLast(dq.pollFirst());					
				}
			}
			else {
				for (int i = 0; i < K-1; i++) {
					dq.addFirst(dq.pollLast());					
				}				
			}
			
			if(!rotate) sb.append(dq.pollFirst()).append("\n");
			else sb.append(dq.pollLast()).append("\n");
			
			cnt = (cnt+1)%M;
			if(cnt%M == 0)
				rotate = !rotate;
		}
		
		System.out.println(sb);
	}

}
