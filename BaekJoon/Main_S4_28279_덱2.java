import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S4_28279_덱2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> dq = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}
			else if(order == 2) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}
			else if(order == 3) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.pollFirst()+"\n");
			}
			else if(order == 4) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.pollLast()+"\n");				
			}
			else if(order == 5) {
				sb.append(dq.size()+"\n");
			}
			else if(order == 6) {
				if(dq.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(order == 7) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekFirst()+"\n");
			}
			else if(order == 8) {
				if(dq.isEmpty()) sb.append("-1\n");
				else sb.append(dq.peekLast()+"\n");				
			}
		}

		System.out.println(sb);
	}

}
