import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S3_11899_괄호_끼워넣기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		String line = br.readLine();
		
		for (int i = line.length()-1; i >= 0; i--) {
			if(!stack.isEmpty() && stack.peek() == ')' && line.charAt(i) == '(')
				stack.pop();
			else stack.push(line.charAt(i));
		}
		
		System.out.println(stack.size());
	}

}
