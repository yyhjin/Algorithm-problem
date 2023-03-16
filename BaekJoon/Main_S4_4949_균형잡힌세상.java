import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S4_4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		String line = "";
		while((line = br.readLine()) != null) {
			if(line.equals(".")) break;
			stack.clear();
			
			boolean balance = true;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c=='(' || c=='[') stack.push(c);
				
				else if(c==')') {
					if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
					else {
						balance = false;
						break;
					}
				}
				else if(c==']') {
					if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
					else {
						balance = false;
						break;
					}
				}
			}
			
			if(balance && stack.isEmpty()) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		System.out.println(sb);
	}

}
