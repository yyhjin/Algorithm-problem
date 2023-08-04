import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_S4_28278_스택2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(order == 2) {
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop()+"\n");
			}
			else if(order == 3)
				sb.append(stack.size()+"\n");
			else if(order == 4) {
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(order == 5) {
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek()+"\n");				
			}
		}
		
		System.out.println(sb);
	}

}
