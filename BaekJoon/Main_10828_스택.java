import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("push")) {
				int a = Integer.parseInt(st.nextToken());
				stack.push(a);
			}else if(order.equals("pop")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			}else if(order.equals("size")) {
				System.out.println(stack.size());
			}else if(order.equals("empty")) {
				if(stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}else if(order.equals("top")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}

	}

}
