import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_B4_5357_Dequpe {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			stack.clear();
			String line = br.readLine();
			
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				if(stack.isEmpty()) stack.push(c);
				else if(stack.peek() != c) {
					stack.push(c);
				}
			}
			
			for(char c: stack) sb.append(c);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
