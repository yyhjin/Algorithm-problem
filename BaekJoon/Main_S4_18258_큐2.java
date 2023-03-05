import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S4_18258_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int lastN = -1;
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				lastN = num;
			}
			else if (order.equals("pop")) {
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.poll()+"\n");
			} 
			else if (order.equals("size")) {
				sb.append(q.size()+"\n");
			} 
			else if (order.equals("empty")) {
				if(q.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			} 
			else if (order.equals("front")) {
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(q.peek()+"\n");
			} 
			else if (order.equals("back")) {
				if(q.isEmpty()) sb.append("-1\n");
				else sb.append(lastN+"\n");
			}
		}
		
		System.out.println(sb);
	}

}
