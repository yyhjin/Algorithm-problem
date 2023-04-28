import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G3_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String num = br.readLine();
		
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			if(stack.isEmpty()) stack.push(num.charAt(i));
			else {
				while(!stack.isEmpty() && count < K) {
					if(stack.peek() < num.charAt(i)) {
						stack.pop();
						count++;
					}
					else break;
				}
				stack.push(num.charAt(i));
			}
		}
		
		/* K개만큼 빼지 못했을 경우 
		 * 스택 뒤에 들어온 숫자가 앞의 숫자보다 작은 것이므로 뒤 숫자를 pop
		*/
		if(count != K) {
			while(count != K) {
				stack.pop();
				count++;
			}
		}
		
		for(char c : stack) sb.append(c);
		System.out.println(sb);
	}

}
